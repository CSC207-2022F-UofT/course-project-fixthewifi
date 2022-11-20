package usecases.register;

public interface RegisterDBGateWay {
    int RegisterAndReturnUID(String username, String password);
}