package usecases.logout;

public class LogoutInteractor implements LogoutInputBoundary{
    final LogoutDBGateWay db;

    /**
    This class allows the user to logout of their accounts
     */

    public LogoutInteractor(LogoutDBGateWay db){
        this.db = db;
    }

    /**
     * calls the database gateway to use the logoutByUID function
     * @param uid is the UID of the user
     */
    @Override
    public void logout(int uid){
        db.logoutByUID(uid);
    }
}
