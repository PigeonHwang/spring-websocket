/* eslint-disable */
import * as Long from "long";
import * as _m0 from "protobufjs/minimal";

export const protobufPackage = "com.toy.kotlinspringchat.proto";

export enum MsgTypeEnum {
  JOIN = 0,
  LEFT = 1,
  SAY = 2,
  UNRECOGNIZED = -1,
}

export function msgTypeEnumFromJSON(object: any): MsgTypeEnum {
  switch (object) {
    case 0:
    case "JOIN":
      return MsgTypeEnum.JOIN;
    case 1:
    case "LEFT":
      return MsgTypeEnum.LEFT;
    case 2:
    case "SAY":
      return MsgTypeEnum.SAY;
    case -1:
    case "UNRECOGNIZED":
    default:
      return MsgTypeEnum.UNRECOGNIZED;
  }
}

export function msgTypeEnumToJSON(object: MsgTypeEnum): string {
  switch (object) {
    case MsgTypeEnum.JOIN:
      return "JOIN";
    case MsgTypeEnum.LEFT:
      return "LEFT";
    case MsgTypeEnum.SAY:
      return "SAY";
    case MsgTypeEnum.UNRECOGNIZED:
    default:
      return "UNRECOGNIZED";
  }
}

export interface MessageProto {
  msgType: MsgTypeEnum;
  data: string | undefined;
  user: UserProto | undefined;
  date: number;
}

export interface UserProto {
  idx: number;
  name: string;
}

export interface MessageArrProto {
  msgList: MessageProto[];
}

function createBaseMessageProto(): MessageProto {
  return { msgType: 0, data: undefined, user: undefined, date: 0 };
}

export const MessageProto = {
  encode(message: MessageProto, writer: _m0.Writer = _m0.Writer.create()): _m0.Writer {
    if (message.msgType !== 0) {
      writer.uint32(8).int32(message.msgType);
    }
    if (message.data !== undefined) {
      writer.uint32(18).string(message.data);
    }
    if (message.user !== undefined) {
      UserProto.encode(message.user, writer.uint32(26).fork()).ldelim();
    }
    if (message.date !== 0) {
      writer.uint32(32).int64(message.date);
    }
    return writer;
  },

  decode(input: _m0.Reader | Uint8Array, length?: number): MessageProto {
    const reader = input instanceof _m0.Reader ? input : new _m0.Reader(input);
    let end = length === undefined ? reader.len : reader.pos + length;
    const message = createBaseMessageProto();
    while (reader.pos < end) {
      const tag = reader.uint32();
      switch (tag >>> 3) {
        case 1:
          message.msgType = reader.int32() as any;
          break;
        case 2:
          message.data = reader.string();
          break;
        case 3:
          message.user = UserProto.decode(reader, reader.uint32());
          break;
        case 4:
          message.date = longToNumber(reader.int64() as Long);
          break;
        default:
          reader.skipType(tag & 7);
          break;
      }
    }
    return message;
  },

  fromJSON(object: any): MessageProto {
    return {
      msgType: isSet(object.msgType) ? msgTypeEnumFromJSON(object.msgType) : 0,
      data: isSet(object.data) ? String(object.data) : undefined,
      user: isSet(object.user) ? UserProto.fromJSON(object.user) : undefined,
      date: isSet(object.date) ? Number(object.date) : 0,
    };
  },

  toJSON(message: MessageProto): unknown {
    const obj: any = {};
    message.msgType !== undefined && (obj.msgType = msgTypeEnumToJSON(message.msgType));
    message.data !== undefined && (obj.data = message.data);
    message.user !== undefined && (obj.user = message.user ? UserProto.toJSON(message.user) : undefined);
    message.date !== undefined && (obj.date = Math.round(message.date));
    return obj;
  },

  fromPartial<I extends Exact<DeepPartial<MessageProto>, I>>(object: I): MessageProto {
    const message = createBaseMessageProto();
    message.msgType = object.msgType ?? 0;
    message.data = object.data ?? undefined;
    message.user = (object.user !== undefined && object.user !== null) ? UserProto.fromPartial(object.user) : undefined;
    message.date = object.date ?? 0;
    return message;
  },
};

function createBaseUserProto(): UserProto {
  return { idx: 0, name: "" };
}

export const UserProto = {
  encode(message: UserProto, writer: _m0.Writer = _m0.Writer.create()): _m0.Writer {
    if (message.idx !== 0) {
      writer.uint32(8).int64(message.idx);
    }
    if (message.name !== "") {
      writer.uint32(18).string(message.name);
    }
    return writer;
  },

  decode(input: _m0.Reader | Uint8Array, length?: number): UserProto {
    const reader = input instanceof _m0.Reader ? input : new _m0.Reader(input);
    let end = length === undefined ? reader.len : reader.pos + length;
    const message = createBaseUserProto();
    while (reader.pos < end) {
      const tag = reader.uint32();
      switch (tag >>> 3) {
        case 1:
          message.idx = longToNumber(reader.int64() as Long);
          break;
        case 2:
          message.name = reader.string();
          break;
        default:
          reader.skipType(tag & 7);
          break;
      }
    }
    return message;
  },

  fromJSON(object: any): UserProto {
    return { idx: isSet(object.idx) ? Number(object.idx) : 0, name: isSet(object.name) ? String(object.name) : "" };
  },

  toJSON(message: UserProto): unknown {
    const obj: any = {};
    message.idx !== undefined && (obj.idx = Math.round(message.idx));
    message.name !== undefined && (obj.name = message.name);
    return obj;
  },

  fromPartial<I extends Exact<DeepPartial<UserProto>, I>>(object: I): UserProto {
    const message = createBaseUserProto();
    message.idx = object.idx ?? 0;
    message.name = object.name ?? "";
    return message;
  },
};

function createBaseMessageArrProto(): MessageArrProto {
  return { msgList: [] };
}

export const MessageArrProto = {
  encode(message: MessageArrProto, writer: _m0.Writer = _m0.Writer.create()): _m0.Writer {
    for (const v of message.msgList) {
      MessageProto.encode(v!, writer.uint32(10).fork()).ldelim();
    }
    return writer;
  },

  decode(input: _m0.Reader | Uint8Array, length?: number): MessageArrProto {
    const reader = input instanceof _m0.Reader ? input : new _m0.Reader(input);
    let end = length === undefined ? reader.len : reader.pos + length;
    const message = createBaseMessageArrProto();
    while (reader.pos < end) {
      const tag = reader.uint32();
      switch (tag >>> 3) {
        case 1:
          message.msgList.push(MessageProto.decode(reader, reader.uint32()));
          break;
        default:
          reader.skipType(tag & 7);
          break;
      }
    }
    return message;
  },

  fromJSON(object: any): MessageArrProto {
    return { msgList: Array.isArray(object?.msgList) ? object.msgList.map((e: any) => MessageProto.fromJSON(e)) : [] };
  },

  toJSON(message: MessageArrProto): unknown {
    const obj: any = {};
    if (message.msgList) {
      obj.msgList = message.msgList.map((e) => e ? MessageProto.toJSON(e) : undefined);
    } else {
      obj.msgList = [];
    }
    return obj;
  },

  fromPartial<I extends Exact<DeepPartial<MessageArrProto>, I>>(object: I): MessageArrProto {
    const message = createBaseMessageArrProto();
    message.msgList = object.msgList?.map((e) => MessageProto.fromPartial(e)) || [];
    return message;
  },
};

declare var self: any | undefined;
declare var window: any | undefined;
declare var global: any | undefined;
var globalThis: any = (() => {
  if (typeof globalThis !== "undefined") {
    return globalThis;
  }
  if (typeof self !== "undefined") {
    return self;
  }
  if (typeof window !== "undefined") {
    return window;
  }
  if (typeof global !== "undefined") {
    return global;
  }
  throw "Unable to locate global object";
})();

type Builtin = Date | Function | Uint8Array | string | number | boolean | undefined;

export type DeepPartial<T> = T extends Builtin ? T
  : T extends Array<infer U> ? Array<DeepPartial<U>> : T extends ReadonlyArray<infer U> ? ReadonlyArray<DeepPartial<U>>
  : T extends {} ? { [K in keyof T]?: DeepPartial<T[K]> }
  : Partial<T>;

type KeysOfUnion<T> = T extends T ? keyof T : never;
export type Exact<P, I extends P> = P extends Builtin ? P
  : P & { [K in keyof P]: Exact<P[K], I[K]> } & { [K in Exclude<keyof I, KeysOfUnion<P>>]: never };

function longToNumber(long: Long): number {
  if (long.gt(Number.MAX_SAFE_INTEGER)) {
    throw new globalThis.Error("Value is larger than Number.MAX_SAFE_INTEGER");
  }
  return long.toNumber();
}

// If you get a compile-error about 'Constructor<Long> and ... have no overlap',
// add '--ts_proto_opt=esModuleInterop=true' as a flag when calling 'protoc'.
if (_m0.util.Long !== Long) {
  _m0.util.Long = Long as any;
  _m0.configure();
}

function isSet(value: any): boolean {
  return value !== null && value !== undefined;
}
