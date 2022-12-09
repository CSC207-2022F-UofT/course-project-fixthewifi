package server.usecases.register;


public interface RegisterOutputBoundary {
    /**
     tells the user their UID and tells them that their register is successful
     */
    void successRedirect(int uid, String address, int peerPort, String name);
}
