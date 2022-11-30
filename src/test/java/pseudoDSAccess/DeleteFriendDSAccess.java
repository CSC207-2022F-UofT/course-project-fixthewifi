//package pseudoDSAccess;
//
//import server.entities.CommonUser;
//import server.deletefriend.friendinteractors.usecases.delete_friend_DSGateway;
//
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.Map;
//import java.util.Objects;
//
//public class DeleteFriendDSAccess implements delete_friend_DSGateway {
//    private final Map<Integer, ArrayList<Integer>> map1 = new java.util.HashMap<>(Collections.emptyMap());
//    private final Map<String, ArrayList<String>> map2 = new java.util.HashMap<>(Collections.emptyMap());
//    private final Map<Integer, ArrayList<Integer>> map3 = new java.util.HashMap<>(Collections.emptyMap());
//    @Override
//    public void deleteFriendbyID(int user1, int user2) {
//        ArrayList<Integer> friendids = new ArrayList<>();
//        friendids.add(1);
//        friendids.add(2);
//        map1.put(0, friendids);
//        map1.get(user1).remove(user2);
//    }
//
//    @Override
//    public void deleteFriendbyName(String user1, String user2) {
//        ArrayList<String> friendnames = new ArrayList<>();
//        friendnames.add("a");
//        friendnames.add("b");
//        map2.put("c", friendnames);
//        map2.get(user1).remove(user2);
//    }
//
//    @Override
//    public boolean findUserByUID(int uid) {
//        ArrayList<Integer> friendnames = new ArrayList<>();
//        friendnames.add(1);
//        friendnames.add(2);
//        map3.put(3, friendnames);
//        return map3.containsKey(uid);
//    }
//
//    @Override
//    public boolean findUserByName(String name) {
//        ArrayList<String> friendnames = new ArrayList<>();
//        friendnames.add("a");
//        friendnames.add("b");
//        map2.put("c", friendnames);
//        return map2.containsKey(name);
//    }
//}
