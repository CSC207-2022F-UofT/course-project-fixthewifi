package test_usecases.test_register;
import server.usecases.register.RegisterDBGateWay;

public class DummyDB implements RegisterDBGateWay{

    @Override
    public int getNewUid(String username, String password){
        return 1;
    }
    @Override
    public void registerUser(int uid, String username, String password, String ipAddress, int port){

    }
}
