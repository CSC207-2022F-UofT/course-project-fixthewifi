package client.usecases.delete_account;

import server.usecases.delete_account.DeleteDBGateWay;
import server.usecases.delete_account.DeleteInputBoundary;
import server.usecases.delete_account.DeleteOutputBoundary;

public class DeleteInteractor implements DeleteInputBoundary {
    final server.usecases.delete_account.DeleteDBGateWay db;
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
