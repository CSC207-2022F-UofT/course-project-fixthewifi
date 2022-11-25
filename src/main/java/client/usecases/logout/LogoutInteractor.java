package client.usecases.logout;

import server.usecases.logout.LogoutDBGateWay;
import server.usecases.logout.LogoutInputBoundary;
import server.usecases.logout.LogoutOutputBoundary;

public class LogoutInteractor implements LogoutInputBoundary {
    final server.usecases.logout.LogoutDBGateWay db;
    final LogoutOutputBoundary outbound;

    /**
    This class allows the user to logout of their accounts
     */

    public LogoutInteractor(LogoutDBGateWay db, LogoutOutputBoundary outputBoundary){
        this.db = db;
        this.outbound = outputBoundary;
    }

    /**
     * calls the database gateway to use the logoutByUID function
     * calls the output boundary to redirect the user to a success page
     * @param uid is the UID of the user
     */
    @Override
    public void logout(int uid){
        db.logoutByUID(uid);
        outbound.successAndRedirect();
    }
}
