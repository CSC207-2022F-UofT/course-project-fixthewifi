package client.usecases.rating_changes;

import server.usecases.rating_changes.SendRatingInputModel;

public interface SendRatingInputBoundary {
    public void sendRating(SendRatingInputModel model);
}
