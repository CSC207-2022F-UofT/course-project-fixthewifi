package test_usecases.test_register;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import server.usecases.register.RegisterInteractor;

public class TestRegister {
    /*
    tests the server side of the registration
     */
    @Test
    public void testRegisterUID(){
        DummyDB db = new DummyDB();
        DummyOutputAdapter outbound = new DummyOutputAdapter();
        RegisterInteractor interactor = new RegisterInteractor(db, outbound);
        interactor.register("Marcus", "123", "100", 123);
        Assertions.assertEquals(outbound.uid, 1);
    }
    @Test
    public void testRegisterPeerport(){
        DummyDB db = new DummyDB();
        DummyOutputAdapter outbound = new DummyOutputAdapter();
        RegisterInteractor interactor = new RegisterInteractor(db, outbound);
        interactor.register("Marcus", "123", "100", 123);
        Assertions.assertEquals(outbound.peerPort, 4444);
    }
}
