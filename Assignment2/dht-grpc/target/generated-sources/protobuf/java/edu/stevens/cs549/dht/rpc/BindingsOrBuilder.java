// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: dht.proto

package edu.stevens.cs549.dht.rpc;

public interface BindingsOrBuilder extends
    // @@protoc_insertion_point(interface_extends:Bindings)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>string key = 1;</code>
   * @return The key.
   */
  java.lang.String getKey();
  /**
   * <code>string key = 1;</code>
   * @return The bytes for key.
   */
  com.google.protobuf.ByteString
      getKeyBytes();

  /**
   * <code>repeated string value = 2;</code>
   * @return A list containing the value.
   */
  java.util.List<java.lang.String>
      getValueList();
  /**
   * <code>repeated string value = 2;</code>
   * @return The count of value.
   */
  int getValueCount();
  /**
   * <code>repeated string value = 2;</code>
   * @param index The index of the element to return.
   * @return The value at the given index.
   */
  java.lang.String getValue(int index);
  /**
   * <code>repeated string value = 2;</code>
   * @param index The index of the value to return.
   * @return The bytes of the value at the given index.
   */
  com.google.protobuf.ByteString
      getValueBytes(int index);
}
