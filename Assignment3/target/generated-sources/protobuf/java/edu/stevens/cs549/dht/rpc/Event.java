// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: dht.proto

package edu.stevens.cs549.dht.rpc;

/**
 * Protobuf type {@code Event}
 */
public final class Event extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:Event)
    EventOrBuilder {
private static final long serialVersionUID = 0L;
  // Use Event.newBuilder() to construct.
  private Event(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private Event() {
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new Event();
  }

  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return edu.stevens.cs549.dht.rpc.Dht.internal_static_Event_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return edu.stevens.cs549.dht.rpc.Dht.internal_static_Event_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            edu.stevens.cs549.dht.rpc.Event.class, edu.stevens.cs549.dht.rpc.Event.Builder.class);
  }

  private int bindingEventCase_ = 0;
  @SuppressWarnings("serial")
  private java.lang.Object bindingEvent_;
  public enum BindingEventCase
      implements com.google.protobuf.Internal.EnumLite,
          com.google.protobuf.AbstractMessage.InternalOneOfEnum {
    NEWBINDING(1),
    MOVEDBINDING(2),
    BINDINGEVENT_NOT_SET(0);
    private final int value;
    private BindingEventCase(int value) {
      this.value = value;
    }
    /**
     * @param value The number of the enum to look for.
     * @return The enum associated with the given number.
     * @deprecated Use {@link #forNumber(int)} instead.
     */
    @java.lang.Deprecated
    public static BindingEventCase valueOf(int value) {
      return forNumber(value);
    }

    public static BindingEventCase forNumber(int value) {
      switch (value) {
        case 1: return NEWBINDING;
        case 2: return MOVEDBINDING;
        case 0: return BINDINGEVENT_NOT_SET;
        default: return null;
      }
    }
    public int getNumber() {
      return this.value;
    }
  };

  public BindingEventCase
  getBindingEventCase() {
    return BindingEventCase.forNumber(
        bindingEventCase_);
  }

  public static final int NEWBINDING_FIELD_NUMBER = 1;
  /**
   * <code>.Binding newBinding = 1;</code>
   * @return Whether the newBinding field is set.
   */
  @java.lang.Override
  public boolean hasNewBinding() {
    return bindingEventCase_ == 1;
  }
  /**
   * <code>.Binding newBinding = 1;</code>
   * @return The newBinding.
   */
  @java.lang.Override
  public edu.stevens.cs549.dht.rpc.Binding getNewBinding() {
    if (bindingEventCase_ == 1) {
       return (edu.stevens.cs549.dht.rpc.Binding) bindingEvent_;
    }
    return edu.stevens.cs549.dht.rpc.Binding.getDefaultInstance();
  }
  /**
   * <code>.Binding newBinding = 1;</code>
   */
  @java.lang.Override
  public edu.stevens.cs549.dht.rpc.BindingOrBuilder getNewBindingOrBuilder() {
    if (bindingEventCase_ == 1) {
       return (edu.stevens.cs549.dht.rpc.Binding) bindingEvent_;
    }
    return edu.stevens.cs549.dht.rpc.Binding.getDefaultInstance();
  }

  public static final int MOVEDBINDING_FIELD_NUMBER = 2;
  /**
   * <code>.google.protobuf.Empty movedBinding = 2;</code>
   * @return Whether the movedBinding field is set.
   */
  @java.lang.Override
  public boolean hasMovedBinding() {
    return bindingEventCase_ == 2;
  }
  /**
   * <code>.google.protobuf.Empty movedBinding = 2;</code>
   * @return The movedBinding.
   */
  @java.lang.Override
  public com.google.protobuf.Empty getMovedBinding() {
    if (bindingEventCase_ == 2) {
       return (com.google.protobuf.Empty) bindingEvent_;
    }
    return com.google.protobuf.Empty.getDefaultInstance();
  }
  /**
   * <code>.google.protobuf.Empty movedBinding = 2;</code>
   */
  @java.lang.Override
  public com.google.protobuf.EmptyOrBuilder getMovedBindingOrBuilder() {
    if (bindingEventCase_ == 2) {
       return (com.google.protobuf.Empty) bindingEvent_;
    }
    return com.google.protobuf.Empty.getDefaultInstance();
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (bindingEventCase_ == 1) {
      output.writeMessage(1, (edu.stevens.cs549.dht.rpc.Binding) bindingEvent_);
    }
    if (bindingEventCase_ == 2) {
      output.writeMessage(2, (com.google.protobuf.Empty) bindingEvent_);
    }
    getUnknownFields().writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (bindingEventCase_ == 1) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(1, (edu.stevens.cs549.dht.rpc.Binding) bindingEvent_);
    }
    if (bindingEventCase_ == 2) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(2, (com.google.protobuf.Empty) bindingEvent_);
    }
    size += getUnknownFields().getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof edu.stevens.cs549.dht.rpc.Event)) {
      return super.equals(obj);
    }
    edu.stevens.cs549.dht.rpc.Event other = (edu.stevens.cs549.dht.rpc.Event) obj;

    if (!getBindingEventCase().equals(other.getBindingEventCase())) return false;
    switch (bindingEventCase_) {
      case 1:
        if (!getNewBinding()
            .equals(other.getNewBinding())) return false;
        break;
      case 2:
        if (!getMovedBinding()
            .equals(other.getMovedBinding())) return false;
        break;
      case 0:
      default:
    }
    if (!getUnknownFields().equals(other.getUnknownFields())) return false;
    return true;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    switch (bindingEventCase_) {
      case 1:
        hash = (37 * hash) + NEWBINDING_FIELD_NUMBER;
        hash = (53 * hash) + getNewBinding().hashCode();
        break;
      case 2:
        hash = (37 * hash) + MOVEDBINDING_FIELD_NUMBER;
        hash = (53 * hash) + getMovedBinding().hashCode();
        break;
      case 0:
      default:
    }
    hash = (29 * hash) + getUnknownFields().hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static edu.stevens.cs549.dht.rpc.Event parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static edu.stevens.cs549.dht.rpc.Event parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static edu.stevens.cs549.dht.rpc.Event parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static edu.stevens.cs549.dht.rpc.Event parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static edu.stevens.cs549.dht.rpc.Event parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static edu.stevens.cs549.dht.rpc.Event parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static edu.stevens.cs549.dht.rpc.Event parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static edu.stevens.cs549.dht.rpc.Event parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  public static edu.stevens.cs549.dht.rpc.Event parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }

  public static edu.stevens.cs549.dht.rpc.Event parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static edu.stevens.cs549.dht.rpc.Event parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static edu.stevens.cs549.dht.rpc.Event parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(edu.stevens.cs549.dht.rpc.Event prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code Event}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:Event)
      edu.stevens.cs549.dht.rpc.EventOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return edu.stevens.cs549.dht.rpc.Dht.internal_static_Event_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return edu.stevens.cs549.dht.rpc.Dht.internal_static_Event_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              edu.stevens.cs549.dht.rpc.Event.class, edu.stevens.cs549.dht.rpc.Event.Builder.class);
    }

    // Construct using edu.stevens.cs549.dht.rpc.Event.newBuilder()
    private Builder() {

    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);

    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      bitField0_ = 0;
      if (newBindingBuilder_ != null) {
        newBindingBuilder_.clear();
      }
      if (movedBindingBuilder_ != null) {
        movedBindingBuilder_.clear();
      }
      bindingEventCase_ = 0;
      bindingEvent_ = null;
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return edu.stevens.cs549.dht.rpc.Dht.internal_static_Event_descriptor;
    }

    @java.lang.Override
    public edu.stevens.cs549.dht.rpc.Event getDefaultInstanceForType() {
      return edu.stevens.cs549.dht.rpc.Event.getDefaultInstance();
    }

    @java.lang.Override
    public edu.stevens.cs549.dht.rpc.Event build() {
      edu.stevens.cs549.dht.rpc.Event result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public edu.stevens.cs549.dht.rpc.Event buildPartial() {
      edu.stevens.cs549.dht.rpc.Event result = new edu.stevens.cs549.dht.rpc.Event(this);
      if (bitField0_ != 0) { buildPartial0(result); }
      buildPartialOneofs(result);
      onBuilt();
      return result;
    }

    private void buildPartial0(edu.stevens.cs549.dht.rpc.Event result) {
      int from_bitField0_ = bitField0_;
    }

    private void buildPartialOneofs(edu.stevens.cs549.dht.rpc.Event result) {
      result.bindingEventCase_ = bindingEventCase_;
      result.bindingEvent_ = this.bindingEvent_;
      if (bindingEventCase_ == 1 &&
          newBindingBuilder_ != null) {
        result.bindingEvent_ = newBindingBuilder_.build();
      }
      if (bindingEventCase_ == 2 &&
          movedBindingBuilder_ != null) {
        result.bindingEvent_ = movedBindingBuilder_.build();
      }
    }

    @java.lang.Override
    public Builder clone() {
      return super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof edu.stevens.cs549.dht.rpc.Event) {
        return mergeFrom((edu.stevens.cs549.dht.rpc.Event)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(edu.stevens.cs549.dht.rpc.Event other) {
      if (other == edu.stevens.cs549.dht.rpc.Event.getDefaultInstance()) return this;
      switch (other.getBindingEventCase()) {
        case NEWBINDING: {
          mergeNewBinding(other.getNewBinding());
          break;
        }
        case MOVEDBINDING: {
          mergeMovedBinding(other.getMovedBinding());
          break;
        }
        case BINDINGEVENT_NOT_SET: {
          break;
        }
      }
      this.mergeUnknownFields(other.getUnknownFields());
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      if (extensionRegistry == null) {
        throw new java.lang.NullPointerException();
      }
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            case 10: {
              input.readMessage(
                  getNewBindingFieldBuilder().getBuilder(),
                  extensionRegistry);
              bindingEventCase_ = 1;
              break;
            } // case 10
            case 18: {
              input.readMessage(
                  getMovedBindingFieldBuilder().getBuilder(),
                  extensionRegistry);
              bindingEventCase_ = 2;
              break;
            } // case 18
            default: {
              if (!super.parseUnknownField(input, extensionRegistry, tag)) {
                done = true; // was an endgroup tag
              }
              break;
            } // default:
          } // switch (tag)
        } // while (!done)
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.unwrapIOException();
      } finally {
        onChanged();
      } // finally
      return this;
    }
    private int bindingEventCase_ = 0;
    private java.lang.Object bindingEvent_;
    public BindingEventCase
        getBindingEventCase() {
      return BindingEventCase.forNumber(
          bindingEventCase_);
    }

    public Builder clearBindingEvent() {
      bindingEventCase_ = 0;
      bindingEvent_ = null;
      onChanged();
      return this;
    }

    private int bitField0_;

    private com.google.protobuf.SingleFieldBuilderV3<
        edu.stevens.cs549.dht.rpc.Binding, edu.stevens.cs549.dht.rpc.Binding.Builder, edu.stevens.cs549.dht.rpc.BindingOrBuilder> newBindingBuilder_;
    /**
     * <code>.Binding newBinding = 1;</code>
     * @return Whether the newBinding field is set.
     */
    @java.lang.Override
    public boolean hasNewBinding() {
      return bindingEventCase_ == 1;
    }
    /**
     * <code>.Binding newBinding = 1;</code>
     * @return The newBinding.
     */
    @java.lang.Override
    public edu.stevens.cs549.dht.rpc.Binding getNewBinding() {
      if (newBindingBuilder_ == null) {
        if (bindingEventCase_ == 1) {
          return (edu.stevens.cs549.dht.rpc.Binding) bindingEvent_;
        }
        return edu.stevens.cs549.dht.rpc.Binding.getDefaultInstance();
      } else {
        if (bindingEventCase_ == 1) {
          return newBindingBuilder_.getMessage();
        }
        return edu.stevens.cs549.dht.rpc.Binding.getDefaultInstance();
      }
    }
    /**
     * <code>.Binding newBinding = 1;</code>
     */
    public Builder setNewBinding(edu.stevens.cs549.dht.rpc.Binding value) {
      if (newBindingBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        bindingEvent_ = value;
        onChanged();
      } else {
        newBindingBuilder_.setMessage(value);
      }
      bindingEventCase_ = 1;
      return this;
    }
    /**
     * <code>.Binding newBinding = 1;</code>
     */
    public Builder setNewBinding(
        edu.stevens.cs549.dht.rpc.Binding.Builder builderForValue) {
      if (newBindingBuilder_ == null) {
        bindingEvent_ = builderForValue.build();
        onChanged();
      } else {
        newBindingBuilder_.setMessage(builderForValue.build());
      }
      bindingEventCase_ = 1;
      return this;
    }
    /**
     * <code>.Binding newBinding = 1;</code>
     */
    public Builder mergeNewBinding(edu.stevens.cs549.dht.rpc.Binding value) {
      if (newBindingBuilder_ == null) {
        if (bindingEventCase_ == 1 &&
            bindingEvent_ != edu.stevens.cs549.dht.rpc.Binding.getDefaultInstance()) {
          bindingEvent_ = edu.stevens.cs549.dht.rpc.Binding.newBuilder((edu.stevens.cs549.dht.rpc.Binding) bindingEvent_)
              .mergeFrom(value).buildPartial();
        } else {
          bindingEvent_ = value;
        }
        onChanged();
      } else {
        if (bindingEventCase_ == 1) {
          newBindingBuilder_.mergeFrom(value);
        } else {
          newBindingBuilder_.setMessage(value);
        }
      }
      bindingEventCase_ = 1;
      return this;
    }
    /**
     * <code>.Binding newBinding = 1;</code>
     */
    public Builder clearNewBinding() {
      if (newBindingBuilder_ == null) {
        if (bindingEventCase_ == 1) {
          bindingEventCase_ = 0;
          bindingEvent_ = null;
          onChanged();
        }
      } else {
        if (bindingEventCase_ == 1) {
          bindingEventCase_ = 0;
          bindingEvent_ = null;
        }
        newBindingBuilder_.clear();
      }
      return this;
    }
    /**
     * <code>.Binding newBinding = 1;</code>
     */
    public edu.stevens.cs549.dht.rpc.Binding.Builder getNewBindingBuilder() {
      return getNewBindingFieldBuilder().getBuilder();
    }
    /**
     * <code>.Binding newBinding = 1;</code>
     */
    @java.lang.Override
    public edu.stevens.cs549.dht.rpc.BindingOrBuilder getNewBindingOrBuilder() {
      if ((bindingEventCase_ == 1) && (newBindingBuilder_ != null)) {
        return newBindingBuilder_.getMessageOrBuilder();
      } else {
        if (bindingEventCase_ == 1) {
          return (edu.stevens.cs549.dht.rpc.Binding) bindingEvent_;
        }
        return edu.stevens.cs549.dht.rpc.Binding.getDefaultInstance();
      }
    }
    /**
     * <code>.Binding newBinding = 1;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        edu.stevens.cs549.dht.rpc.Binding, edu.stevens.cs549.dht.rpc.Binding.Builder, edu.stevens.cs549.dht.rpc.BindingOrBuilder> 
        getNewBindingFieldBuilder() {
      if (newBindingBuilder_ == null) {
        if (!(bindingEventCase_ == 1)) {
          bindingEvent_ = edu.stevens.cs549.dht.rpc.Binding.getDefaultInstance();
        }
        newBindingBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            edu.stevens.cs549.dht.rpc.Binding, edu.stevens.cs549.dht.rpc.Binding.Builder, edu.stevens.cs549.dht.rpc.BindingOrBuilder>(
                (edu.stevens.cs549.dht.rpc.Binding) bindingEvent_,
                getParentForChildren(),
                isClean());
        bindingEvent_ = null;
      }
      bindingEventCase_ = 1;
      onChanged();
      return newBindingBuilder_;
    }

    private com.google.protobuf.SingleFieldBuilderV3<
        com.google.protobuf.Empty, com.google.protobuf.Empty.Builder, com.google.protobuf.EmptyOrBuilder> movedBindingBuilder_;
    /**
     * <code>.google.protobuf.Empty movedBinding = 2;</code>
     * @return Whether the movedBinding field is set.
     */
    @java.lang.Override
    public boolean hasMovedBinding() {
      return bindingEventCase_ == 2;
    }
    /**
     * <code>.google.protobuf.Empty movedBinding = 2;</code>
     * @return The movedBinding.
     */
    @java.lang.Override
    public com.google.protobuf.Empty getMovedBinding() {
      if (movedBindingBuilder_ == null) {
        if (bindingEventCase_ == 2) {
          return (com.google.protobuf.Empty) bindingEvent_;
        }
        return com.google.protobuf.Empty.getDefaultInstance();
      } else {
        if (bindingEventCase_ == 2) {
          return movedBindingBuilder_.getMessage();
        }
        return com.google.protobuf.Empty.getDefaultInstance();
      }
    }
    /**
     * <code>.google.protobuf.Empty movedBinding = 2;</code>
     */
    public Builder setMovedBinding(com.google.protobuf.Empty value) {
      if (movedBindingBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        bindingEvent_ = value;
        onChanged();
      } else {
        movedBindingBuilder_.setMessage(value);
      }
      bindingEventCase_ = 2;
      return this;
    }
    /**
     * <code>.google.protobuf.Empty movedBinding = 2;</code>
     */
    public Builder setMovedBinding(
        com.google.protobuf.Empty.Builder builderForValue) {
      if (movedBindingBuilder_ == null) {
        bindingEvent_ = builderForValue.build();
        onChanged();
      } else {
        movedBindingBuilder_.setMessage(builderForValue.build());
      }
      bindingEventCase_ = 2;
      return this;
    }
    /**
     * <code>.google.protobuf.Empty movedBinding = 2;</code>
     */
    public Builder mergeMovedBinding(com.google.protobuf.Empty value) {
      if (movedBindingBuilder_ == null) {
        if (bindingEventCase_ == 2 &&
            bindingEvent_ != com.google.protobuf.Empty.getDefaultInstance()) {
          bindingEvent_ = com.google.protobuf.Empty.newBuilder((com.google.protobuf.Empty) bindingEvent_)
              .mergeFrom(value).buildPartial();
        } else {
          bindingEvent_ = value;
        }
        onChanged();
      } else {
        if (bindingEventCase_ == 2) {
          movedBindingBuilder_.mergeFrom(value);
        } else {
          movedBindingBuilder_.setMessage(value);
        }
      }
      bindingEventCase_ = 2;
      return this;
    }
    /**
     * <code>.google.protobuf.Empty movedBinding = 2;</code>
     */
    public Builder clearMovedBinding() {
      if (movedBindingBuilder_ == null) {
        if (bindingEventCase_ == 2) {
          bindingEventCase_ = 0;
          bindingEvent_ = null;
          onChanged();
        }
      } else {
        if (bindingEventCase_ == 2) {
          bindingEventCase_ = 0;
          bindingEvent_ = null;
        }
        movedBindingBuilder_.clear();
      }
      return this;
    }
    /**
     * <code>.google.protobuf.Empty movedBinding = 2;</code>
     */
    public com.google.protobuf.Empty.Builder getMovedBindingBuilder() {
      return getMovedBindingFieldBuilder().getBuilder();
    }
    /**
     * <code>.google.protobuf.Empty movedBinding = 2;</code>
     */
    @java.lang.Override
    public com.google.protobuf.EmptyOrBuilder getMovedBindingOrBuilder() {
      if ((bindingEventCase_ == 2) && (movedBindingBuilder_ != null)) {
        return movedBindingBuilder_.getMessageOrBuilder();
      } else {
        if (bindingEventCase_ == 2) {
          return (com.google.protobuf.Empty) bindingEvent_;
        }
        return com.google.protobuf.Empty.getDefaultInstance();
      }
    }
    /**
     * <code>.google.protobuf.Empty movedBinding = 2;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        com.google.protobuf.Empty, com.google.protobuf.Empty.Builder, com.google.protobuf.EmptyOrBuilder> 
        getMovedBindingFieldBuilder() {
      if (movedBindingBuilder_ == null) {
        if (!(bindingEventCase_ == 2)) {
          bindingEvent_ = com.google.protobuf.Empty.getDefaultInstance();
        }
        movedBindingBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            com.google.protobuf.Empty, com.google.protobuf.Empty.Builder, com.google.protobuf.EmptyOrBuilder>(
                (com.google.protobuf.Empty) bindingEvent_,
                getParentForChildren(),
                isClean());
        bindingEvent_ = null;
      }
      bindingEventCase_ = 2;
      onChanged();
      return movedBindingBuilder_;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFields(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:Event)
  }

  // @@protoc_insertion_point(class_scope:Event)
  private static final edu.stevens.cs549.dht.rpc.Event DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new edu.stevens.cs549.dht.rpc.Event();
  }

  public static edu.stevens.cs549.dht.rpc.Event getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<Event>
      PARSER = new com.google.protobuf.AbstractParser<Event>() {
    @java.lang.Override
    public Event parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      Builder builder = newBuilder();
      try {
        builder.mergeFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(builder.buildPartial());
      } catch (com.google.protobuf.UninitializedMessageException e) {
        throw e.asInvalidProtocolBufferException().setUnfinishedMessage(builder.buildPartial());
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(e)
            .setUnfinishedMessage(builder.buildPartial());
      }
      return builder.buildPartial();
    }
  };

  public static com.google.protobuf.Parser<Event> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<Event> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public edu.stevens.cs549.dht.rpc.Event getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}
