package interface_adapters.friend;

import usecases.friendinteractors.addfriend.add_friend_output_boundary;

public class AddFriendOutputAdapter implements add_friend_output_boundary
{
    @Override
    public void success()
    {
        //comManager.send("successfully add friend UID")
    }

    @Override
    public void fail()
    {
        //comManager.send("failed to add friend UID")
    }
}
