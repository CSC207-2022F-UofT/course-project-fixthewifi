package server.interface_adapters.delete_account;
import server.frameworks_and_drivers.communication_manager.IfComManager;
import server.usecases.delete_account.*;
import server.usecases.delete_account.DeleteInputBoundary;


public class DeleteController {
    final DeleteInputBoundary inbound;

    public DeleteController(DeleteInputBoundary bound){
        this.inbound = bound;
    }
    void logout(int uid){
        inbound.delete(uid);
    }
}
