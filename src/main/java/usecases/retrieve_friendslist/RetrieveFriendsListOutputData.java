package usecases.retrieve_friendslist;

import java.util.ArrayList;

/**
 * represenation invariants:
 * -for every UIDs[i], the corresponding username
 * of that user is username[i].
 * -the username of another user is in RetrieveFriendsListOutputData.usernames
 * iff that user is in their friends list
 * -the UID of another user is in RetrieveFriendsListOutputData.UIDs
 * iff that user is in their friends list
 */
public class RetrieveFriendsListOutputData {
    /**
     * the UID of the user who is making the GroupChat
     */
    private int requester;
    /**
     * the List of UIDs of users in requester's FriendsList.
     */
    private ArrayList<Integer> UIDs;
    /**
     * the List of usernames of users in requester's FriendsList
     */
    private ArrayList<Integer> usernames;

    public RetrieveFriendsListOutputData(
            int requester, ArrayList<Integer> UIDs, ArrayList<Integer> usernames){
        this.requester = requester;
        this.UIDs = UIDs;
        this.usernames = usernames;
    }

    public void setRequester(int requester) {
        this.requester = requester;
    }

    public int getRequester() {
        return this.requester;
    }

    public void setUIDs(ArrayList<Integer> UIDs) {
        this.UIDs = UIDs;
    }

    public ArrayList<Integer> getUIDs() {
        return this.UIDs;
    }

    public void setUsernames(ArrayList<Integer> usernames) {
        this.usernames = usernames;
    }
    public ArrayList<Integer> getUsernames(){
        return this.usernames;
    }
}
