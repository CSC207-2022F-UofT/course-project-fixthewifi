package test_friend;

import server.usecases.friendinteractors.acceptfriend.acceptFriendOutputBoundary;
import server.usecases.friendinteractors.requestfriend.requestFriendOutputBoundary;

class output implements requestFriendOutputBoundary, acceptFriendOutputBoundary {

    @Override
    public void success(int requesterid, String address, int peerPort) {

    }

    @Override
    public void reportToFriend(int requesterid, String requesterName, int friendid, String address, int peerPort) {

    }

    @Override
    public void fail(int requesterid, String address, int peerPort) {

    }

    @Override
    public void success(String[] userProfileData, String address, int ip) {

    }

    @Override
    public void refuse(int requestor, int friendid, String friendName, String address, int peerPort) {

    }

    @Override
    public void addUserToChat(String[] ChatInfo, int otherMemberUid, String address, int port) {

    }
}