//Generated by the protocol buffer compiler. DO NOT EDIT!
// source: chat.proto

package com.example.proto;

@kotlin.jvm.JvmName("-initializemessage")
public inline fun message(block: com.example.proto.MessageKt.Dsl.() -> kotlin.Unit): com.example.proto.Message =
  com.example.proto.MessageKt.Dsl._create(com.example.proto.Message.newBuilder()).apply { block() }._build()
public object MessageKt {
  @kotlin.OptIn(com.google.protobuf.kotlin.OnlyForUseByGeneratedProtoCode::class)
  @com.google.protobuf.kotlin.ProtoDslMarker
  public class Dsl private constructor(
    private val _builder: com.example.proto.Message.Builder
  ) {
    public companion object {
      @kotlin.jvm.JvmSynthetic
      @kotlin.PublishedApi
      internal fun _create(builder: com.example.proto.Message.Builder): Dsl = Dsl(builder)
    }

    @kotlin.jvm.JvmSynthetic
    @kotlin.PublishedApi
    internal fun _build(): com.example.proto.Message = _builder.build()

    /**
     * <code>string msgType = 1;</code>
     */
    public var msgType: kotlin.String
      @JvmName("getMsgType")
      get() = _builder.getMsgType()
      @JvmName("setMsgType")
      set(value) {
        _builder.setMsgType(value)
      }
    /**
     * <code>string msgType = 1;</code>
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
     * <code>.com.example.proto.User user = 3;</code>
     */
    public var user: com.example.proto.User
      @JvmName("getUser")
      get() = _builder.getUser()
      @JvmName("setUser")
      set(value) {
        _builder.setUser(value)
      }
    /**
     * <code>.com.example.proto.User user = 3;</code>
     */
    public fun clearUser() {
      _builder.clearUser()
    }
    /**
     * <code>.com.example.proto.User user = 3;</code>
     * @return Whether the user field is set.
     */
    public fun hasUser(): kotlin.Boolean {
      return _builder.hasUser()
    }
    public val dataOneofCase: com.example.proto.Message.DataOneofCase
      @JvmName("getDataOneofCase")
      get() = _builder.getDataOneofCase()

    public fun clearDataOneof() {
      _builder.clearDataOneof()
    }
  }
}
@kotlin.jvm.JvmSynthetic
public inline fun com.example.proto.Message.copy(block: com.example.proto.MessageKt.Dsl.() -> kotlin.Unit): com.example.proto.Message =
  com.example.proto.MessageKt.Dsl._create(this.toBuilder()).apply { block() }._build()

val com.example.proto.MessageOrBuilder.userOrNull: com.example.proto.User?
  get() = if (hasUser()) getUser() else null
