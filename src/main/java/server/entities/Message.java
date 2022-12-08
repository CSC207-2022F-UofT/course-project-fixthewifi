package server.entities;

public class Message
{
    private final int msgUid;
    private final int senderUid;
    private String content;
    private final String date;

    public Message(int msgUid, int senderUid, String content, String date)
    {

        this.msgUid = msgUid;
        this.senderUid = senderUid;
        this.content = content;
        this.date = date;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getMsgUid() {
        return msgUid;
    }

    public int getSenderUid() {
        return senderUid;
    }

    public String getContent() {
        return content;
    }

    public String getDate() {
        return date;
    }


}