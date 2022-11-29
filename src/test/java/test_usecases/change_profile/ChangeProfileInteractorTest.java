package test_usecases.change_profile;

import entities.CommonUserFactory;
import entities.ProfilePicture;
import entities.UserFactory;
import frameworks_and_drivers.ChangeProfileDB;
import frameworks_and_drivers.communication_manager.ComManagerUser;
import frameworks_and_drivers.communication_manager.IfComManager;
import interface_adapters.change_profile.ChangeProfileController;
import interface_adapters.change_profile.ChangeProfileOutputAdapter;
import org.junit.jupiter.api.Test;
import usecases.profile_changes.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ChangeProfileInteractorTest {
//    @Test
//    void updateNametest() {
//        // To test the use case:
//        // 1) Create a UserRegisterInteractor and prerequisite objects
//        //    (arguments for the UserRegisterInteractor constructor parameters)
//        // 2) create the Input Data
//        // 3) Call the use case User Input Boundary method to run the use case
//        // 4) Check that the Output Data passed to the Presenter is correct
//        // 5) Check that the expected changes to the data layer are there.
//
//        // 1) UserRegisterInteractor and prerequisite objects
//        // We're going to need a place to save and look up information. We could
//        // use FileUser, but because unit tests are supposed to be independent
//        // that would make us also reset the file when we are done.
//        // Instead, we're going to "mock" that info using a short-lived solution
//        // that just keeps the info in a dictionary, and it won't be persistent.
//        // (Separately, elsewhere, we will need to test the FileUser works
//        // properly.)
//        IfComManager comManager = null;
//        final ChangeProfileGateWayDB database = new ChangeProfileDB();
//        final ChangeProfileOutputBoundary output = new ChangeProfileOutputAdapter(comManager);
//        ChangeProfileInteractor interactor = new ChangeProfileInteractor( database, output);
//
//         final int profileUID=1;
//         final ProfilePicture pic = new ProfilePicture(new byte[]{0x4f});
//         final String name = "kotya";
//         final String description= "test description kotya";
//
//        ChangeProfileInputModel inputModel = new ChangeProfileInputModel(profileUID,name,description,pic);
//        interactor.updateName(inputModel);
//
//         final String useraddress = "adress";
//         final int userport = 3;
//
//         final String changeStatusMessage ="Name updated successfully!";
//         ChangeProfileOutputModel outputModel = new ChangeProfileOutputModel(useraddress,userport,profileUID,changeStatusMessage);
//
//
//
//    }
}
