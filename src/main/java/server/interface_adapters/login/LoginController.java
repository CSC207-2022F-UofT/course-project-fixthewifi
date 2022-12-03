package server.interface_adapters.login;
import server.usecases.login.*;

public class LoginController {
    final LoginInputBoundary usecase;
    char CONTENT_SPR = 30;

    public LoginController(LoginInputBoundary usecase){
        this.usecase = usecase;
    }
    public void login(String msg)
    {
        String[] content = msg.split(String.valueOf(CONTENT_SPR));
        usecase.login(Integer.parseInt(content[0]), content[1]);
    }
}
