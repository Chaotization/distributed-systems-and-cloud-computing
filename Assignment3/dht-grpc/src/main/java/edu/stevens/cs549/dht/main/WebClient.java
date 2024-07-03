package edu.stevens.cs549.dht.main;

import com.google.protobuf.Empty;
import edu.stevens.cs549.dht.activity.DhtBase;
import edu.stevens.cs549.dht.events.EventBroadcaster;
import edu.stevens.cs549.dht.events.EventConsumer;
import edu.stevens.cs549.dht.events.EventProducer;
import edu.stevens.cs549.dht.events.IEventListener;
import edu.stevens.cs549.dht.rpc.Binding;
import edu.stevens.cs549.dht.rpc.Bindings;
import edu.stevens.cs549.dht.rpc.DhtServiceGrpc;
import edu.stevens.cs549.dht.rpc.DhtServiceGrpc.DhtServiceBlockingStub;
import edu.stevens.cs549.dht.rpc.DhtServiceGrpc.DhtServiceStub;
import edu.stevens.cs549.dht.rpc.Event;
import edu.stevens.cs549.dht.rpc.Id;
import edu.stevens.cs549.dht.rpc.Key;
import edu.stevens.cs549.dht.rpc.NodeBindings;
import edu.stevens.cs549.dht.rpc.NodeInfo;
import edu.stevens.cs549.dht.rpc.OptNodeBindings;
import edu.stevens.cs549.dht.rpc.OptNodeInfo;
import edu.stevens.cs549.dht.rpc.Subscription;
import edu.stevens.cs549.dht.state.IChannels;
import edu.stevens.cs549.dht.state.IState;
import io.grpc.Channel;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;

import java.util.logging.Level;
import java.util.logging.Logger;

public class WebClient {
	
	private static final String TAG = WebClient.class.getCanonicalName();

	private Logger logger = Logger.getLogger(TAG);

	private IChannels channels;

	private WebClient(IChannels channels) {
		this.channels = channels;
	}

	public static WebClient getInstance(IState state) {
		return new WebClient(state.getChannels());
	}

	private void error(String msg, Exception e) {
		logger.log(Level.SEVERE, msg, e);
	}

	private void info(String mesg) {
		Log.weblog(TAG, mesg);
	}

	/*
	 * Get a blocking stub (channels and stubs are cached for reuse).
	 */
	private DhtServiceBlockingStub getStub(String targetHost, int targetPort) throws DhtBase.Failed {
		Channel channel = channels.getChannel(targetHost, targetPort);
		return DhtServiceGrpc.newBlockingStub(channel);
	}

	private DhtServiceBlockingStub getStub(NodeInfo target) throws DhtBase.Failed {
		return getStub(target.getHost(), target.getPort());
	}

	private DhtServiceStub getListenerStub(String targetHost, int targetPort) throws DhtBase.Failed {
		Channel channel = channels.getChannel(targetHost, targetPort);
		return DhtServiceGrpc.newStub(channel);
	}

	private DhtServiceStub getListenerStub(NodeInfo target) throws DhtBase.Failed {
		return getListenerStub(target.getHost(), target.getPort());
	}


	/*
	 * TODO: Fill in missing operations.
	 */
	public NodeInfo getSucc(NodeInfo node) throws DhtBase.Failed {
		Log.weblog(TAG, "getSucc("+node.getId()+")");
		return getStub(node).getSucc(Empty.getDefaultInstance());
	}
	public NodeInfo closestPrecedingFinger(NodeInfo node, int id) throws DhtBase.Failed {
		Log.weblog(TAG, "closestPrecedingFinger("+id+")");
		return getStub(node).closestPrecedingFinger(Id.newBuilder().setId(id).build());
	}
	public NodeInfo findSuccessor(String targetHost, int targetPort, int id) throws DhtBase.Failed {
		Log.weblog(TAG, "findSuccessor("+id+")");
		return getStub(targetHost, targetPort).findSuccessor(Id.newBuilder().setId(id).build());
	}
	public String[] get(NodeInfo node, String skey) throws DhtBase.Failed {
		Log.weblog(TAG, "getBindings("+node.getId()+")");
		return getStub(node).getBindings(Key.newBuilder().setKey(skey).build()).getValueList().toArray(new String[0]);
	}
	public void add(NodeInfo node, String skey, String v) throws DhtBase.Failed {
		Log.weblog(TAG, "addBinding("+node.getId()+")");
		getStub(node).addBinding(Binding.newBuilder().setKey(skey).setValue(v).build());
	}
	public void delete(NodeInfo node, String skey, String v) throws DhtBase.Failed {
		Log.weblog(TAG, "deleteBinding("+node.getId()+")");
		getStub(node).deleteBinding(Binding.newBuilder().setKey(skey).setValue(v).build());
	}
	/*
	 * Get the predecessor pointer at a node.
	 */
	public OptNodeInfo getPred(NodeInfo node) throws DhtBase.Failed {
		Log.weblog(TAG, "getPred("+node.getId()+")");
		return getStub(node).getPred(Empty.getDefaultInstance());
	}

	/*
	 * Notify node that we (think we) are its predecessor.
	 */
	public OptNodeBindings notify(NodeInfo node, NodeBindings predDb) throws DhtBase.Failed {
		Log.weblog(TAG, "notify("+node.getId()+")");
		// TODO
		/*
		 * The protocol here is more complex than for other operations. We
		 * notify a new successor that we are its predecessor, and expect its
		 * bindings as a result. But if it fails to accept us as its predecessor
		 * (someone else has become intermediate predecessor since we found out
		 * this node is our successor i.e. race condition that we don't try to
		 * avoid because to do so is infeasible), it notifies us by returning
		 * null. This is represented in HTTP by RC=304 (Not Modified).
		 */
		try {
			return getStub(node).notify(predDb);
		} catch (StatusRuntimeException e) {
			throw new DhtBase.Failed("Error in notify: " + e.getStatus());
		} catch (IllegalStateException e) {
			throw new IllegalStateException("notify() not yet implemented");
		}
	}

	/*
	 * Listening for new bindings.
	 */
	public void listenOn(NodeInfo node, Subscription subscription, IEventListener listener) throws DhtBase.Failed {
		Log.weblog(TAG, "listenOn("+node.getId()+")");

		StreamObserver<Event> streamObserver = new StreamObserver<>() {
			@Override
			public void onNext(Event event) {
				if (event.hasNewBinding()) {
					listener.onNewBinding(event.getNewBinding().getKey(), event.getNewBinding().getValue());
				} else if (event.hasMovedBinding()) {
					listener.onMovedBinding(subscription.getKey());
				}
			}

			@Override
			public void onError(Throwable throwable) {
				listener.onError(subscription.getKey(), throwable);
			}

			@Override
			public void onCompleted() {
				listener.onClosed(subscription.getKey());
			}
		};

		getListenerStub(node).listenOn(subscription, streamObserver);
	}

	public void listenOff(NodeInfo node, Subscription subscription) throws DhtBase.Failed {
		Log.weblog(TAG, "listenOff("+node.getId()+")");
		// TODO stop listening for updates on bindings to the key in the subscription

		getStub(node).listenOff(subscription);
	}
	
}
