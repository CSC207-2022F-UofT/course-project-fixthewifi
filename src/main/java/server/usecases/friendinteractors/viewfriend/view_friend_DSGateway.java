package server.usecases.friendinteractors.viewfriend;

import server.usecases.friendinteractors.friendCommonsDSGateway;

import java.util.ArrayList;
import java.util.HashMap;

public interface view_friend_DSGateway extends friendCommonsDSGateway {
    ArrayList<HashMap<String, Integer>> getFriendList(int requestorid);
}
