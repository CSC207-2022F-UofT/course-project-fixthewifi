package server.usecases.friendinteractors;

/**
 * This is a common dataDSGateway for friend features
 */
public interface friendCommonsDSGateway {
    void cleanRequesterListDuplicateUID(int requester);

    int getUIDbyUserName(String userName);
    String getUserNamebyUID(int uid);
    String getAddress(int uid);
    int getPeerPort(int uid);
    boolean ifexistsUserName(String userName);
    boolean ifexistsUID(int uid);
}
