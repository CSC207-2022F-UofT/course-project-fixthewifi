package test_interface_adapters.retrieve_friendslist;
import server.frameworks_and_drivers.Constants;
import server.frameworks_and_drivers.communication_manager.IfComManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import server.interface_adapters.retrieve_friendslist.RetrieveFriendsListOutputAdapter;
import server.usecases.retrieve_friendslist.RetrieveFriendsListOutputData;

import java.util.ArrayList;

public class TestRetrieveFriendsListOutputAdapter {
    @Test
    public void testRetrieveFriendsListOutputAdapter(){
        // output_data
        int UID = 1233456;
        ArrayList<String> users = new ArrayList<>();
        users.add("111111" + Constants.SPR + "username1");
        users.add("222222" + Constants.SPR + "username2");
        users.add("333333" + Constants.SPR + "username3");
        int peer_port = 4;
        String peerID = "asdfg";
        RetrieveFriendsListOutputData output_data = new RetrieveFriendsListOutputData(UID, users, peer_port, peerID);
        // output_adapter
        TestRetrieveFriendsListComManager com_manager = new TestRetrieveFriendsListComManager();
        RetrieveFriendsListOutputAdapter output_adapter = new RetrieveFriendsListOutputAdapter(com_manager);

        output_adapter.prepareView(output_data);

        Assertions.assertEquals(peerID, com_manager.address, "Incorrect IP address used.");
        Assertions.assertEquals(peer_port, com_manager.peerPort, "Incorect peer port used");
        String str = String.valueOf(Constants.RETRIEVE_FREINDSLIST) + Constants.SPR + "111111" + Constants.SPR +
                "username1" + Constants.SPR + "222222" + Constants.SPR + "username2" + Constants.SPR +
                "333333" +Constants.SPR + "username3";
        Assertions.assertEquals(str, com_manager.msg, "Incorrect message parsed");
    }

}
