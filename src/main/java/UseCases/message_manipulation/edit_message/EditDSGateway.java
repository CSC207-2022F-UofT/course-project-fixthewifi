package usecases.message_manipulation.edit_message;

import java.util.List;
import java.util.ArrayList;

public interface EditDSGateway {

    void editMessage(int chatUid);

    ArrayList<List<String>> fetchMembersAddress(int chatUid);
}
