package edu.stevens.cs549.dht.main;

import com.google.protobuf.Empty;
import edu.stevens.cs549.dht.activity.DhtBase;
import edu.stevens.cs549.dht.rpc.Binding;
import edu.stevens.cs549.dht.rpc.Bindings;
import edu.stevens.cs549.dht.rpc.DhtServiceGrpc;
import edu.stevens.cs549.dht.rpc.Id;
import edu.stevens.cs549.dht.rpc.Key;
import edu.stevens.cs549.dht.rpc.NodeBindings;
import edu.stevens.cs549.dht.rpc.NodeInfo;
import io.grpc.ChannelCredentials;
import io.grpc.Grpc;
import io.grpc.InsecureChannelCredentials;
import io.grpc.ManagedChannel;
import java.util.logging.Level;
import java.util.logging.Logger;

import io.grpc.StatusRuntimeException;
import jdk.jshell.spi.ExecutionControl.NotImplementedException;

public class WebClient {
	
	private static final String TAG = WebClient.class.getCanonicalName();

	private Logger logger = Logger.getLogger(TAG);

	private void error(String msg, Exception e) {
		logger.log(Level.SEVERE, msg, e);
	}

	/*
	 * Encapsulate Web client operations here.
	 * 
	 * TODO: Fill in missing operations.
	 */

	/*
	 * A generic interface for a web service call, once a stub is obtained.
	 */
	public interface ClientCall<T> {
		public T execute(DhtServiceGrpc.DhtServiceBlockingStub stub);
	}

	/*
	 * Wrap a service call with the boilerplate logic for creating the channel and stub,
	 * then shutting down the channel when the call is complete.
	 */
	private <T> T call(String targetHost, int targetPort, ClientCall<T> client) {
		ChannelCredentials credentials = InsecureChannelCredentials.create();
		ManagedChannel channel = Grpc.newChannelBuilderForAddress(targetHost, targetPort, credentials).build();
		try {
			return client.execute(DhtServiceGrpc.newBlockingStub(channel));
		} finally {
			channel.shutdown();
		}
	}

	private <T> T call(NodeInfo target, ClientCall<T> client) {
		return call(target.getHost(), target.getPort(), client);
	}

	private void info(String mesg) {
		Log.weblog(TAG, mesg);
	}


	/*
	 * Get the predecessor pointer at a node.
	 */
	public NodeInfo getPred(NodeInfo node) {
		return call(node, (stub) -> stub.getPred(Empty.getDefaultInstance()));
	}

	public NodeBindings notify(NodeInfo node, NodeBindings predDb) {
		return call(node, (stub) -> stub.notify(predDb));
	}
	public NodeInfo getSucc(NodeInfo node) {
		return call(node, (stub) -> stub.getSucc(Empty.getDefaultInstance()));
	}
	public NodeInfo closestPrecedingFinger(NodeInfo node, int id) {
		return call(node, (stub) -> stub.closestPrecedingFinger(Id.newBuilder().setId(id).build()));
	}
	public NodeInfo findSuccessor(String targetHost, int targetPort, int id) {
		return call(targetHost, targetPort, (stub) ->  stub.findSuccessor(Id.newBuilder().setId(id).build()));
	}
	public String[] get(NodeInfo node, String skey) {
		return call(node, (stub) -> stub.getBindings(Key.newBuilder().setKey(skey).build()).getValueList().toArray(new String[0]));
	}
	public void add(NodeInfo node, String skey, String v) {
		call(node, (stub) -> stub.addBinding(Binding.newBuilder().setKey(skey).setValue(v).build()));
	}
	public void delete(NodeInfo node, String skey, String v) {
		call(node, (stub) -> stub.deleteBinding(Binding.newBuilder().setKey(skey).setValue(v).build()));
	}

}
