// import protobuf, {util} from 'protobufjs';
import {MessageProto, MsgTypeEnum, UserProto} from './chat';
import $ from 'jquery'
// import Sockjs from 'sockjs-client';


const client = new WebSocket('ws://localhost:3000/chat')

client.onmessage = async (ev) => {
    // console.log(Message.decode(new Uint8Array(await ev.data.arrayBuffer())))
    receiveMsg(MessageProto.decode(new Uint8Array(await ev.data.arrayBuffer())));
}

client.onclose = () => {
    alert("Server Disconnect You")
}

client.onopen = () => {
    let name = "";
    while (name == "") { // @ts-ignore
        name = prompt("Enter your name");
    }
    sendMessage(MsgTypeEnum.JOIN, name);

    /*const data = Message.encode({ msgType: "join", data: "pigeon" }).finish();
    client.send(data);
    const data2 = Message.encode({ msgType: "say", data: "Hi eichi i~" }).finish();
    client.send(data2);*/

    /*setInterval(() => {
        client.send(data)
    }, 1000);*/
    /*const data = JSON.stringify({type: "join", data: "hello"})

    setInterval(() => {
        client.send(data)
    }, 1000);*/
}

$("#send").click(function (){
    sendMessage(MsgTypeEnum.SAY, (<HTMLInputElement>document.getElementById("msg")).value);
})

$("#msg").keypress(function(e) {
    if(e.which == 13) sendMessage(MsgTypeEnum.SAY, e.target.value);
});

function sendMessage(type: MsgTypeEnum, data: string) {
    if(data != "") {
        client.send(MessageProto.encode({ msgType: type, data: data, user: undefined, date: 0 }).finish());
        (<HTMLInputElement>document.getElementById("msg")).value = "";
        document.getElementById("msg")?.focus();
    }
}

function receiveMsg(msg: MessageProto) {
    console.log(msg);
    if (msg.msgType == MsgTypeEnum.SAY) {
        $("#chatbox").append("<p>" + msg.data + "</p>");
    }
    else if (msg.msgType == MsgTypeEnum.JOIN) {
        addUser(msg.user);
    }
    else if (msg.msgType == MsgTypeEnum.LEFT) {
        $("#user"+msg.user?.idx).remove();
    }
}

function addUser(user: UserProto | undefined) {
    $("#userlist").append("<li id='user"+user?.idx+"'>"+user?.name+"</li>");
}