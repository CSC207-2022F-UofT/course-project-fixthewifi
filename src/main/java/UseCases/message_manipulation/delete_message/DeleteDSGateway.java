package usecases.message_manipulation.delete_message;

import java.util.List;
import java.util.ArrayList;
public interface DeleteDSGateway {

    void deleteMessage(int chatUid);

    ArrayList<List<String>> fetchMembersAddress(int chatUid);

    }

