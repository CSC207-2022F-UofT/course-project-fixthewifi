package server.usecases.register;

public interface RegisterInputBoundary {
    /**
     * Registers the users new account using their username and password
     * @param username is the username of the user
     * @param password is the password of the user
     */
    public void register(String username, String password);
}
