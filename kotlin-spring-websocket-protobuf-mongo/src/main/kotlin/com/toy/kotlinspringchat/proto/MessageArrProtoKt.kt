//Generated by the protocol buffer compiler. DO NOT EDIT!
// source: chat.proto

package com.toy.kotlinspringchat.proto;

@kotlin.jvm.JvmName("-initializemessageArrProto")
public inline fun messageArrProto(block: com.toy.kotlinspringchat.proto.MessageArrProtoKt.Dsl.() -> kotlin.Unit): com.toy.kotlinspringchat.proto.MessageArrProto =
  com.toy.kotlinspringchat.proto.MessageArrProtoKt.Dsl._create(com.toy.kotlinspringchat.proto.MessageArrProto.newBuilder()).apply { block() }._build()
public object MessageArrProtoKt {
  @kotlin.OptIn(com.google.protobuf.kotlin.OnlyForUseByGeneratedProtoCode::class)
  @com.google.protobuf.kotlin.ProtoDslMarker
  public class Dsl private constructor(
    private val _builder: com.toy.kotlinspringchat.proto.MessageArrProto.Builder
  ) {
    public companion object {
      @kotlin.jvm.JvmSynthetic
      @kotlin.PublishedApi
      internal fun _create(builder: com.toy.kotlinspringchat.proto.MessageArrProto.Builder): Dsl = Dsl(builder)
    }

    @kotlin.jvm.JvmSynthetic
    @kotlin.PublishedApi
    internal fun _build(): com.toy.kotlinspringchat.proto.MessageArrProto = _builder.build()

    /**
     * An uninstantiable, behaviorless type to represent the field in
     * generics.
     */
    @kotlin.OptIn(com.google.protobuf.kotlin.OnlyForUseByGeneratedProtoCode::class)
    public class MsgListProxy private constructor() : com.google.protobuf.kotlin.DslProxy()
    /**
     * <code>repeated .com.toy.kotlinspringchat.proto.MessageProto msgList = 1;</code>
     */
     public val msgList: com.google.protobuf.kotlin.DslList<com.toy.kotlinspringchat.proto.MessageProto, MsgListProxy>
      @kotlin.jvm.JvmSynthetic
      get() = com.google.protobuf.kotlin.DslList(
        _builder.getMsgListList()
      )
    /**
     * <code>repeated .com.toy.kotlinspringchat.proto.MessageProto msgList = 1;</code>
     * @param value The msgList to add.
     */
    @kotlin.jvm.JvmSynthetic
    @kotlin.jvm.JvmName("addMsgList")
    public fun com.google.protobuf.kotlin.DslList<com.toy.kotlinspringchat.proto.MessageProto, MsgListProxy>.add(value: com.toy.kotlinspringchat.proto.MessageProto) {
      _builder.addMsgList(value)
    }
    /**
     * <code>repeated .com.toy.kotlinspringchat.proto.MessageProto msgList = 1;</code>
     * @param value The msgList to add.
     */
    @kotlin.jvm.JvmSynthetic
    @kotlin.jvm.JvmName("plusAssignMsgList")
    @Suppress("NOTHING_TO_INLINE")
    public inline operator fun com.google.protobuf.kotlin.DslList<com.toy.kotlinspringchat.proto.MessageProto, MsgListProxy>.plusAssign(value: com.toy.kotlinspringchat.proto.MessageProto) {
      add(value)
    }
    /**
     * <code>repeated .com.toy.kotlinspringchat.proto.MessageProto msgList = 1;</code>
     * @param values The msgList to add.
     */
    @kotlin.jvm.JvmSynthetic
    @kotlin.jvm.JvmName("addAllMsgList")
    public fun com.google.protobuf.kotlin.DslList<com.toy.kotlinspringchat.proto.MessageProto, MsgListProxy>.addAll(values: kotlin.collections.Iterable<com.toy.kotlinspringchat.proto.MessageProto>) {
      _builder.addAllMsgList(values)
    }
    /**
     * <code>repeated .com.toy.kotlinspringchat.proto.MessageProto msgList = 1;</code>
     * @param values The msgList to add.
     */
    @kotlin.jvm.JvmSynthetic
    @kotlin.jvm.JvmName("plusAssignAllMsgList")
    @Suppress("NOTHING_TO_INLINE")
    public inline operator fun com.google.protobuf.kotlin.DslList<com.toy.kotlinspringchat.proto.MessageProto, MsgListProxy>.plusAssign(values: kotlin.collections.Iterable<com.toy.kotlinspringchat.proto.MessageProto>) {
      addAll(values)
    }
    /**
     * <code>repeated .com.toy.kotlinspringchat.proto.MessageProto msgList = 1;</code>
     * @param index The index to set the value at.
     * @param value The msgList to set.
     */
    @kotlin.jvm.JvmSynthetic
    @kotlin.jvm.JvmName("setMsgList")
    public operator fun com.google.protobuf.kotlin.DslList<com.toy.kotlinspringchat.proto.MessageProto, MsgListProxy>.set(index: kotlin.Int, value: com.toy.kotlinspringchat.proto.MessageProto) {
      _builder.setMsgList(index, value)
    }
    /**
     * <code>repeated .com.toy.kotlinspringchat.proto.MessageProto msgList = 1;</code>
     */
    @kotlin.jvm.JvmSynthetic
    @kotlin.jvm.JvmName("clearMsgList")
    public fun com.google.protobuf.kotlin.DslList<com.toy.kotlinspringchat.proto.MessageProto, MsgListProxy>.clear() {
      _builder.clearMsgList()
    }

  }
}
@kotlin.jvm.JvmSynthetic
public inline fun com.toy.kotlinspringchat.proto.MessageArrProto.copy(block: com.toy.kotlinspringchat.proto.MessageArrProtoKt.Dsl.() -> kotlin.Unit): com.toy.kotlinspringchat.proto.MessageArrProto =
  com.toy.kotlinspringchat.proto.MessageArrProtoKt.Dsl._create(this.toBuilder()).apply { block() }._build()
