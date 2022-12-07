package server.usecases.rating_changes;


import java.util.Arrays;

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
        System.out.println(Arrays.toString(dataBase.getAverageRating(model.receiverUid)));
        double noOfRating = dataBase.getAverageRating(model.receiverUid)[0] + 1;
        double totalRating = dataBase.getAverageRating(model.receiverUid)[1] + model.avgRating;

        dataBase.storeRating(model.receiverUid, totalRating/noOfRating, noOfRating, totalRating);

        SendRatingOutputModel outputModel = new SendRatingOutputModel(address, userPort, model.senderUid, model.receiverUid, totalRating/noOfRating);
        output.sendRating(outputModel);
    }
}
