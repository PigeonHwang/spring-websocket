// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: chat.proto

package com.toy.kotlinspringchat.proto;

public interface MessageProtoOrBuilder extends
    // @@protoc_insertion_point(interface_extends:com.toy.kotlinspringchat.proto.MessageProto)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>.com.toy.kotlinspringchat.proto.MsgTypeEnum msgType = 1;</code>
   * @return The enum numeric value on the wire for msgType.
   */
  int getMsgTypeValue();
  /**
   * <code>.com.toy.kotlinspringchat.proto.MsgTypeEnum msgType = 1;</code>
   * @return The msgType.
   */
  MsgTypeEnum getMsgType();

  /**
   * <code>string data = 2;</code>
   * @return Whether the data field is set.
   */
  boolean hasData();
  /**
   * <code>string data = 2;</code>
   * @return The data.
   */
  String getData();
  /**
   * <code>string data = 2;</code>
   * @return The bytes for data.
   */
  com.google.protobuf.ByteString
      getDataBytes();

  /**
   * <code>.com.toy.kotlinspringchat.proto.UserProto user = 3;</code>
   * @return Whether the user field is set.
   */
  boolean hasUser();
  /**
   * <code>.com.toy.kotlinspringchat.proto.UserProto user = 3;</code>
   * @return The user.
   */
  UserProto getUser();
  /**
   * <code>.com.toy.kotlinspringchat.proto.UserProto user = 3;</code>
   */
  UserProtoOrBuilder getUserOrBuilder();

  /**
   * <code>int64 date = 4;</code>
   * @return The date.
   */
  long getDate();

  public MessageProto.DataOneofCase getDataOneofCase();
}
