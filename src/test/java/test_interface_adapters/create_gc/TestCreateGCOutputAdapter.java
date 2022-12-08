package test_interface_adapters.create_gc;
import server.frameworks_and_drivers.Constants;
import server.interface_adapters.create_gc.CreateGCOutputAdapter;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import server.frameworks_and_drivers.communication_manager.Constants.*;
import server.usecases.create_gc.CreateGCOutputData;


import java.util.ArrayList;

public class TestCreateGCOutputAdapter {
    @Test
    public void testPrepareViewUsesComManagerCorrectly(){
        CreateGCComManager com_manager = new CreateGCComManager();
        CreateGCOutputAdapter output_adapter = new CreateGCOutputAdapter(com_manager);

        int admin = 123456;
        ArrayList<Integer> members = new ArrayList<>();
        members.add(111111);
        members.add(222222);
        members.add(333333);
        members.add(444444);
        String peerID = "abc";
        int peerPort = 1;
        CreateGCOutputData output_data = new CreateGCOutputData(admin, members, peerID, peerPort);

        output_adapter.prepareSuccessView(output_data);
        String msg = String.valueOf(Constants.GROUP_CHAT) + Constants.SPR + String.valueOf(admin) + Constants.SPR
                + String.valueOf(111111) + Constants.SPR + String.valueOf(222222) + Constants.SPR
                + String.valueOf(333333) + Constants.SPR + String.valueOf(444444);
        Assertions.assertEquals(peerPort, com_manager.peerPort, "Incorrect peerport.");
        Assertions.assertEquals(peerID, com_manager.peerID, "Incorreect peerID used.");
        Assertions.assertEquals(msg, com_manager.msg, "Incorrect message sent");
    }

}