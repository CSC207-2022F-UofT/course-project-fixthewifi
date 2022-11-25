package usecases.friendinteractors.viewfriend;

import entities.CommonUser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public interface view_friend_DSGateway {
    ArrayList<HashMap<String, Integer>> getFriendList(int requestorid);
    String getAddress(int requestorid);
    int getPeerPort(int requestorid);
}
