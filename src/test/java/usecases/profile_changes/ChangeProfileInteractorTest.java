package usecases.profile_changes;

import entities.CommonUserFactory;
import entities.UserFactory;
import frameworks_and_drivers.ChangeProfileDB;
import frameworks_and_drivers.comManager.ComManagerUser;
import frameworks_and_drivers.comManager.IfComManager;
import interface_adapters.change_profile.ChangeProfileOutputAdapter;
import org.junit.jupiter.api.Test;

public class ChangeProfileInteractorTest {
    @Test
    void setPic() {
        // To test the use case:
        // 1) Create a UserRegisterInteractor and prerequisite objects
        //    (arguments for the UserRegisterInteractor constructor parameters)
        // 2) create the Input Data
        // 3) Call the use case User Input Boundary method to run the use case
        // 4) Check that the Output Data passed to the Presenter is correct
        // 5) Check that the expected changes to the data layer are there.

        // 1) UserRegisterInteractor and prerequisite objects
        // We're going to need a place to save and look up information. We could
        // use FileUser, but because unit tests are supposed to be independent
        // that would make us also reset the file when we are done.
        // Instead, we're going to "mock" that info using a short-lived solution
        // that just keeps the info in a dictionary, and it won't be persistent.
        // (Separately, elsewhere, we will need to test the FileUser works
        // properly.)

        IfComManager ifComManager = new IfComManager() {
            // IT SHOULD BE NEW
            @Override
            public void init(int port, ComManagerUser user) {

            }

            @Override
            public void send(String address, int peerPort, String msg) {

            }
        };
        ChangeProfileGateWayDB profileGateWayDB = new ChangeProfileDB();
        ChangeProfileOutputBoundary outputAdapter = new ChangeProfileOutputBoundary() {
            @Override
            public void setPic(ChangeProfileOutputModel outputModel) {

            }

            @Override
            public void delPic(ChangeProfileOutputModel outputModel) {

            }

            @Override
            public void updateDescr(ChangeProfileOutputModel outputModel) {

            }

            @Override
            public void updateName(ChangeProfileOutputModel outputModel) {

            }

            @Override
            public void errorChangingProfile() {

            }
        };

    }
}
