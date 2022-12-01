package server.frameworks_and_drivers.database;

import usecases.friendinteractors.viewfriend.view_friend_DSGateway;

import java.util.ArrayList;
import java.util.HashMap;

public class ViewFriendDataAccess implements view_friend_DSGateway {
    @Override
    public ArrayList<HashMap<String, Integer>> getFriendList(int requestorid) {
        return null;
    }

    @Override
    public String getAddress(int requestorid) {
        return null;
    }

    @Override
    public int getPeerPort(int requestorid) {
        return 0;
    }
}
