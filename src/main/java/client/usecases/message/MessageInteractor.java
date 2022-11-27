package client.usecases.message;


import client.entities.Chat;

public class MessageInteractor implements MessageInputBoundary
{
    final MessageModelGateway model;
    final MessageOutputBoundary output;

    /**
     * Creates a Send Chat usecase object.
     * @param dataBase A database.
     * @param output The output adapter that converts output data to the appropriate form.
     */
    public MessageInteractor(MessageModelGateway dataBase, MessageOutputBoundary output)
    {
        this.model = dataBase;
        this.output = output;
    }

    /**
     * Send chat usecase.
     */
    @Override
    public void sendMsg(String content, int ChatUid)
    {
        java.util.Date date = new java.util.Date();
        output.sendMsg(model.getSelfUid(), ChatUid, content, date.toString());
    }

    @Override
    public void receiveMsg(int msgUid, int senderUid, int chatUid, String content, String time)
    {
        model.storeChatMsg(chatUid, senderUid, content, time);
    }


}
