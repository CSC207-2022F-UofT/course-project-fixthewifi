package usecases.friendinteractors.deletefriend;

public interface delete_friend_DSGateway {

    /**
     * Delete the friend based on requesterid and friendid
     * @param user1
     * @param user2
     */
    void deleteFriendbyID(int user1, int user2);

    /**
     * Delete the friend based on requesterName and friendName
     * @param user1
     * @param user2
     */
    void deleteFriendbyName(String user1, String user2);

    /**
     * Find the user by userid.
     * @param uid
     * @return
     */
    boolean findUserByUID(int uid);

    /**
     * Find the user by username.
     * @param name
     * @return
     */
    boolean findUserByName(String name);
}
