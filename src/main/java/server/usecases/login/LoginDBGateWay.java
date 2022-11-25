package server.usecases.login;
import java.util.*;

public interface LoginDBGateWay {
    boolean check(int UID, String password);

    List<Integer> getFriendUIDByUID(int uid);
    List<Integer> getPrivateChatsByUID(int uid);
    List<Integer> getGroupChatsByUID(int uid);

}
