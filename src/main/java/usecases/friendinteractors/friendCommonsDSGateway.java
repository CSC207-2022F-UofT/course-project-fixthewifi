package usecases.friendinteractors;

public interface friendCommonsDSGateway {
    int getUserNamebyUID(String userName);
    String getUserName(int uid);
    String getAddress(int uid);
    int getPeerPort(int uid);
    boolean ifexistsUserName(String userName);
    boolean ifexistsUID(int uid);
}
