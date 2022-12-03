package server.usecases.rating_changes;


public class SendRatingInteractor implements SendRatingInputBoundary{
    final SendRatingDsGateway dataBase;
    final SendRatingOutputBoundary output;

    public SendRatingInteractor(SendRatingDsGateway dataBase, SendRatingOutputBoundary output)
    {
        this.dataBase = dataBase;
        this.output = output;
    }

    @Override
    public void sendRating(SendRatingInputModel model)
    {
        String address = dataBase.userAddress(model.senderUid);
        int userPort = dataBase.userPort(model.senderUid);
        dataBase.storeRating(model.receiverUid, model.avgRating);
        SendRatingOutputModel outputModel = new SendRatingOutputModel(address, userPort, model.senderUid, model.receiverUid, model.avgRating);
        output.sendRating(outputModel);
    }
}
