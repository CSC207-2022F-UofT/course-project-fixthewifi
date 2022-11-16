package interface_adapters.friend;

import usecases.friendinteractors.requestfriend.requestFriendOutputBoundary;

public class RequestFriendOutputAdapter implements requestFriendOutputBoundary {
    @Override
    public void success()
    {
        //comManager.send("successfully send a request to add friend UID")
    }

    @Override
    public void fail()
    {
        //comManager.send("failed to send a request to add friend UID")
    }
}
