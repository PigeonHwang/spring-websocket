// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: chat.proto

package com.toy.stompchat.proto;

/**
 * Protobuf type {@code com.toy.stompchat.proto.MessageProto}
 */
public final class MessageProto extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:com.toy.stompchat.proto.MessageProto)
    MessageProtoOrBuilder {
private static final long serialVersionUID = 0L;
  // Use MessageProto.newBuilder() to construct.
  private MessageProto(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private MessageProto() {
    msgType_ = 0;
  }

  @Override
  @SuppressWarnings({"unused"})
  protected Object newInstance(
      UnusedPrivateParameter unused) {
    return new MessageProto();
  }

  @Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private MessageProto(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new NullPointerException();
    }
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          case 8: {
            int rawValue = input.readEnum();

            msgType_ = rawValue;
            break;
          }
          case 18: {
            String s = input.readStringRequireUtf8();
            dataOneofCase_ = 2;
            dataOneof_ = s;
            break;
          }
          case 26: {
            UserProto.Builder subBuilder = null;
            if (dataOneofCase_ == 3) {
              subBuilder = ((UserProto) dataOneof_).toBuilder();
            }
            dataOneof_ =
                input.readMessage(UserProto.parser(), extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom((UserProto) dataOneof_);
              dataOneof_ = subBuilder.buildPartial();
            }
            dataOneofCase_ = 3;
            break;
          }
          case 32: {

            date_ = input.readInt64();
            break;
          }
          default: {
            if (!parseUnknownField(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (com.google.protobuf.UninitializedMessageException e) {
      throw e.asInvalidProtocolBufferException().setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return Chat.internal_static_com_toy_stompchat_proto_MessageProto_descriptor;
  }

  @Override
  protected FieldAccessorTable
      internalGetFieldAccessorTable() {
    return Chat.internal_static_com_toy_stompchat_proto_MessageProto_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            MessageProto.class, Builder.class);
  }

  private int dataOneofCase_ = 0;
  private Object dataOneof_;
  public enum DataOneofCase
      implements com.google.protobuf.Internal.EnumLite,
          InternalOneOfEnum {
    DATA(2),
    USER(3),
    DATAONEOF_NOT_SET(0);
    private final int value;
    private DataOneofCase(int value) {
      this.value = value;
    }
    /**
     * @param value The number of the enum to look for.
     * @return The enum associated with the given number.
     * @deprecated Use {@link #forNumber(int)} instead.
     */
    @Deprecated
    public static DataOneofCase valueOf(int value) {
      return forNumber(value);
    }

    public static DataOneofCase forNumber(int value) {
      switch (value) {
        case 2: return DATA;
        case 3: return USER;
        case 0: return DATAONEOF_NOT_SET;
        default: return null;
      }
    }
    public int getNumber() {
      return this.value;
    }
  };

  public DataOneofCase
  getDataOneofCase() {
    return DataOneofCase.forNumber(
        dataOneofCase_);
  }

  public static final int MSGTYPE_FIELD_NUMBER = 1;
  private int msgType_;
  /**
   * <code>.com.toy.stompchat.proto.MsgTypeEnum msgType = 1;</code>
   * @return The enum numeric value on the wire for msgType.
   */
  @Override public int getMsgTypeValue() {
    return msgType_;
  }
  /**
   * <code>.com.toy.stompchat.proto.MsgTypeEnum msgType = 1;</code>
   * @return The msgType.
   */
  @Override public MsgTypeEnum getMsgType() {
    @SuppressWarnings("deprecation")
    MsgTypeEnum result = MsgTypeEnum.valueOf(msgType_);
    return result == null ? MsgTypeEnum.UNRECOGNIZED : result;
  }

  public static final int DATA_FIELD_NUMBER = 2;
  /**
   * <code>string data = 2;</code>
   * @return Whether the data field is set.
   */
  public boolean hasData() {
    return dataOneofCase_ == 2;
  }
  /**
   * <code>string data = 2;</code>
   * @return The data.
   */
  public String getData() {
    Object ref = "";
    if (dataOneofCase_ == 2) {
      ref = dataOneof_;
    }
    if (ref instanceof String) {
      return (String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      String s = bs.toStringUtf8();
      if (dataOneofCase_ == 2) {
        dataOneof_ = s;
      }
      return s;
    }
  }
  /**
   * <code>string data = 2;</code>
   * @return The bytes for data.
   */
  public com.google.protobuf.ByteString
      getDataBytes() {
    Object ref = "";
    if (dataOneofCase_ == 2) {
      ref = dataOneof_;
    }
    if (ref instanceof String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (String) ref);
      if (dataOneofCase_ == 2) {
        dataOneof_ = b;
      }
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int USER_FIELD_NUMBER = 3;
  /**
   * <code>.com.toy.stompchat.proto.UserProto user = 3;</code>
   * @return Whether the user field is set.
   */
  @Override
  public boolean hasUser() {
    return dataOneofCase_ == 3;
  }
  /**
   * <code>.com.toy.stompchat.proto.UserProto user = 3;</code>
   * @return The user.
   */
  @Override
  public UserProto getUser() {
    if (dataOneofCase_ == 3) {
       return (UserProto) dataOneof_;
    }
    return UserProto.getDefaultInstance();
  }
  /**
   * <code>.com.toy.stompchat.proto.UserProto user = 3;</code>
   */
  @Override
  public UserProtoOrBuilder getUserOrBuilder() {
    if (dataOneofCase_ == 3) {
       return (UserProto) dataOneof_;
    }
    return UserProto.getDefaultInstance();
  }

  public static final int DATE_FIELD_NUMBER = 4;
  private long date_;
  /**
   * <code>int64 date = 4;</code>
   * @return The date.
   */
  @Override
  public long getDate() {
    return date_;
  }

  private byte memoizedIsInitialized = -1;
  @Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (msgType_ != MsgTypeEnum.JOIN.getNumber()) {
      output.writeEnum(1, msgType_);
    }
    if (dataOneofCase_ == 2) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 2, dataOneof_);
    }
    if (dataOneofCase_ == 3) {
      output.writeMessage(3, (UserProto) dataOneof_);
    }
    if (date_ != 0L) {
      output.writeInt64(4, date_);
    }
    unknownFields.writeTo(output);
  }

  @Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (msgType_ != MsgTypeEnum.JOIN.getNumber()) {
      size += com.google.protobuf.CodedOutputStream
        .computeEnumSize(1, msgType_);
    }
    if (dataOneofCase_ == 2) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, dataOneof_);
    }
    if (dataOneofCase_ == 3) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(3, (UserProto) dataOneof_);
    }
    if (date_ != 0L) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt64Size(4, date_);
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof MessageProto)) {
      return super.equals(obj);
    }
    MessageProto other = (MessageProto) obj;

    if (msgType_ != other.msgType_) return false;
    if (getDate()
        != other.getDate()) return false;
    if (!getDataOneofCase().equals(other.getDataOneofCase())) return false;
    switch (dataOneofCase_) {
      case 2:
        if (!getData()
            .equals(other.getData())) return false;
        break;
      case 3:
        if (!getUser()
            .equals(other.getUser())) return false;
        break;
      case 0:
      default:
    }
    if (!unknownFields.equals(other.unknownFields)) return false;
    return true;
  }

  @Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + MSGTYPE_FIELD_NUMBER;
    hash = (53 * hash) + msgType_;
    hash = (37 * hash) + DATE_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        getDate());
    switch (dataOneofCase_) {
      case 2:
        hash = (37 * hash) + DATA_FIELD_NUMBER;
        hash = (53 * hash) + getData().hashCode();
        break;
      case 3:
        hash = (37 * hash) + USER_FIELD_NUMBER;
        hash = (53 * hash) + getUser().hashCode();
        break;
      case 0:
      default:
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static MessageProto parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static MessageProto parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static MessageProto parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static MessageProto parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static MessageProto parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static MessageProto parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static MessageProto parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static MessageProto parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static MessageProto parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static MessageProto parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static MessageProto parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static MessageProto parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(MessageProto prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @Override
  protected Builder newBuilderForType(
      BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code com.toy.stompchat.proto.MessageProto}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:com.toy.stompchat.proto.MessageProto)
      MessageProtoOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return Chat.internal_static_com_toy_stompchat_proto_MessageProto_descriptor;
    }

    @Override
    protected FieldAccessorTable
        internalGetFieldAccessorTable() {
      return Chat.internal_static_com_toy_stompchat_proto_MessageProto_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              MessageProto.class, Builder.class);
    }

    // Construct using com.toy.stompchat.proto.MessageProto.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
      }
    }
    @Override
    public Builder clear() {
      super.clear();
      msgType_ = 0;

      date_ = 0L;

      dataOneofCase_ = 0;
      dataOneof_ = null;
      return this;
    }

    @Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return Chat.internal_static_com_toy_stompchat_proto_MessageProto_descriptor;
    }

    @Override
    public MessageProto getDefaultInstanceForType() {
      return MessageProto.getDefaultInstance();
    }

    @Override
    public MessageProto build() {
      MessageProto result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @Override
    public MessageProto buildPartial() {
      MessageProto result = new MessageProto(this);
      result.msgType_ = msgType_;
      if (dataOneofCase_ == 2) {
        result.dataOneof_ = dataOneof_;
      }
      if (dataOneofCase_ == 3) {
        if (userBuilder_ == null) {
          result.dataOneof_ = dataOneof_;
        } else {
          result.dataOneof_ = userBuilder_.build();
        }
      }
      result.date_ = date_;
      result.dataOneofCase_ = dataOneofCase_;
      onBuilt();
      return result;
    }

    @Override
    public Builder clone() {
      return super.clone();
    }
    @Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        Object value) {
      return super.setField(field, value);
    }
    @Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return super.clearField(field);
    }
    @Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return super.clearOneof(oneof);
    }
    @Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, Object value) {
      return super.setRepeatedField(field, index, value);
    }
    @Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        Object value) {
      return super.addRepeatedField(field, value);
    }
    @Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof MessageProto) {
        return mergeFrom((MessageProto)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(MessageProto other) {
      if (other == MessageProto.getDefaultInstance()) return this;
      if (other.msgType_ != 0) {
        setMsgTypeValue(other.getMsgTypeValue());
      }
      if (other.getDate() != 0L) {
        setDate(other.getDate());
      }
      switch (other.getDataOneofCase()) {
        case DATA: {
          dataOneofCase_ = 2;
          dataOneof_ = other.dataOneof_;
          onChanged();
          break;
        }
        case USER: {
          mergeUser(other.getUser());
          break;
        }
        case DATAONEOF_NOT_SET: {
          break;
        }
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    @Override
    public final boolean isInitialized() {
      return true;
    }

    @Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      MessageProto parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (MessageProto) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int dataOneofCase_ = 0;
    private Object dataOneof_;
    public DataOneofCase
        getDataOneofCase() {
      return DataOneofCase.forNumber(
          dataOneofCase_);
    }

    public Builder clearDataOneof() {
      dataOneofCase_ = 0;
      dataOneof_ = null;
      onChanged();
      return this;
    }


    private int msgType_ = 0;
    /**
     * <code>.com.toy.stompchat.proto.MsgTypeEnum msgType = 1;</code>
     * @return The enum numeric value on the wire for msgType.
     */
    @Override public int getMsgTypeValue() {
      return msgType_;
    }
    /**
     * <code>.com.toy.stompchat.proto.MsgTypeEnum msgType = 1;</code>
     * @param value The enum numeric value on the wire for msgType to set.
     * @return This builder for chaining.
     */
    public Builder setMsgTypeValue(int value) {
      
      msgType_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>.com.toy.stompchat.proto.MsgTypeEnum msgType = 1;</code>
     * @return The msgType.
     */
    @Override
    public MsgTypeEnum getMsgType() {
      @SuppressWarnings("deprecation")
      MsgTypeEnum result = MsgTypeEnum.valueOf(msgType_);
      return result == null ? MsgTypeEnum.UNRECOGNIZED : result;
    }
    /**
     * <code>.com.toy.stompchat.proto.MsgTypeEnum msgType = 1;</code>
     * @param value The msgType to set.
     * @return This builder for chaining.
     */
    public Builder setMsgType(MsgTypeEnum value) {
      if (value == null) {
        throw new NullPointerException();
      }
      
      msgType_ = value.getNumber();
      onChanged();
      return this;
    }
    /**
     * <code>.com.toy.stompchat.proto.MsgTypeEnum msgType = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearMsgType() {
      
      msgType_ = 0;
      onChanged();
      return this;
    }

    /**
     * <code>string data = 2;</code>
     * @return Whether the data field is set.
     */
    @Override
    public boolean hasData() {
      return dataOneofCase_ == 2;
    }
    /**
     * <code>string data = 2;</code>
     * @return The data.
     */
    @Override
    public String getData() {
      Object ref = "";
      if (dataOneofCase_ == 2) {
        ref = dataOneof_;
      }
      if (!(ref instanceof String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        String s = bs.toStringUtf8();
        if (dataOneofCase_ == 2) {
          dataOneof_ = s;
        }
        return s;
      } else {
        return (String) ref;
      }
    }
    /**
     * <code>string data = 2;</code>
     * @return The bytes for data.
     */
    @Override
    public com.google.protobuf.ByteString
        getDataBytes() {
      Object ref = "";
      if (dataOneofCase_ == 2) {
        ref = dataOneof_;
      }
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (String) ref);
        if (dataOneofCase_ == 2) {
          dataOneof_ = b;
        }
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string data = 2;</code>
     * @param value The data to set.
     * @return This builder for chaining.
     */
    public Builder setData(
        String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  dataOneofCase_ = 2;
      dataOneof_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string data = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearData() {
      if (dataOneofCase_ == 2) {
        dataOneofCase_ = 0;
        dataOneof_ = null;
        onChanged();
      }
      return this;
    }
    /**
     * <code>string data = 2;</code>
     * @param value The bytes for data to set.
     * @return This builder for chaining.
     */
    public Builder setDataBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      dataOneofCase_ = 2;
      dataOneof_ = value;
      onChanged();
      return this;
    }

    private com.google.protobuf.SingleFieldBuilderV3<
        UserProto, UserProto.Builder, UserProtoOrBuilder> userBuilder_;
    /**
     * <code>.com.toy.stompchat.proto.UserProto user = 3;</code>
     * @return Whether the user field is set.
     */
    @Override
    public boolean hasUser() {
      return dataOneofCase_ == 3;
    }
    /**
     * <code>.com.toy.stompchat.proto.UserProto user = 3;</code>
     * @return The user.
     */
    @Override
    public UserProto getUser() {
      if (userBuilder_ == null) {
        if (dataOneofCase_ == 3) {
          return (UserProto) dataOneof_;
        }
        return UserProto.getDefaultInstance();
      } else {
        if (dataOneofCase_ == 3) {
          return userBuilder_.getMessage();
        }
        return UserProto.getDefaultInstance();
      }
    }
    /**
     * <code>.com.toy.stompchat.proto.UserProto user = 3;</code>
     */
    public Builder setUser(UserProto value) {
      if (userBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        dataOneof_ = value;
        onChanged();
      } else {
        userBuilder_.setMessage(value);
      }
      dataOneofCase_ = 3;
      return this;
    }
    /**
     * <code>.com.toy.stompchat.proto.UserProto user = 3;</code>
     */
    public Builder setUser(
        UserProto.Builder builderForValue) {
      if (userBuilder_ == null) {
        dataOneof_ = builderForValue.build();
        onChanged();
      } else {
        userBuilder_.setMessage(builderForValue.build());
      }
      dataOneofCase_ = 3;
      return this;
    }
    /**
     * <code>.com.toy.stompchat.proto.UserProto user = 3;</code>
     */
    public Builder mergeUser(UserProto value) {
      if (userBuilder_ == null) {
        if (dataOneofCase_ == 3 &&
            dataOneof_ != UserProto.getDefaultInstance()) {
          dataOneof_ = UserProto.newBuilder((UserProto) dataOneof_)
              .mergeFrom(value).buildPartial();
        } else {
          dataOneof_ = value;
        }
        onChanged();
      } else {
        if (dataOneofCase_ == 3) {
          userBuilder_.mergeFrom(value);
        } else {
          userBuilder_.setMessage(value);
        }
      }
      dataOneofCase_ = 3;
      return this;
    }
    /**
     * <code>.com.toy.stompchat.proto.UserProto user = 3;</code>
     */
    public Builder clearUser() {
      if (userBuilder_ == null) {
        if (dataOneofCase_ == 3) {
          dataOneofCase_ = 0;
          dataOneof_ = null;
          onChanged();
        }
      } else {
        if (dataOneofCase_ == 3) {
          dataOneofCase_ = 0;
          dataOneof_ = null;
        }
        userBuilder_.clear();
      }
      return this;
    }
    /**
     * <code>.com.toy.stompchat.proto.UserProto user = 3;</code>
     */
    public UserProto.Builder getUserBuilder() {
      return getUserFieldBuilder().getBuilder();
    }
    /**
     * <code>.com.toy.stompchat.proto.UserProto user = 3;</code>
     */
    @Override
    public UserProtoOrBuilder getUserOrBuilder() {
      if ((dataOneofCase_ == 3) && (userBuilder_ != null)) {
        return userBuilder_.getMessageOrBuilder();
      } else {
        if (dataOneofCase_ == 3) {
          return (UserProto) dataOneof_;
        }
        return UserProto.getDefaultInstance();
      }
    }
    /**
     * <code>.com.toy.stompchat.proto.UserProto user = 3;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        UserProto, UserProto.Builder, UserProtoOrBuilder>
        getUserFieldBuilder() {
      if (userBuilder_ == null) {
        if (!(dataOneofCase_ == 3)) {
          dataOneof_ = UserProto.getDefaultInstance();
        }
        userBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            UserProto, UserProto.Builder, UserProtoOrBuilder>(
                (UserProto) dataOneof_,
                getParentForChildren(),
                isClean());
        dataOneof_ = null;
      }
      dataOneofCase_ = 3;
      onChanged();;
      return userBuilder_;
    }

    private long date_ ;
    /**
     * <code>int64 date = 4;</code>
     * @return The date.
     */
    @Override
    public long getDate() {
      return date_;
    }
    /**
     * <code>int64 date = 4;</code>
     * @param value The date to set.
     * @return This builder for chaining.
     */
    public Builder setDate(long value) {
      
      date_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int64 date = 4;</code>
     * @return This builder for chaining.
     */
    public Builder clearDate() {
      
      date_ = 0L;
      onChanged();
      return this;
    }
    @Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFields(unknownFields);
    }

    @Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:com.toy.stompchat.proto.MessageProto)
  }

  // @@protoc_insertion_point(class_scope:com.toy.stompchat.proto.MessageProto)
  private static final MessageProto DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new MessageProto();
  }

  public static MessageProto getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<MessageProto>
      PARSER = new com.google.protobuf.AbstractParser<MessageProto>() {
    @Override
    public MessageProto parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new MessageProto(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<MessageProto> parser() {
    return PARSER;
  }

  @Override
  public com.google.protobuf.Parser<MessageProto> getParserForType() {
    return PARSER;
  }

  @Override
  public MessageProto getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

