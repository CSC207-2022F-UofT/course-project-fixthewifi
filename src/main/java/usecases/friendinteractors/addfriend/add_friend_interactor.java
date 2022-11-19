package usecases.friendinteractors.addfriend;

public class add_friend_interactor implements add_friend_input_boundary{
    final add_friend_output_boundary output;
    final add_friend_DSGateway dataBase;


    public add_friend_interactor(add_friend_DSGateway dataBase, add_friend_output_boundary output) {
        this.dataBase = dataBase;
        this.output = output;
    }

    @Override
    public void AddFriend(add_friend_input_model model)
    {
        if (model.getRejectinfo() != -1){
            dataBase.addFriendbyID(model.getRequesterid(), model.getFriendid());
            output.success();
        }
        dataBase.failToAddFriend(model.getRequesterid(), model.getFriendid());
        output.fail();
    }
}
