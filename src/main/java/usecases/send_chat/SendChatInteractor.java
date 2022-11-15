package usecases.send_chat;

import entities.*;

public class SendChatInteractor implements SendChatInputBoundary
{
    final SendChatDsGateway dataBase;
    final SendChatOutputBoundary output;

    public SendChatInteractor(SendChatDsGateway dataBase, SendChatOutputBoundary output)
    {
        this.dataBase = dataBase;
        this.output = output;
    }

    @Override
    public void SendChat(SendChatInputModel inputModel)
    {
        dataBase.storeChat(inputModel.chatUid, inputModel.senderUid, inputModel.content, inputModel.time);
        SendChatOutputModel outputModel = new SendChatOutputModel(inputModel.chatUid, inputModel.senderUid, inputModel.content, inputModel.time);
        output.SendChat(outputModel);
    }


}
