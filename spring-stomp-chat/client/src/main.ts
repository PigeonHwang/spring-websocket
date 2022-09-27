// import protobuf, {util} from "protobufjs";
import {MessageProto, MsgTypeEnum} from "./chat";
import {types} from "protobufjs";
import {Stomp} from "@stomp/stompjs";
// import Sockjs from 'sockjs-client';

const wsClient = new WebSocket("ws://localhost:8080/ws")
const stompClient = Stomp.over(wsClient)

stompClient.connect({}, function () {
    console.log(stompClient)
    stompClient.send("/app/join", {}, MessageProto.encode({msgType: MsgTypeEnum.JOIN, data: "123123", user: undefined, date: 0}).finish().toString())
})

/*client.onmessage = async (ev) => {
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
}*/
