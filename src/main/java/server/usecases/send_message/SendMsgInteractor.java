package server.usecases.send_message;


import java.util.List;

public class SendMsgInteractor implements SendMsgInputBoundary
{
    final SendMsgDsGateway dataBase;
    final SendMsgOutputBoundary output;

    /**
     * Creates a Send Chat usecase object.
     * @param dataBase A database.
     * @param output The output adapter that converts output data to the appropriate form.
     */
    public SendMsgInteractor(SendMsgDsGateway dataBase, SendMsgOutputBoundary output)
    {
        this.dataBase = dataBase;
        this.output = output;
    }

    /**
     * Send chat usecase.
     * @param inputModel A model of the input.
     */
    @Override
    public void SendChat(SendMsgInputModel inputModel)
    {

        List<Integer> membersUid = dataBase.getAllMemberUid(inputModel.chatUid);
        int msgUid = dataBase.generateMsgUid(inputModel.chatUid);
        dataBase.storeChatMsg(inputModel.chatUid, inputModel.senderUid, inputModel.content, inputModel.time);

        for (Integer memberUid : membersUid)
        {
            String address = dataBase.getAddress(memberUid);
            int port = dataBase.getPort(memberUid);
            SendMsgOutputModel outputModel = new SendMsgOutputModel(address, port, msgUid, inputModel.senderUid, inputModel.chatUid, inputModel.content, inputModel.time);
            output.sendChat(outputModel);
        }
    }


}
