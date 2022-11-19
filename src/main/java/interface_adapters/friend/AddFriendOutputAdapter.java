package interface_adapters.friend;

import usecases.friendinteractors.addfriend.add_friend_output_boundary;

public class AddFriendOutputAdapter implements add_friend_output_boundary
{
    @Override
    public void success(int requestorid)
    {
        //comManager.send("successfully add friend UID - requestorid")
    }

    @Override
    public void fail(int requestorid)
    {
        //comManager.send("failed to add friend UID - requestorid")
    }
}
