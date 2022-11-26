package client.interface_adapters.rating;

import server.frameworks_and_drivers.communication_manager.IfComManager;
import server.usecases.rating_changes.SendRatingOutputBoundary;
import server.usecases.rating_changes.SendRatingOutputModel;

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
        String content = "" + model.getAvgRating() + "," + model.getReceiverUid();
        //comManager.send(model.receiverAddress, model.receiverPort, content);
    }
}
    

