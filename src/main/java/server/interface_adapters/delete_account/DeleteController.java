package server.interface_adapters.delete_account;
import server.frameworks_and_drivers.communication_manager.IfComManager;
import server.usecases.delete_account.*;
import server.usecases.delete_account.DeleteInputBoundary;


public class DeleteController {
    /*
    This class parses the string msg into an integer uid, which is the uid of the
    user that wants to delete their account, and passes it through the deleteinputboundary
     */
    final DeleteInputBoundary inbound;

    public DeleteController(DeleteInputBoundary bound){
        this.inbound = bound;
    }
    public void delete(String msg){
        int uid = Integer.valueOf(msg);
        inbound.delete(uid);
    }
}
