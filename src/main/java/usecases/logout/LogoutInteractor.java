package usecases.logout;

public class LogoutInteractor implements LogoutInputBoundary{
    final LogoutDBGateWay db;
    final LogoutOutputBoundary outbound;

    public LogoutInteractor(LogoutDBGateWay db, LogoutOutputBoundary outputBoundary){
        this.db = db;
        this.outbound = outputBoundary;
    }
    @Override
    public void logout(int uid){
        db.logoutByUID(uid);
        outbound.successAndRedirect();
    }
}