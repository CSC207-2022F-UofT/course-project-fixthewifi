package usecases.delete;

public class DeleteInteractor implements DeleteInputBoundary {
    final DeleteDBGateWay db;
    final DeleteOutputBoundary outbound;

    /**
     * This class allows the user to delete their accounts by their uid
     * @author Marcus
     */

    public DeleteInteractor(DeleteDBGateWay db, DeleteOutputBoundary outbound){
        this.db = db;
        this.outbound = outbound;
    }

    /**
     * @param uid is the userid of the user who wants to delete their account
     * calls the database gateway to delete the account's files
     * lets the output adapter redirect the user to a success page
     */
    @Override
    public void delete(int uid){
        db.deleteByUID(uid);
        outbound.success();
    }
}
