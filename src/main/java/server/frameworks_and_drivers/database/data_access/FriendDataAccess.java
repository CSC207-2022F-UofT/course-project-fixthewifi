package server.frameworks_and_drivers.database.data_access;

import server.frameworks_and_drivers.database.Database;
import server.usecases.friendinteractors.acceptfriend.acceptFriendDSGateway;
import server.usecases.friendinteractors.deletefriend.delete_friend_DSGateway;
import server.usecases.friendinteractors.requestfriend.requestFriendDSGateway;
import server.usecases.friendinteractors.viewfriend.view_friend_DSGateway;

import java.util.*;

public class FriendDataAccess implements acceptFriendDSGateway, requestFriendDSGateway, delete_friend_DSGateway,
        view_friend_DSGateway
{
    Database database;

    public FriendDataAccess(Database database)
    {
        this.database = database;
    }


    @Override
    public void acceptFriendbyID(int friendid, int requesterid)
    {
        // Take out the row of information that belongs to friendid
        String[] friend = database.readUser(friendid);

        // Add each of them to each person`s friendlist
        List<String> friendList = new LinkedList<>(Arrays.asList(friend[6].split("-")));
        friendList.add(String.valueOf(requesterid));

        // Take out requesters and remove the person that just became friend
        List<String> requesterList = new LinkedList<>(Arrays.asList(friend[9].split("-")));
        requesterList.remove(String.valueOf(requesterid));

        //store back to database
        friend[6] = String.join("-", friendList.toArray(new String[0]));
        friend[9] = String.join("-", requesterList.toArray(new String[0]));
        database.updateUser(friendid, friend);

        // Take out the row of information that belongs to requesterid
        String[] requester = database.readUser(requesterid);

        // Take out friends, add new friend
        List<String> friendList1 = new LinkedList<>(Arrays.asList(requester[6].split("-")));
        friendList1.add(String.valueOf(friendid));

        //store back to database
        requester[6] = String.join("-", friendList1.toArray(new String[0]));
        database.updateUser(requesterid, requester);
    }

    @Override
    public void refuseFriendbyID(int friendid, int requesterid) {
        //delete requester info in friend`s requesterlist
        String[] friend = database.readUser(friendid);
        List<String> requesterList = new LinkedList<>(Arrays.asList(friend[9].split("-")));
        requesterList.remove(String.valueOf(requesterid));
        friend[9] = String.join("-", requesterList.toArray(new String[0]));
        database.updateUser(friendid, friend);
    }

    @Override
    public String[] readUser(int userUid) {
        return database.readUser(userUid);
    }

    @Override
    public int createPrivateChat(int requesterid, int friendid) {
        int chatUID = database.returnNewChatUid();
        String requesterName = database.readUser(requesterid)[1];
        String friendName = database.readUser(friendid)[1];
        String chatName = "private chat between " + requesterName + " and " + friendName;
        database.newChat(chatUID, chatName, "N/A", -1, new int[]{requesterid, friendid});

        String[] oldList = database.readUser(requesterid)[11].split("-");
        String[] toBase = new String[oldList.length+1];
        System.arraycopy(oldList, 0 ,toBase, 0, oldList.length);
        toBase[oldList.length] = String.valueOf(chatUID);
        database.updateUser(requesterid, 11, String.join("-", toBase));

        String[] oldList2 = database.readUser(friendid)[11].split("-");
        String[] toBase2 = new String[oldList2.length+1];
        System.arraycopy(oldList2, 0 ,toBase2, 0, oldList2.length);
        toBase2[oldList2.length] = String.valueOf(chatUID);
        database.updateUser(friendid, 11, String.join("-", toBase2));


        return chatUID;
    }

    @Override
    public String[] getChatInfo(int chatUid) {
        String[] toReturn = new String[3];
        toReturn[0] = String.valueOf(chatUid);
        toReturn[1] = database.readChat(chatUid)[1];
        toReturn[2] = database.readUser(chatUid)[2];

        return toReturn;
    }

    @Override
    public void deleteFriendbyID(int User, int user2) {
        //delete uid of user2 in User`s friendlist
        deleteFriendbyID_helper(User, user2);

        //delete uid of User in user2`s friendlist
        deleteFriendbyID_helper(user2, User);
    }

    public void deleteFriendbyID_helper(int User, int user2) {
        String[] friend = database.readUser(User);
        List<String> friendList = new LinkedList<>(Arrays.asList(friend[6].split("-")));
        friendList.remove(String.valueOf(user2));
        friend[6] = String.join("-", friendList.toArray(new String[0]));
        database.updateUser(User, friend);
    }

    @Override
    public void deleteFriendbyName(String User, String user2) {
        int user1id = getUIDbyUserName(User);
        int user2id = getUIDbyUserName(user2);
        deleteFriendbyID(user1id, user2id);
    }

    @Override
    public void deleteChat(int chatUid)
    {
        database.updateChat(chatUid, 5, "");
    }


    @Override
    public int getUIDbyUserName(String userName) {
        int uid = -1;
        int i  = 0;
        while (database.checkUserExist(i))
        {
            if (Objects.equals(database.readUser(i)[1], userName))
            {
                uid = i;
            }
            i ++;
        }
        return uid;
    }

    @Override
    public String getUserNamebyUID(int uid) {
        return database.readUser(uid)[1];
    }

    @Override
    public String getAddress(int uid) {
        return database.readUser(uid)[7];
    }

    @Override
    public int getPeerPort(int uid) {
        return Integer.parseInt(database.readUser(uid)[10]);
    }

    @Override
    public boolean ifexistsUserName(String userName) {
        boolean result = false;
        int i  = 0;
        while (database.checkUserExist(i))
        {
            if (Objects.equals(database.readUser(i)[1], userName))
            {
                result = true;
            }
            i ++;
        }
        return result;
    }

    @Override
    public boolean ifexistsUID(int uid) {
        return database.checkUserExist(uid);
    }

    @Override
    public void requestFriendbyID(int requesterid, int friendid)
    {
        // Take out the row of information that belongs to friendid
        String[] friend = database.readUser(friendid);

        // Take out requesters, add the new requester
        List<String> requesterList = new LinkedList<>(Arrays.asList(friend[9].split("-")));
        requesterList.add(String.valueOf(requesterid));

        // Store back to database.
        friend[9] = String.join("-", requesterList.toArray(new String[0]));
        database.updateUser(friendid, friend);
    }

    @Override
    public void requestFriendbyName(String requester, String friend) {
        int requesterUID = getUIDbyUserName(requester);
        int friendUID = getUIDbyUserName(friend);
        requestFriendbyID(requesterUID, friendUID);
    }

    @Override
    public boolean notAlreadyFriend(int requester, int friend)
    {
        String[] requester_data = database.readUser(requester);
        List<String> FriendList = new LinkedList<>(Arrays.asList(requester_data[6].split("-")));
        return !FriendList.contains(String.valueOf(friend));
    }

    @Override
    public boolean notAlreadyRequested(int requester, int friend)
    {
        System.out.println(requester + friend);
        String[] friendData = database.readUser(friend);
        List<String> requesterList = new LinkedList<>(Arrays.asList(friendData[9].split("-")));
        return !requesterList.contains(String.valueOf(requester));
    }



    @Override
    public void cleanRequesterListDuplicateUID(int requester) {
        String[] requester_data = database.readUser(requester);
        List<String> requesterList = new LinkedList<>(Arrays.asList(requester_data[9].split("-")));
        List<String> result = new LinkedList<String>();
        for (String item : requesterList){
            if (!result.contains(item)){
                result.add(item);
            }
        }
        requester_data[9] = String.join("-", result.toArray(new String[0]));
        database.updateUser(requester, requester_data);
    }

    @Override
    public StringBuilder getFriendList(int requestorid) {
        StringBuilder result = new StringBuilder();
        String[] requester = database.readUser(requestorid);
        List<String> requesterList = new LinkedList<>(Arrays.asList(requester[9].split("-")));
        for(String item : requesterList){
            int id = Integer.parseInt(item);
            result.append(item);
            result.append(" ");
            result.append(getUserNamebyUID(id));
        }
        return result;
    }
}
