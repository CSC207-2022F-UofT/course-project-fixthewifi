package usecases.register;

public interface RegisterOutputBoundary {
    /**
     redirects the user to the login page
     */
    void successRedirect(int uid);
}
