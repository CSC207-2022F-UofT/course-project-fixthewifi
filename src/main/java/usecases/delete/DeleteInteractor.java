package usecases.delete;

public class DeleteInteractor implements DeleteInputBoundary {
    final DeleteDBGateWay db;
    final DeleteOutputBoundary outbound;

    public DeleteInteractor(DeleteDBGateWay db, DeleteOutputBoundary outbound){
        this.db = db;
        this.outbound = outbound;
    }

    @Override
    public void delete(String uid){
        db.deleteByUID(uid);
        outbound.success();
    }
}
