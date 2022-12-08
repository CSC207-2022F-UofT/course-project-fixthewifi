package client.interface_adapters.controllers;
import client.frameworks_and_drivers.Constants;

import client.frameworks_and_drivers.communication_manager.IfComManager;
import client.interface_adapters.model.Model;

public class LoginController implements LoginControllerInputBoundary
{
    int serverport;

    private final IfComManager comManager;
    private final Model model;
    char CONTENT_SPR = 30;
    private final String serverIp;


    public LoginController(IfComManager comManager, Model model, String serverIp, int serverPort)
    {
        this.comManager = comManager;
        this.model = model;
        this.serverIp = serverIp;
        this.serverport = serverPort;

    }

    public void register(String userName, String password)
    {

        String toSend = Constants.REGISTER + "#" + userName + CONTENT_SPR + password;
        comManager.send(serverIp, 4396, toSend);
    }

    @Override
    public void login(int uid, String password) {
        String toSend = Constants.LOGIN + "#" + uid + CONTENT_SPR + password;
        comManager.send(serverIp, 4396, toSend);
    }

    @Override
    public void logout(){
        int uid = model.getSelfUid();
        String toSend = Constants.LOGOUT + "#" + uid;
        comManager.send(serverIp, 4396, toSend);
        model.setPageState("LOGIN_PAGE");
        System.out.println("Signed out.");
    }

    @Override
    public void delete(){
        int uid = model.getSelfUid();
        String toSend = Constants.DELETE_ACCOUNT + "#" + uid;
        comManager.send(serverIp, 4396, toSend);
        model.setPageState("LOGIN_PAGE");
        System.out.println("Signed out.");
    }
}
