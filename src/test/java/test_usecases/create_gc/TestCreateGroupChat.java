package test_usecases.create_gc;

import server.entities.CommonUser;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import server.usecases.create_gc.CreateGCInputData;
import server.usecases.create_gc.CreateGCInteractor;


import java.util.ArrayList;
//TODO: test that correct peerPort and PeerID are used in DB.
/**
 * @author Brenden McFarlane
 */
public class TestCreateGroupChat {

    /**
     * tests that the interactor adds a GroupChat to the database.
     */
    @Test
    public void testCreateAddsToDB(){
        //create interactor
        CreateGCDummyDatabase db = new CreateGCDummyDatabase(123456);
        CreateGCDummyOutputAdapter output_adapter = new CreateGCDummyOutputAdapter();
        CreateGCInteractor interactor = new CreateGCInteractor(db, output_adapter);
        //create input data
        CommonUser user1 = new CommonUser(100000, "a", 1);
        CommonUser user2 = new CommonUser(200000, "b", 2);
        CommonUser user3 = new CommonUser(300000, "c", 3);
        ArrayList<Integer> members = new ArrayList<>();
        members.add(user1.getUid());
        members.add(user2.getUid());
        members.add(user3.getUid());
        db.addUser(user1.getUid(), user1);
        db.addUser(user2.getUid(), user2);
        db.addUser(user3.getUid(), user3);

        CreateGCInputData input = new CreateGCInputData(user1.getUid(), members);
        interactor.create(input);

        Assertions.assertNotNull(db.getUploaded_chat());
    }


    /**
     * Tests that the Interactor is using the database to retrieve a unique UID.
     */
    @Test
    public void testCreateUsesCorrectUID(){
        //create interactor
        CreateGCDummyDatabase db = new CreateGCDummyDatabase(123456);
        CreateGCDummyOutputAdapter output_adapter = new CreateGCDummyOutputAdapter();
        CreateGCInteractor interactor = new CreateGCInteractor(db, output_adapter);
        //create input data
        CommonUser user1 = new CommonUser(100000, "a", 1);
        CommonUser user2 = new CommonUser(200000, "b", 2);
        CommonUser user3 = new CommonUser(300000, "c", 3);
        ArrayList<Integer> members = new ArrayList<>();
        members.add(user1.getUid());
        members.add(user2.getUid());
        members.add(user3.getUid());
        db.addUser(user1.getUid(), user1);
        db.addUser(user2.getUid(), user2);
        db.addUser(user3.getUid(), user3);

        CreateGCInputData input = new CreateGCInputData(user1.getUid(), members);
        interactor.create(input);

        Assertions.assertEquals(db.getNewUID(), db.getUploaded_chat().getUid(), "Incorrect UID added");
    }

    /**
      Tests that Interactor calls PrepareSuccessView() on the CreateGCOutputAdapter,
      with the appropriate values assigned for the instance variables of the
      output data.
     */
    @Test
    public void testCreateCallsAdapterCorrectly(){
        //create interactor
        CreateGCDummyDatabase db = new CreateGCDummyDatabase(123456);
        CreateGCDummyOutputAdapter output_adapter = new CreateGCDummyOutputAdapter();
        CreateGCInteractor interactor = new CreateGCInteractor(db, output_adapter);
        //create input data
        CommonUser user1 = new CommonUser(100000, "a", 1);
        CommonUser user2 = new CommonUser(200000, "b", 2);
        CommonUser user3 = new CommonUser(300000, "c", 3);
        ArrayList<Integer> members = new ArrayList<>();
        members.add(user1.getUid());
        members.add(user2.getUid());
        members.add(user3.getUid());
        db.addUser(user1.getUid(), user1);
        db.addUser(user2.getUid(), user2);
        db.addUser(user3.getUid(), user3);

        CreateGCInputData input = new CreateGCInputData(user1.getUid(), members);
        interactor.create(input);

        Assertions.assertEquals(input.getAdmin(), output_adapter.getOutput().getAdmin(),
                "Incorrect admin added");
        for(int x : input.getMembers()){
            Assertions.assertNotNull(db.getUserByUID(x), "Member "+ x + " not added");
        }
        // the list of members of a GroupChat includes the admin, however the output
        Assertions.assertEquals(db.getUploaded_chat().getMembers().size() - 1,
                output_adapter.getOutput().getMembers().size(), "Incorrect number of members added");
    }
}
