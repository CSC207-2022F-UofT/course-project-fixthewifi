package interface_adapters.retrieve_friendslist;

import usecases.retrieve_friendslist.RetrieveFriendsListInputBoundary;
import usecases.retrieve_friendslist.RetrieveFriendsListInputData;

public class RetrieveFriendsListController {
    private final RetrieveFriendsListInputBoundary interactor;

    public RetrieveFriendsListController(RetrieveFriendsListInputBoundary interactor){
        this.interactor = interactor;
    }

    public void execute(String input){
        RetrieveFriendsListInputData input_data = new RetrieveFriendsListInputData(Integer.parseInt(input));
        interactor.execute(input_data);
    }
}
