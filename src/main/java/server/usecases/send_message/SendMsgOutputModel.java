package server.usecases.send_message;

import java.util.List;

public class SendMsgOutputModel
{
    public String address;
    public int msgUid;
    public int senderUid;
    public int chatUid;
    public String content;
    public String time;
    public int port;
    public String name;

    public SendMsgOutputModel(String address, int port, int msgUid, int senderUid, int chatUid, String content, String time, String name)
    {
        this.address = address;
        this.msgUid = msgUid;
        this.senderUid = senderUid;
        this.chatUid = chatUid;
        this.content = content;
        this.time = time;
        this.port = port;
        this.name = name;
    }

}
