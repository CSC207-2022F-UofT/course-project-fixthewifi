package server.interface_adapters.login;
import server.usecases.login.*;
import server.frameworks_and_drivers.communication_manager.IfComManager;


public class LoginOutputAdapter implements LoginOutputBoundary {
    final IfComManager comManager;
    public LoginOutputAdapter(IfComManager com){
        this.comManager = com;
    }
    @Override
    public void error(String message, String address, int userPort){
        comManager.send(address, userPort, message);
    }
    @Override
    public void ifSuccess(int uid, String userProfile, String chatList, String friendList, String address, int userPort){
        comManager.send(address, userPort, Integer.toString(uid));
        comManager.send(address, userPort, userProfile);
        comManager.send(address, userPort, chatList);
        comManager.send(address, userPort, friendList);
    }
}
