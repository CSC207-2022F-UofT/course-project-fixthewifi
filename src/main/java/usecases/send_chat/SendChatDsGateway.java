package usecases.send_chat;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public interface SendChatDsGateway
{
    void storeChat(int chatUid, int senderUid, String content, String time);

    ArrayList<List<String>> fetchAllAddressByChatUid(int chatUid);
}
