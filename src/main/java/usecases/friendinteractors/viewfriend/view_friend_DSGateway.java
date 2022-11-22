package usecases.friendinteractors.viewfriend;

import entities.CommonUser;

import java.util.HashMap;
import java.util.List;

public interface view_friend_DSGateway {
    List<String> getFriendList(int requestorid);
    String getAddress(int requestorid);
    int getPeerPort(int requestorid);
}
