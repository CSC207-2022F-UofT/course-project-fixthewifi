package usecases.friendinteractors.deletefriend;


import usecases.friendinteractors.addfriend.add_friend_input_model;

import java.util.ArrayList;

public class delete_friend_interactor implements delete_friend_input_boundary {
    final delete_friend_output_boundary output;
    final delete_friend_DSGateway dataBase;


    public delete_friend_interactor(delete_friend_DSGateway dataBase, delete_friend_output_boundary output) {
        this.dataBase = dataBase;
        this.output = output;
    }

    /**
     * In interactor, delete friend from based on id or name and report if success or failure
     * @param model
     */
    @Override
    public void DeleteFriend(delete_friend_input_model model)
    {
        boolean bool1 = dataBase.findUserByUID(model.friendid);
        boolean bool2 = dataBase.findUserByName(model.friendName);

        if (bool1){
            dataBase.deleteFriendbyID(model.friendid, model.requesterid);
            output.success(model.requesterid);
        }
        if (bool2){
            dataBase.deleteFriendbyName(model.friendName, model.requesterName);
            output.success(model.requesterid);
        }
        output.fail(model.requesterid);
    }

//    @Override
//    public ArrayList<String> DeleteFriend_test1(delete_friend_input_model model)
//    {
//        boolean bool1 = dataBase.findUserByUID(model.friendid);
//        boolean bool2 = dataBase.findUserByName(model.friendName);
//
//        if (bool1){
//            dataBase.deleteFriendbyID(model.friendid, model.requesterid);
//            output.success(model.requesterid);
//        }
//        if (bool2){
//            dataBase.deleteFriendbyName(model.friendName, model.requesterName);
//            output.success(model.requesterid);
//        }
//        output.fail(model.requesterid);
//    }
//
//    @Override
//    public ArrayList<Integer> DeleteFriend_test2(delete_friend_input_model model)
//    {
//        boolean bool1 = dataBase.findUserByUID(model.friendid);
//        boolean bool2 = dataBase.findUserByName(model.friendName);
//
//        if (bool1){
//            dataBase.deleteFriendbyID(model.friendid, model.requesterid);
//            output.success(model.requesterid);
//        }
//        if (bool2){
//            dataBase.deleteFriendbyName(model.friendName, model.requesterName);
//            output.success(model.requesterid);
//        }
//        output.fail(model.requesterid);
//    }
}
