package usecases.friendinteractors.addfriend;

/** Add friend database gateway
 *
 */

public interface add_friend_DSGateway {

    /** User of friendid adds user of requesterid to save it to the database.
     *
     * @param requesterid
     * @param friendid
     */
    void addFriendbyID(int requesterid, int friendid);

    /** User of friendid fails to add user of requesterid and return the info back through database and save it.
     *
     * @param requesterid
     * @param friendid
     */
    void failToAddFriend(int requesterid, int friendid);
}
