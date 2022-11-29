package interface_adapters.create_gc;

import frameworks_and_drivers.communication_manager.IfComManager;
import usecases.create_gc.CreateGCOutputBoundary;
import usecases.create_gc.CreateGCOutputData;
import usecases.retrieve_friendslist.RetrieveFriendsListOutputBoundary;
import usecases.retrieve_friendslist.RetrieveFriendsListOutputData;

public class CreateGCOutputAdapter implements CreateGCOutputBoundary {
    private IfComManager comManager;
    public CreateGCOutputAdapter(IfComManager comManager){ this.comManager = comManager;}

    @Override
    public void prepareSuccessView(CreateGCOutputData output_data) {

    }
}
