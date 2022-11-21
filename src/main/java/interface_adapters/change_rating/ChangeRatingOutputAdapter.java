package interface_adapters.change_rating;

import frameworks_and_drivers.communication_manager.IfComManager;
import usecases.rating_changes.SendRatingOutputBoundary;
import usecases.rating_changes.SendRatingOutputModel;

import java.util.*;

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
        // Write getter and setters (for address and port) in the Interactor -- Interactor send this over to OutputBoundary using sendChat
        // and update the output model
        
        // From Kotya
        // getPort and getAddress in Interactor ... to be continued
        String content = "" + model.getAvgRating() + "," + model.getReceiverUid();
        //comManager.send(model.receiverAddress, model.receiverPort, content);
    }
}
    

