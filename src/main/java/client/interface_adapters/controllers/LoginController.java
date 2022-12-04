package client.interface_adapters.controllers;

import client.frameworks_and_drivers.communication_manager.IfComManager;
import client.interface_adapters.model.Model;
import server.frameworks_and_drivers.Constants;

public class LoginController implements LoginControllerInputBoundary
{
    private final IfComManager comManager;
    private final Model model;
    char CONTENT_SPR = 30;
    private final String serverIp;


    public LoginController(IfComManager comManager, Model model, String serverIp)
    {
        this.comManager = comManager;
        this.model = model;
        this.serverIp = serverIp;
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

}
