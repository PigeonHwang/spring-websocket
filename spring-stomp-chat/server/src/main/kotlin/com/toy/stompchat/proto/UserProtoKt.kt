//Generated by the protocol buffer compiler. DO NOT EDIT!
// source: chat.proto

package com.toy.stompchat.proto;

@kotlin.jvm.JvmName("-initializeuserProto")
public inline fun userProto(block: com.toy.stompchat.proto.UserProtoKt.Dsl.() -> kotlin.Unit): com.toy.stompchat.proto.UserProto =
  com.toy.stompchat.proto.UserProtoKt.Dsl._create(com.toy.stompchat.proto.UserProto.newBuilder()).apply { block() }._build()
public object UserProtoKt {
  @kotlin.OptIn(com.google.protobuf.kotlin.OnlyForUseByGeneratedProtoCode::class)
  @com.google.protobuf.kotlin.ProtoDslMarker
  public class Dsl private constructor(
    private val _builder: com.toy.stompchat.proto.UserProto.Builder
  ) {
    public companion object {
      @kotlin.jvm.JvmSynthetic
      @kotlin.PublishedApi
      internal fun _create(builder: com.toy.stompchat.proto.UserProto.Builder): Dsl = Dsl(builder)
    }

    @kotlin.jvm.JvmSynthetic
    @kotlin.PublishedApi
    internal fun _build(): com.toy.stompchat.proto.UserProto = _builder.build()

    /**
     * <code>int64 idx = 1;</code>
     */
    public var idx: kotlin.Long
      @JvmName("getIdx")
      get() = _builder.getIdx()
      @JvmName("setIdx")
      set(value) {
        _builder.setIdx(value)
      }
    /**
     * <code>int64 idx = 1;</code>
     */
    public fun clearIdx() {
      _builder.clearIdx()
    }

    /**
     * <code>string name = 2;</code>
     */
    public var name: kotlin.String
      @JvmName("getName")
      get() = _builder.getName()
      @JvmName("setName")
      set(value) {
        _builder.setName(value)
      }
    /**
     * <code>string name = 2;</code>
     */
    public fun clearName() {
      _builder.clearName()
    }
  }
}
@kotlin.jvm.JvmSynthetic
public inline fun com.toy.stompchat.proto.UserProto.copy(block: com.toy.stompchat.proto.UserProtoKt.Dsl.() -> kotlin.Unit): com.toy.stompchat.proto.UserProto =
  com.toy.stompchat.proto.UserProtoKt.Dsl._create(this.toBuilder()).apply { block() }._build()

