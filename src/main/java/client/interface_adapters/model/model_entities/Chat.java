package client.interface_adapters.model.model_entities;


public interface Chat
{
    public void addMsg(Message msg);
    public void deleteMsg();

    public int getUid();
}
