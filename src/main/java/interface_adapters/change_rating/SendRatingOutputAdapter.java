package interface_adapters.change_rating;

import frameworks_and_drivers.communication_manager.IfComManager;
import usecases.rating_changes.SendRatingOutputBoundary;
import usecases.rating_changes.SendRatingOutputModel;
import frameworks_and_drivers.Constants;


public class SendRatingOutputAdapter implements SendRatingOutputBoundary
{
    private IfComManager comManager;
    public SendRatingOutputAdapter(IfComManager comManager)
    {
        this.comManager = comManager;
    }
    @Override
    public void sendRating(SendRatingOutputModel model)
    {
        String content = "" + Constants.SEND_RATING + model.getReceiverUid() + model.getAvgRating();
        String address = model.getUserAddress();
        int port = model.getUserPort();
        comManager.send(address,port,content);
    }
}
    

