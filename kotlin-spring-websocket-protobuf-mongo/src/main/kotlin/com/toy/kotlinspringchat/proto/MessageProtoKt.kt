//Generated by the protocol buffer compiler. DO NOT EDIT!
// source: chat.proto

package com.toy.kotlinspringchat.proto;

@kotlin.jvm.JvmName("-initializemessageProto")
public inline fun messageProto(block: com.toy.kotlinspringchat.proto.MessageProtoKt.Dsl.() -> kotlin.Unit): com.toy.kotlinspringchat.proto.MessageProto =
  com.toy.kotlinspringchat.proto.MessageProtoKt.Dsl._create(com.toy.kotlinspringchat.proto.MessageProto.newBuilder()).apply { block() }._build()
public object MessageProtoKt {
  @kotlin.OptIn(com.google.protobuf.kotlin.OnlyForUseByGeneratedProtoCode::class)
  @com.google.protobuf.kotlin.ProtoDslMarker
  public class Dsl private constructor(
    private val _builder: com.toy.kotlinspringchat.proto.MessageProto.Builder
  ) {
    public companion object {
      @kotlin.jvm.JvmSynthetic
      @kotlin.PublishedApi
      internal fun _create(builder: com.toy.kotlinspringchat.proto.MessageProto.Builder): Dsl = Dsl(builder)
    }

    @kotlin.jvm.JvmSynthetic
    @kotlin.PublishedApi
    internal fun _build(): com.toy.kotlinspringchat.proto.MessageProto = _builder.build()

    /**
     * <code>.com.toy.kotlinspringchat.proto.MsgTypeEnum msgType = 1;</code>
     */
    public var msgType: com.toy.kotlinspringchat.proto.MsgTypeEnum
      @JvmName("getMsgType")
      get() = _builder.getMsgType()
      @JvmName("setMsgType")
      set(value) {
        _builder.setMsgType(value)
      }
    /**
     * <code>.com.toy.kotlinspringchat.proto.MsgTypeEnum msgType = 1;</code>
     */
    public fun clearMsgType() {
      _builder.clearMsgType()
    }

    /**
     * <code>string data = 2;</code>
     */
    public var data: kotlin.String
      @JvmName("getData")
      get() = _builder.getData()
      @JvmName("setData")
      set(value) {
        _builder.setData(value)
      }
    /**
     * <code>string data = 2;</code>
     */
    public fun clearData() {
      _builder.clearData()
    }
    /**
     * <code>string data = 2;</code>
     * @return Whether the data field is set.
     */
    public fun hasData(): kotlin.Boolean {
      return _builder.hasData()
    }

    /**
     * <code>.com.toy.kotlinspringchat.proto.UserProto user = 3;</code>
     */
    public var user: com.toy.kotlinspringchat.proto.UserProto
      @JvmName("getUser")
      get() = _builder.getUser()
      @JvmName("setUser")
      set(value) {
        _builder.setUser(value)
      }
    /**
     * <code>.com.toy.kotlinspringchat.proto.UserProto user = 3;</code>
     */
    public fun clearUser() {
      _builder.clearUser()
    }
    /**
     * <code>.com.toy.kotlinspringchat.proto.UserProto user = 3;</code>
     * @return Whether the user field is set.
     */
    public fun hasUser(): kotlin.Boolean {
      return _builder.hasUser()
    }

    /**
     * <code>int64 date = 4;</code>
     */
    public var date: kotlin.Long
      @JvmName("getDate")
      get() = _builder.getDate()
      @JvmName("setDate")
      set(value) {
        _builder.setDate(value)
      }
    /**
     * <code>int64 date = 4;</code>
     */
    public fun clearDate() {
      _builder.clearDate()
    }
    public val dataOneofCase: com.toy.kotlinspringchat.proto.MessageProto.DataOneofCase
      @JvmName("getDataOneofCase")
      get() = _builder.getDataOneofCase()

    public fun clearDataOneof() {
      _builder.clearDataOneof()
    }
  }
}
@kotlin.jvm.JvmSynthetic
public inline fun com.toy.kotlinspringchat.proto.MessageProto.copy(block: com.toy.kotlinspringchat.proto.MessageProtoKt.Dsl.() -> kotlin.Unit): com.toy.kotlinspringchat.proto.MessageProto =
  com.toy.kotlinspringchat.proto.MessageProtoKt.Dsl._create(this.toBuilder()).apply { block() }._build()

val com.toy.kotlinspringchat.proto.MessageProtoOrBuilder.userOrNull: com.toy.kotlinspringchat.proto.UserProto?
  get() = if (hasUser()) getUser() else null
