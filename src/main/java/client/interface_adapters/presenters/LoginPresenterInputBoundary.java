package client.interface_adapters.presenters;

public interface LoginPresenterInputBoundary {
    void receiveRegisterConfirmation(String content);

    void receiveLoginConfirmation(String content);
}
