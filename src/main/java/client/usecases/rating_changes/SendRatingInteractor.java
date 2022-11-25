package client.usecases.rating_changes;


import server.usecases.rating_changes.*;
import server.usecases.rating_changes.SendRatingDsGateway;
import server.usecases.rating_changes.SendRatingInputModel;

public class SendRatingInteractor implements SendRatingInputBoundary {
    final server.usecases.rating_changes.SendRatingDsGateway dataBase;
    final SendRatingOutputBoundary output;

    public SendRatingInteractor(SendRatingDsGateway dataBase, SendRatingOutputBoundary output)
    {
        this.dataBase = dataBase;
        this.output = output;
    }

    @Override
    public void sendRating(SendRatingInputModel model)
    {
        dataBase.storeRating(model.receiverUid, model.avgRating);
        SendRatingOutputModel outputModel = new SendRatingOutputModel(model.receiverUid, model.avgRating);
        output.sendRating(outputModel);
    }
}
