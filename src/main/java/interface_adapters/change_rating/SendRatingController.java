package interface_adapters.change_rating;

import usecases.rating_changes.SendRatingInputBoundary;
import usecases.rating_changes.SendRatingInputModel;

public class SendRatingController {
    final SendRatingInputBoundary inputModelBoundary;
    
    public SendRatingController(SendRatingInputBoundary accountGateway) {
        this.inputModelBoundary = accountGateway;
    }

    void sendRating(int senderUid, int receiverUid, int rating) {
        SendRatingInputModel inputModel = new SendRatingInputModel(senderUid, receiverUid, rating);
        inputModelBoundary.sendRating(inputModel);
    }
}
