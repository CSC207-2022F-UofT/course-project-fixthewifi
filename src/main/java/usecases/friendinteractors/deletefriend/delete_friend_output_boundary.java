package usecases.friendinteractors.deletefriend;

public interface delete_friend_output_boundary {

    /**
     * Report success deleting friend to database and the two user
     */
    void success(int requesterid);

    /**
     * Report failure deleting friend to database and the two user
     */
    void fail(int requesterid);
}
