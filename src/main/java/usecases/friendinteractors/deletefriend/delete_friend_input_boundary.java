package usecases.friendinteractors.deletefriend;

import java.util.ArrayList;

public interface delete_friend_input_boundary {
    public void DeleteFriend(delete_friend_input_model model);
    public ArrayList<Integer> DeleteFriend_test(delete_friend_input_model model);
}
