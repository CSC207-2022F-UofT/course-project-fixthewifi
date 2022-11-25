package client.usecases.rating_changes;


import server.usecases.rating_changes.SendRatingOutputModel;

public interface SendRatingOutputBoundary {
    void sendRating(SendRatingOutputModel model);
}
