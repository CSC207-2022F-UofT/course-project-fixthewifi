package server.usecases.retrieve_friendslist;

public class RetrieveFriendsListInputData {
    private int UID;

    public RetrieveFriendsListInputData(int UID){
        this.UID = UID;
    }

    public int getUID() {
        return this.UID;
    }
}
