package client.interface_adapters.model;

public class UserNotFoundException extends Exception {
    public UserNotFoundException(String str) {
        super(str);
    }
}
