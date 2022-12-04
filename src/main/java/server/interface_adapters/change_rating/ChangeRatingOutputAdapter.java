// TO-DO: DELETE THIS FILE
package server.interface_adapters.change_rating;

import server.frameworks_and_drivers.communication_manager.IfComManager;
import server.usecases.rating_changes.SendRatingOutputBoundary;
import server.usecases.rating_changes.SendRatingOutputModel;
import server.frameworks_and_drivers.Constants;

public class ChangeRatingOutputAdapter implements SendRatingOutputBoundary
{
    private IfComManager comManager;
    public ChangeRatingOutputAdapter(IfComManager comManager)
    {
        this.comManager = comManager;
    }
    @Override
    public void sendRating(SendRatingOutputModel model)
    {
        // TO-DO need to get address and port
        // Write getter and setters in the interactor -- output boundary calls these getters and setters
        // and update the output model

        // From Kotya
        // getPort and getAddress in Interactor ... to be continued
        String content = Constants.SEND_RATING + "#" + model.getAvgRating() + "#" + model.getReceiverUid();
        comManager.send(model.getUserAddress(), model.getReceiverUid(), content);
    }
}
    

