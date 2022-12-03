package server.usecases.friendinteractors;

public interface friendCommonsDSGateway {
    int getUIDbyUserName(String userName);
    String getUserNamebyUID(int uid);
    String getAddress(int uid);
    int getPeerPort(int uid);
    boolean ifexistsUserName(String userName);
    boolean ifexistsUID(int uid);
}
