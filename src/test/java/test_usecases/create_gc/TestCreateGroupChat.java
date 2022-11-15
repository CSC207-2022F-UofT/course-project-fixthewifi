package test_usecases.create_gc;

import entities.User;
import entities.CommonUser;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import usecases.create_gc.CreateGCInputData;
import usecases.create_gc.CreateGCInteractor;
import usecases.create_gc.CreateGCOutputData;

import java.time.LocalDateTime;
import java.util.ArrayList;

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
        ArrayList<User> members = new ArrayList<User>();
        members.add(user1);
        members.add(user2);
        members.add(user3);
        LocalDateTime time = LocalDateTime.now();

        CreateGCInputData input = new CreateGCInputData(user1, members, time);
        interactor.create(input);

        Assertions.assertNotNull(db.getUploaded_chat());
    }

    /**
     * tests that the Interactor takes the admin and members from input data and
     * assigns them as the admin and members of the new GroupChat.
     */
    @Test
    public void testCreateUsesInputData(){
        //create interactor
        CreateGCDummyDatabase db = new CreateGCDummyDatabase(123456);
        CreateGCDummyOutputAdapter output_adapter = new CreateGCDummyOutputAdapter();
        CreateGCInteractor interactor = new CreateGCInteractor(db, output_adapter);
        //create input data
        CommonUser user1 = new CommonUser(100000, "a", 1);
        CommonUser user2 = new CommonUser(200000, "b", 2);
        CommonUser user3 = new CommonUser(300000, "c", 3);
        ArrayList<User> members = new ArrayList<User>();
        members.add(user1);
        members.add(user2);
        members.add(user3);
        LocalDateTime time = LocalDateTime.now();

        CreateGCInputData input = new CreateGCInputData(user1, members, time);
        interactor.create(input);

        Assertions.assertEquals(input.getAdmin(), db.getUploaded_chat().getAdmin(), "Incorrect admin added");
        Assertions.assertEquals(input.getMembers(), db.getUploaded_chat().getMembers(), "Incorrect members added");
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
        ArrayList<User> members = new ArrayList<User>();
        members.add(user1);
        members.add(user2);
        members.add(user3);
        LocalDateTime time = LocalDateTime.now();

        CreateGCInputData input = new CreateGCInputData(user1, members, time);
        interactor.create(input);

        Assertions.assertEquals(db.getNewUID(), db.getUploaded_chat().getUid(), "Incorrect UID added");
    }

    /**
     * Tests that Interactor calls PrepareSuccessView() on the CreateGCOutputAdapter,
     * with the appropriate values assigned for the instance variables of the
     * output data.
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
        ArrayList<User> members = new ArrayList<User>();
        members.add(user1);
        members.add(user2);
        members.add(user3);
        LocalDateTime time = LocalDateTime.now();

        CreateGCInputData input = new CreateGCInputData(user1, members, time);
        interactor.create(input);

        CreateGCOutputData output = new CreateGCOutputData(input.getAdmin(), input.getMembers(), input.getTime());
        Assertions.assertEquals(output.getAdmin(), output_adapter.getOutput().getAdmin(),
                "Incorrect admin added");
        Assertions.assertEquals(output.getMembers(), output_adapter.getOutput().getMembers(),
                "Incorrect members added");
        Assertions.assertEquals(output.getTime(), output_adapter.getOutput().getTime(),
                "Incorrect time added");
    }
}
