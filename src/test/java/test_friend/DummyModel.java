package test_friend;

import client.interface_adapters.model.ChatNotFoundException;
import client.interface_adapters.model.ModelInterface;

import java.util.List;

class DummyModel implements ModelInterface {

    @Override
    public String getFriendName(int friendUid) {
        return null;
    }

    @Override
    public int getSelfUid() {
        return 0;
    }

    @Override
    public void setSelfUid(int uid) {

    }

    @Override
    public String getDescription(int userUid) {
        return null;
    }

    @Override
    public void addFriend(int uid, String name, String description, double rating, boolean online) {

    }

    @Override
    public void addPrivateChat(int uid, String name, String description, int friendUid) {

    }

    @Override
    public String getPageState() {
        return null;
    }

    @Override
    public void setPageState(String state) {

    }

    @Override
    public int findPrivateChat(int friendUid) {
        return 0;
    }

    @Override
    public void setSelfName(String s) {

    }

    @Override
    public void setSelfDescription(String s) {

    }

    @Override
    public void setRating(double parseDouble) {

    }

    @Override
    public void addRequester(int uid, String name) {

    }

    @Override
    public void deleteFriend(int friendUid) {

    }

    @Override
    public String printChatHistory(int chatUid) {
        return null;
    }

    @Override
    public void deletePrivateChat(int friendUid) {

    }

    @Override
    public void setSelfStatus(boolean b) {

    }

    @Override
    public void addUserToChat(int parseInt, String datum, String datum1, double parseDouble, boolean online, int parseInt1, int parseInt2) {

    }

    @Override
    public void addMsg(int msgUid, int senderUid, String content, String time, int chatUid) {

    }

    @Override
    public void addGroupChat(int parseInt, String datum, String datum1, int parseInt1, List<Integer> membersUid) {

    }

    @Override
    public void notifyView(String data) {

    }

    @Override
    public String showSelfProfile() {
        return null;
    }

    @Override
    public String showChats() {
        return null;
    }

    @Override
    public String showChat(int chatUid) throws ChatNotFoundException {
        return null;
    }

    @Override
    public String showFriends() {
        return null;
    }
}