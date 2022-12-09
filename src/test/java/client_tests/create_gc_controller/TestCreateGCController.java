package client_tests.create_gc_controller;
import client.frameworks_and_drivers.Constants;
import client.interface_adapters.controllers.CreateGCController;
import client.interface_adapters.model.Model;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestCreateGCController {

    /**
     * This test checks that when CreateGCController.getList() is called, it triggers method
     * comManager.send() appropriately to retrieve the users friendslist.
     */
    @Test
    public void testGetList(){
        ClientComManagerTest comManager = new ClientComManagerTest();
        Model model = new Model();
        model.setSelfUid(123456);
        String iP = "127.0.0.1";
        CreateGCController controller = new CreateGCController(comManager, model, iP);

        controller.getList();

        String msg = Constants.RETRIEVE_FRIENDS_LIST + "#" + model.getSelfUid();
        Assertions.assertEquals(iP, comManager.address, "Incorrect IP address used");
        Assertions.assertEquals(4396, comManager.peerPort, "Incorrect peerport used");
        Assertions.assertEquals(msg, comManager.msg, "Incorrect message sent");
    }

    /**
     * this test ensures when CreateGCController.create() is called, it triggers the method
     * ComManager.send() appropriately to make a group chat with the specified users.
     */
    @Test
    public void testCreate(){
        ClientComManagerTest comManager = new ClientComManagerTest();
        Model model = new Model();
        model.setSelfUid(123456);
        String iP = "127.0.0.1";
        CreateGCController controller = new CreateGCController(comManager, model, iP);

        controller.create("111111, 222222, 333333, 444444");

        String msg = Constants.GROUP_CHAT + "#" + "123456" + Constants.SPR + "111111" + Constants.SPR +
                "222222" + Constants.SPR + "333333" + Constants.SPR + "444444";
        Assertions.assertEquals(iP, comManager.address, "Incorrect IP address used");
        Assertions.assertEquals(4396, comManager.peerPort, "Incorrect peerport used");
        Assertions.assertEquals(msg, comManager.msg, "Incorrect message sent");

    }

}
