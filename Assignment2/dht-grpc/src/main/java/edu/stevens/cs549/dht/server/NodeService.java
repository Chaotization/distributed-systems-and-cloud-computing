package edu.stevens.cs549.dht.server;

import com.google.protobuf.Empty;
import edu.stevens.cs549.dht.activity.Dht;
import edu.stevens.cs549.dht.activity.DhtBase;
import edu.stevens.cs549.dht.activity.DhtBase.Failed;
import edu.stevens.cs549.dht.activity.DhtBase.Invalid;
import edu.stevens.cs549.dht.main.Log;
import edu.stevens.cs549.dht.rpc.*;
import edu.stevens.cs549.dht.rpc.DhtServiceGrpc.DhtServiceImplBase;
import edu.stevens.cs549.dht.rpc.NodeInfo;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * Additional resource logic.  The Web resource operations call
 * into wrapper operations here.  The main thing these operations do
 * is to call into the DHT service object, and wrap internal exceptions
 * as HTTP response codes (throwing WebApplicationException where necessary).
 * 
 * This should be merged into NodeResource, then that would be the only
 * place in the app where server-side is dependent on JAX-RS.
 * Client dependencies are in WebClient.
 * 
 * The activity (business) logic is in the dht object, which exposes
 * the IDHTResource interface to the Web service.
 */

public class NodeService extends DhtServiceImplBase {
	
	private static final String TAG = NodeService.class.getCanonicalName();
	
	private static Logger logger = Logger.getLogger(TAG);

	/**
	 * Each service request is processed by a distinct service object.
	 *
	 * Shared state is in the state object; we use the singleton pattern to make sure it is shared.
	 */
	private Dht getDht() {
		return Dht.getDht();
	}
	
	// TODO: add the missing operations

	private void error(String mesg, Exception e) {
		logger.log(Level.SEVERE, mesg, e);
	}

	@Override
	public void getNodeInfo(Empty empty, StreamObserver<NodeInfo> responseObserver) {
		Log.weblog(TAG, "getNodeInfo()");
		responseObserver.onNext(getDht().getNodeInfo());
		responseObserver.onCompleted();
	}
	@Override
	public void getPred(Empty request, StreamObserver<NodeInfo> responseObserver) {
		Log.weblog(TAG, "getPred()");
		responseObserver.onNext(getDht().getPred());
		responseObserver.onCompleted();
	}

	@Override
	public void getSucc(Empty request, StreamObserver<NodeInfo> responseObserver) {
		Log.weblog(TAG, "getSucc()");
		responseObserver.onNext(getDht().getSucc());
		responseObserver.onCompleted();

	}
	@Override
	public void closestPrecedingFinger(Id request, StreamObserver<NodeInfo> responseObserver) {
		Log.weblog(TAG, "closestPrecedingFinger()");
		responseObserver.onNext(getDht().closestPrecedingFinger(request.getId()));
		responseObserver.onCompleted();
	}
	@Override
	public void notify(NodeBindings request, StreamObserver<NodeBindings> responseObserver) {
		Log.weblog(TAG, "notify()");
		responseObserver.onNext(getDht().notify(request));
		responseObserver.onCompleted();

	}
	@Override
	public void getBindings(Key request, StreamObserver<Bindings> responseObserver) {
		Log.weblog(TAG, "getBindings()");
		try {
			String[] result = getDht().get(request.getKey());

			if (result != null) {
				Bindings.Builder bindingsBuilder = Bindings.newBuilder();
				for (String value : result) {
					bindingsBuilder.addValue(value);
				}
				Bindings bindings = bindingsBuilder.build();
				responseObserver.onNext(bindings);
				responseObserver.onCompleted();
			} else {
				responseObserver.onError(Status.NOT_FOUND.asRuntimeException());
			}
		} catch (DhtBase.Invalid e) {
			responseObserver.onError(Status.INVALID_ARGUMENT.asRuntimeException());
		}
	}
	@Override
	public void addBinding(Binding request, StreamObserver<Empty> responseObserver) {
		Log.weblog(TAG, "addBinding()");
		try {
			getDht().add(request.getKey(), request.getValue());
			responseObserver.onNext(Empty.getDefaultInstance());
			responseObserver.onCompleted();
		} catch (DhtBase.Invalid e) {
			responseObserver.onError(Status.INVALID_ARGUMENT.asRuntimeException());
		}
	}
	@Override
	public void deleteBinding(Binding request, StreamObserver<Empty> responseObserver) {
		Log.weblog(TAG, "deleteBinding()");
		try {
			getDht().delete(request.getKey(), request.getValue());
			responseObserver.onNext(Empty.getDefaultInstance());
			responseObserver.onCompleted();
		} catch (DhtBase.Invalid e) {
			responseObserver.onError(Status.INVALID_ARGUMENT.asRuntimeException());
		}
	}
	@Override
	public void findSuccessor(Id request, StreamObserver<NodeInfo> responseObserver) {
		Log.weblog(TAG, "findSuccessor()");

		try {
			NodeInfo nodeInfo = getDht().findSuccessor(request.getId());

			if (nodeInfo != null) {
				responseObserver.onNext(nodeInfo);
				responseObserver.onCompleted();
			} else {
				responseObserver.onError(Status.INTERNAL.asRuntimeException());
			}
		} catch (StatusRuntimeException e) {
			responseObserver.onError(Status.UNIMPLEMENTED.asRuntimeException());
		} catch (DhtBase.Failed e) {
			throw new RuntimeException(e);
		}
	}


}