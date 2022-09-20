// import protobuf, {util} from 'protobufjs';
import { Message, User } from './chat';
import {types} from "protobufjs";
import defaults = types.defaults;
import $ from 'jquery'
// import Sockjs from 'sockjs-client';


const client = new WebSocket('ws://localhost:8080/chatproto')

client.onmessage = async (ev) => {
    // console.log(Message.decode(new Uint8Array(await ev.data.arrayBuffer())))
    receiveMsg(Message.decode(new Uint8Array(await ev.data.arrayBuffer())));
}

client.onclose = () => {
    alert("Server Disconnect You")
}

client.onopen = () => {
    let name = "";
    while (name == "") { // @ts-ignore
        name = prompt("Enter your name");
    }
    sendMessage("join", name);
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
    sendMessage("say", (<HTMLInputElement>document.getElementById("msg")).value);
})

$("#msg").keypress(function(e) {
    if(e.which == 13) sendMessage("say", e.target.value);
});

function sendMessage(type: string, date: string) {
    console.log("1231231");
    if(date != "") {
        client.send(Message.encode({ msgType: type, data: date, user: undefined }).finish());
        (<HTMLInputElement>document.getElementById("msg")).value = "";
        document.getElementById("msg")?.focus();
    }
}

function receiveMsg(msg: Message) {
    console.log(msg);
    if (msg.msgType == "say") {
        $("#chatbox").append("<p>" + msg.data + "</p>");
    }
    else if (msg.msgType == "join") {
        addUser(msg.user);
    }
    else if (msg.msgType == "left") {
        $("#user"+msg.user?.id).remove();
    }
}

function addUser(user: User | undefined) {
    $("#userlist").append("<li id='user"+user?.id+"'>"+user?.name+"</li>");
}