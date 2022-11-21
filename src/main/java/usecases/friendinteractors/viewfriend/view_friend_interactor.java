package usecases.friendinteractors.viewfriend;

import entities.CommonUser;

import java.util.ArrayList;

public class view_friend_interactor implements view_friend_input_boundary {
    final view_friend_output_boundary output;
    final view_friend_DSGateway dataBase;

    public view_friend_interactor(view_friend_DSGateway dataBase, view_friend_output_boundary output){
        this.dataBase = dataBase;
        this.output = output;
    }

    /**
     * Pass friend list from database
     * @param model
     */
    @Override
    public void ViewFriend(view_friend_input_model model) {
        ArrayList<CommonUser> arraylist = new ArrayList<CommonUser> ();
        arraylist = dataBase.getFriendList(model.requesterid);
        output.pushFriendList(arraylist);
    }
//
//    @Override
//    public ArrayList<Integer> ViewFriend_test(view_friend_input_model model) {
//        ArrayList<Integer> arraylist = new ArrayList<Integer> ();
//        arraylist = dataBase.getFriendList_test(model.requesterid);
//        return arraylist;
//    }
}
