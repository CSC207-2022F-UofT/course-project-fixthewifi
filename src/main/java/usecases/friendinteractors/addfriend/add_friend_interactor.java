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
        boolean bool1 = dataBase.findUserByUID(model.friendid);
        boolean bool2 = dataBase.findUserByName(model.friendName);

        if (bool1){
            dataBase.addFriendbyID(model.friendid, model.requesterid);
            output.success();
        }
        if (bool1){
            dataBase.addFriendbyName(model.friendName, model.requesterName);
            output.success();
        }
        output.fail();
    }
}
