package server.usecases.delete_account;

public class DeleteInteractor implements DeleteInputBoundary {
    final DeleteDBGateWay db;

    /**
     * This class allows the user to delete their accounts by their uid
     * @author Marcus
     */

    public DeleteInteractor(DeleteDBGateWay db){
        this.db = db;
    }

    /**
     * @param uid is the userid of the user who wants to delete their account
     * calls the database gateway to delete the account's files
     * lets the output adapter redirect the user to a success page
     */
    @Override
    public void delete(int uid){
        db.deleteByUID(uid);
    }
}
