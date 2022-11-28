package interface_adapters.delete_account;
import usecases.delete_account.DeleteInputBoundary;


public class DeleteController {
    final DeleteInputBoundary inbound;

    public DeleteController(DeleteInputBoundary bound){
        this.inbound = bound;
    }
    void logout(int uid){
        inbound.delete(uid);
    }
}
