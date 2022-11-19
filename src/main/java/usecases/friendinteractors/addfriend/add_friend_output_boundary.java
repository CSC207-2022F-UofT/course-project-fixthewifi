package usecases.friendinteractors.addfriend;

public interface add_friend_output_boundary
{
    /**
     * report success to add a friend
     */
    void success(int requestorid);

    /**
     * report fail to add a friend
     */
    void fail(int requestorid);
}
