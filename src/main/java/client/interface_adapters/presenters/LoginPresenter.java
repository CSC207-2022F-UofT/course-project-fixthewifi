package client.interface_adapters.presenters;

import client.frameworks_and_drivers.view.console_view.ConsoleView;
import client.interface_adapters.model.Model;

public class LoginPresenter
{
    private final Model model;
    private final ConsoleView view;
    char SPR = 30;


    public LoginPresenter(Model model, ConsoleView view)
    {
        this.model = model;
        this.view = view;
    }

    public void receiveConfirmation(String data)
    {
        String[] content = data.split(String.valueOf(SPR));
        if (content[0].equals("success"))
        {
            model.setSelfStatus(true);
            view.displayLoginSuccess();
            model.setSelfUid(Integer.parseInt(content[1]));
            model.setPageState("MAIN_PAGE");
            System.out.println(model);
        }
        else
        {
            view.displayLoginFail();
        }
//        String[] content = data.split(String.valueOf(SPR));
//        if (Integer.parseInt(content[0]) == 0)
//        {
//            model.setSelfUid(Integer.parseInt(content[1]));
//            model.setSelfName(content[2]);
//            model.setSelfDescription(content[3]);
//            model.setRating(Double.parseDouble(content[4]));
//        }
//        else if ((Integer.parseInt(content[0]) == 1)){
//            boolean status = true;
//            if (content[5] == "F"){
//                status = false;
//            }
//            model.addFriend(Integer.parseInt(content[1]), content[2], content[3], Double.parseDouble(content[4]), status);
//
//        }
//        else
//        {
////            model.addChat();
//        }
//        model.setSelfStatus(true);
//        view.displayLoginSuccess();
    }
}
