package client.interface_adapters.model.model_entities;

public class Message
{
    private final int msgUid;
    private final int senderUid;
    private String content;
    private final String date;
    private String senderName;

    public Message(int msgUid, int senderUid, String content, String date)
    {

        this.msgUid = msgUid;
        this.senderUid = senderUid;
        this.content = content;
        this.date = date;
        this.senderName = "";
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

    public String getSenderName()
    {
        return senderName;
    }

    public void setSenderName(String senderName)
    {
        this.senderName = senderName;
    }

    @Override
    public String toString() {
        return "Message " + msgUid + " by " + senderName + " on " +  date + ": \n" +
                "                 " + content + "\n" +
                "\n";
    }
}