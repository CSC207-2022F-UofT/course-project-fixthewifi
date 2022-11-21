package usecases.delete_account;

public interface DeleteDBGateWay {
    /*
    Delete the user's files by the uid
     */
    public void deleteByUID(int uid);
}
