package server.usecases.delete_account;

public interface DeleteInputBoundary {
    /*
    Deletes the user's files in the folder named after their uid
     */
    public void delete(int uid);
}
