package server.interface_adapters.change_rating;

import server.usecases.rating_changes.SendRatingInputBoundary;
import server.usecases.rating_changes.SendRatingInputModel;

public class SendRatingController {
    final SendRatingInputBoundary inputModelBoundary;
    
    public SendRatingController(SendRatingInputBoundary accountGateway) {
        this.inputModelBoundary = accountGateway;
    }

    public void sendRating(int senderUid, int receiverUid, int rating) {
        SendRatingInputModel inputModel = new SendRatingInputModel(senderUid, receiverUid, rating);
        inputModelBoundary.sendRating(inputModel);
    }
}
