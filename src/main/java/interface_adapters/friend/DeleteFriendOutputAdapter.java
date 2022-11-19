package interface_adapters.friend;


import usecases.friendinteractors.deletefriend.delete_friend_output_boundary;

public class DeleteFriendOutputAdapter implements delete_friend_output_boundary {
    @Override
    public void success(int requesterid)
    {
        //comManager.send("success requesterid")
    }

    @Override
    public void fail(int requesterid) {
        //comManager.send("fail requesterid")
    }
}
