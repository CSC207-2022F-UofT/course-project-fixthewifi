package database;

import usecases.friendinteractors.viewfriend.view_friend_DSGateway;

import java.util.ArrayList;
import java.util.HashMap;

public class ViewFriendDataAccess implements view_friend_DSGateway {

    @Override
    public int getUserNamebyUID(String userName) {
        return 0;
    }

    @Override
    public String getUserName(int uid) {
        return null;
    }

    @Override
    public String getAddress(int uid) {
        return null;
    }

    @Override
    public int getPeerPort(int uid) {
        return 0;
    }

    @Override
    public boolean ifexistsUserName(String userName) {
        return false;
    }

    @Override
    public boolean ifexistsUID(int uid) {
        return false;
    }

    @Override
    public ArrayList<HashMap<String, Integer>> getFriendList(int requestorid) {
        return null;
    }
}
