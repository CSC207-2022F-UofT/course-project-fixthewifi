package client.interface_adapters.controllers;

public interface LoginControllerInputBoundary
{
    public void register(String userName, String password);
    public void login(int uid, String password);
    public void logout();
    public void delete();
}
