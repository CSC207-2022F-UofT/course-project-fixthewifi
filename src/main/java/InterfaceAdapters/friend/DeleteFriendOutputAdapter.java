package interface_adapters.friend;


import usecases.friendinteractors.deletefriend.delete_friend_output_boundary;

public class DeleteFriendOutputAdapter implements delete_friend_output_boundary {
    @Override
    public void success()
    {
        //comManager.send("success")
    }

    @Override
    public void fail() {
        //comManager.send("fail")
    }
}
