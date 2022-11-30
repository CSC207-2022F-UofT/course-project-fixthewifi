package tutorial;

import client.frameworks_and_drivers.communication_manager.ClientComManager;
import client.frameworks_and_drivers.view.console_view.ConsoleView;
import client.interface_adapters.controllers.LoginController;
import client.interface_adapters.model.Model;
import client.interface_adapters.controllers.FriendController;
import client.interface_adapters.presenters.FriendPresenter;
import client.interface_adapters.presenters.LoginPresenter;
import server.frameworks_and_drivers.InputSorter;
import server.frameworks_and_drivers.communication_manager.comManager;
import server.frameworks_and_drivers.database.DataAccess;
import server.frameworks_and_drivers.database.Database;
import server.interface_adapters.friend.AcceptFriendOutputAdapter;
import server.interface_adapters.friend.RequestFriendOutputAdapter;
import server.interface_adapters.friend.input.AcceptFriendController;
import server.interface_adapters.friend.input.RequestFriendController;
import server.interface_adapters.register.RegisterController;
import server.interface_adapters.register.RegisterOutputAdapter;
import server.usecases.friendinteractors.acceptfriend.acceptFriendInteractor;
import server.usecases.friendinteractors.requestfriend.requestFriendInteractor;
import server.usecases.register.RegisterInteractor;

public class HelloWorld {

    public static void main(String[] args)
    {
        newServer();
        System.out.println("123456432");

    }

    static void newServer()
    {
        Database database = new Database();
        DataAccess access = new DataAccess(database);

        comManager comManager = new comManager();

        RequestFriendOutputAdapter requestFriendOutputAdapter = new RequestFriendOutputAdapter(comManager);
        requestFriendInteractor requestFriendInteractor = new requestFriendInteractor(requestFriendOutputAdapter, access);
        RequestFriendController requestFriendController = new RequestFriendController(requestFriendInteractor);

        AcceptFriendOutputAdapter acceptFriendOutputAdapter = new AcceptFriendOutputAdapter(comManager);
        acceptFriendInteractor acceptFriendInteractor = new acceptFriendInteractor(access, acceptFriendOutputAdapter);
        AcceptFriendController acceptFriendController = new AcceptFriendController(acceptFriendInteractor);

        RegisterOutputAdapter registerOutputAdapter = new RegisterOutputAdapter(comManager);
        RegisterInteractor registerInteractor = new RegisterInteractor(access, registerOutputAdapter);
        RegisterController registerController = new RegisterController(registerInteractor);



        InputSorter inputSorter = new InputSorter(requestFriendController, acceptFriendController, registerController);
        comManager.init(4396, inputSorter);
    }

    static void newClient()
    {
        ClientComManager comManager = new ClientComManager();
        Model model = new Model();

        FriendController friendController = new FriendController(comManager, model, "127.0.0.1");
        LoginController loginController = new LoginController(comManager, model, "127.0.01");

        ConsoleView view = new ConsoleView(model, loginController, friendController);



        FriendPresenter friendPresenter = new FriendPresenter(model, view);
        LoginPresenter loginPresenter = new LoginPresenter(model, view);

        client.frameworks_and_drivers.InputSorter inputSorter = new client.frameworks_and_drivers.InputSorter(friendPresenter, loginPresenter);
        comManager.init(4444, inputSorter);
        view.init();




    }

    public static String convert(int decide) {
        if (decide % 15 == 0) {
            return "tutorial.HelloWorld";
        }
        if (decide % 3 == 0) {
            return "Hello";
        }
        if (decide % 5 == 0) {
            return "World";
        }
        return String.valueOf(decide);

    }
}
