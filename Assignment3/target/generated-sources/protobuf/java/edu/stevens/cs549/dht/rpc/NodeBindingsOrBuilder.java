// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: dht.proto

package edu.stevens.cs549.dht.rpc;

public interface NodeBindingsOrBuilder extends
    // @@protoc_insertion_point(interface_extends:NodeBindings)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>.NodeInfo info = 1;</code>
   * @return Whether the info field is set.
   */
  boolean hasInfo();
  /**
   * <code>.NodeInfo info = 1;</code>
   * @return The info.
   */
  edu.stevens.cs549.dht.rpc.NodeInfo getInfo();
  /**
   * <code>.NodeInfo info = 1;</code>
   */
  edu.stevens.cs549.dht.rpc.NodeInfoOrBuilder getInfoOrBuilder();

  /**
   * <code>.NodeInfo succ = 2;</code>
   * @return Whether the succ field is set.
   */
  boolean hasSucc();
  /**
   * <code>.NodeInfo succ = 2;</code>
   * @return The succ.
   */
  edu.stevens.cs549.dht.rpc.NodeInfo getSucc();
  /**
   * <code>.NodeInfo succ = 2;</code>
   */
  edu.stevens.cs549.dht.rpc.NodeInfoOrBuilder getSuccOrBuilder();

  /**
   * <code>repeated .Bindings bindings = 3;</code>
   */
  java.util.List<edu.stevens.cs549.dht.rpc.Bindings> 
      getBindingsList();
  /**
   * <code>repeated .Bindings bindings = 3;</code>
   */
  edu.stevens.cs549.dht.rpc.Bindings getBindings(int index);
  /**
   * <code>repeated .Bindings bindings = 3;</code>
   */
  int getBindingsCount();
  /**
   * <code>repeated .Bindings bindings = 3;</code>
   */
  java.util.List<? extends edu.stevens.cs549.dht.rpc.BindingsOrBuilder> 
      getBindingsOrBuilderList();
  /**
   * <code>repeated .Bindings bindings = 3;</code>
   */
  edu.stevens.cs549.dht.rpc.BindingsOrBuilder getBindingsOrBuilder(
      int index);
}