package usecases.register;

import usecases.login.LoginDBGateWay;

public class RegisterInteractor implements RegisterInputBoundary {
    final RegisterDBGateWay db;
    final RegisterOutputBoundary outbound;

    public RegisterInteractor(RegisterDBGateWay db, RegisterOutputBoundary outbound){
        this.db = db;
        this.outbound = outbound;
    }

    @Override
    public void register(String username, String password){
        int uid = db.RegisterAndReturnUID(username, password);
        outbound.success(uid);
    }
}
