package interface_adapters.friend;

import usecases.friendinteractors.requestfriend.requestFriendOutputBoundary;

public class RequestFriendOutputAdapter implements requestFriendOutputBoundary {
    @Override
    public void success(int requesterid)
    {
        //comManager.send("successfully send a request to add friend UID - requesterid")
    }

    @Override
    public void fail(int requesterid)
    {
        //comManager.send("failed to send a request to add friend UID - requesterid")
    }
}
