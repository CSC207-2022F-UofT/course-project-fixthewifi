package start;

import client.frameworks_and_drivers.communication_manager.ClientComManager;
import client.frameworks_and_drivers.view.console_view.ConsoleView;
import client.interface_adapters.controllers.*;

import client.interface_adapters.model.Model;
import client.interface_adapters.presenters.*;
import server.interface_adapters.InputSorter;
import server.frameworks_and_drivers.communication_manager.ComManager;
import server.frameworks_and_drivers.database.data_access.*;
import server.frameworks_and_drivers.database.Database;
import server.interface_adapters.delete_account.DeleteController;
import server.interface_adapters.change_profile.ChangeProfileController;
import server.interface_adapters.change_profile.ChangeProfileOutputAdapter;
import server.interface_adapters.edit_delete_msg.EditMessageOutputAdapter;
import server.interface_adapters.edit_delete_msg.EditMsgController;
import server.interface_adapters.friend.AcceptFriendOutputAdapter;
import server.interface_adapters.friend.DeleteFriendOutputAdapter;
import server.interface_adapters.friend.RequestFriendOutputAdapter;
import server.interface_adapters.friend.input.AcceptFriendController;
import server.interface_adapters.friend.input.DeleteFriendController;
import server.interface_adapters.friend.input.RequestFriendController;
import server.interface_adapters.login.LoginOutputAdapter;
import server.interface_adapters.register.RegisterController;
import server.interface_adapters.register.RegisterOutputAdapter;
import server.interface_adapters.send_message.SendMsgOutputAdapter;
import server.usecases.edit_message.EditInteractor;
import server.usecases.friendinteractors.acceptfriend.acceptFriendInteractor;
import server.usecases.friendinteractors.deletefriend.delete_friend_interactor;
import server.usecases.friendinteractors.requestfriend.requestFriendInteractor;
import server.usecases.login.LoginInteractor;
import server.usecases.logout.LogoutInteractor;
import server.interface_adapters.send_message.SendMsgController;
import server.usecases.profile_changes.ChangeProfileGateWayDB;
import server.usecases.profile_changes.ChangeProfileInteractor;
import server.usecases.profile_changes.ChangeProfileOutputBoundary;
import server.usecases.register.RegisterInteractor;
import server.interface_adapters.logout.LogoutController;
import server.usecases.delete_account.DeleteInteractor;
import server.interface_adapters.change_rating.SendRatingOutputAdapter;
import server.interface_adapters.change_rating.SendRatingController;
import server.usecases.rating_changes.SendRatingInteractor;
import server.usecases.send_message.SendMsgInteractor;


public class Main {

    public static void main(String[] args)
    {
        int serverPort = 4396;
        int clientPort = 4444;
        String serverIp = "127.0.0.1";
        newServer(serverPort, false);
        newClient(serverPort, serverIp, clientPort, false);
        System.out.println("123456432");
    }

    static void newServer(int serverPort, boolean debug)
    {
        Database database = new Database("User.csv", "Chat.csv");

        ComManager comManager = new ComManager(debug);

        FriendDataAccess friendAccess = new FriendDataAccess(database);
        RequestFriendOutputAdapter requestFriendOutputAdapter = new RequestFriendOutputAdapter(comManager);
        requestFriendInteractor requestFriendInteractor = new requestFriendInteractor(requestFriendOutputAdapter, friendAccess);
        RequestFriendController requestFriendController = new RequestFriendController(requestFriendInteractor);

        AcceptFriendOutputAdapter acceptFriendOutputAdapter = new AcceptFriendOutputAdapter(comManager);
        acceptFriendInteractor acceptFriendInteractor = new acceptFriendInteractor(friendAccess, acceptFriendOutputAdapter);
        AcceptFriendController acceptFriendController = new AcceptFriendController(acceptFriendInteractor);

        DeleteFriendOutputAdapter deleteFriendOutputAdapter = new DeleteFriendOutputAdapter(comManager);
        delete_friend_interactor delete_friend_interactor = new delete_friend_interactor(friendAccess, deleteFriendOutputAdapter);
        DeleteFriendController deleteFriendController = new DeleteFriendController(delete_friend_interactor);


        LoginDataAccess loginAccess = new LoginDataAccess(database);
        RegisterOutputAdapter registerOutputAdapter = new RegisterOutputAdapter(comManager);
        RegisterInteractor registerInteractor = new RegisterInteractor(loginAccess, registerOutputAdapter);
        RegisterController registerController = new RegisterController(registerInteractor);

        LoginOutputAdapter loginOutputAdapter = new LoginOutputAdapter(comManager);
        LoginInteractor loginInteractor = new LoginInteractor(loginAccess, loginOutputAdapter);
        server.interface_adapters.login.LoginController loginController = new server.interface_adapters.login.LoginController(loginInteractor);

        LogoutInteractor logoutInteractor = new LogoutInteractor(loginAccess);
        LogoutController logoutController = new LogoutController(logoutInteractor);

        ChangeProfileGateWayDB changeProfileGateWayDB = new ChPrAccess(database);
        ChangeProfileOutputBoundary changeProfileOutput= new ChangeProfileOutputAdapter(comManager);
        ChangeProfileInteractor changeProfileInteractor= new ChangeProfileInteractor( changeProfileGateWayDB ,changeProfileOutput);
        ChangeProfileController changeProfileController = new ChangeProfileController(changeProfileInteractor);

        DeleteInteractor deleteInteractor = new DeleteInteractor(loginAccess);
        DeleteController deleteController = new DeleteController(deleteInteractor);

        RatingDataAccess ratingAccess = new RatingDataAccess(database);
        SendRatingOutputAdapter sendRatingOutputAdapter = new SendRatingOutputAdapter(comManager);
        SendRatingInteractor sendRatingInteractor = new SendRatingInteractor(ratingAccess, sendRatingOutputAdapter);
        SendRatingController sendRatingController = new SendRatingController(sendRatingInteractor);

        SendMsgDataAccess sendMsgDsGateway = new SendMsgDataAccess(database);
        SendMsgOutputAdapter sendMsgOutputAdapter = new SendMsgOutputAdapter(comManager);
        SendMsgInteractor sendMsgInteractor = new SendMsgInteractor(sendMsgDsGateway, sendMsgOutputAdapter);
        SendMsgController sendMsgController = new SendMsgController(sendMsgInteractor);

        EditMessageOutputAdapter editMessageOutputAdapter = new EditMessageOutputAdapter(comManager);
        EditInteractor editInteractor = new EditInteractor(sendMsgDsGateway, editMessageOutputAdapter);
        EditMsgController editMsgController = new EditMsgController(editInteractor);

        InputSorter inputSorter = new InputSorter(requestFriendController, acceptFriendController, registerController, deleteFriendController, loginController, logoutController, deleteController, changeProfileController, sendRatingController, sendMsgController, editMsgController);

        comManager.init(serverPort, inputSorter);
        System.out.println("Server initialized.");
    }

    static void newClient(int serverPort, String serverIp, int clientPort, boolean debug)
    {
        ClientComManager comManager = new ClientComManager(debug);
        Model model = new Model();

        FriendController friendController = new FriendController(comManager, model, serverIp, serverPort);
        LoginController loginController = new LoginController(comManager, model, serverIp, serverPort);
        RatingController ratingController = new RatingController(comManager, model, serverIp, serverPort);
        ChPrController chPrController = new ChPrController(comManager,model, serverIp, serverPort);
        client.interface_adapters.controllers.SendMsgController sendMsgController = new client.interface_adapters.controllers.SendMsgController(comManager, model, serverIp, serverPort);
        DeleteEditMsgController deleteEditMsgController = new DeleteEditMsgController(comManager, model, serverIp, serverPort);

        ConsoleView view = new ConsoleView(model, loginController, friendController, chPrController, ratingController, sendMsgController, deleteEditMsgController);
        model.addObserver(view);

        FriendPresenter friendPresenter = new FriendPresenter(model);
        LoginPresenter loginPresenter = new LoginPresenter(model);
        RatingPresenter ratingPresenter = new RatingPresenter(model);
        ChPrPresenter chPrPresenter=new ChPrPresenter(model);
        SendMsgPresenter sendMsgPresenter = new SendMsgPresenter(model);
        EditDeleteMsgPresenter editDeleteMsgPresenter = new EditDeleteMsgPresenter(model);

        client.frameworks_and_drivers.InputSorter inputSorter = new client.frameworks_and_drivers.InputSorter(friendPresenter, loginPresenter, chPrPresenter, ratingPresenter, sendMsgPresenter, editDeleteMsgPresenter);
        comManager.init(clientPort, inputSorter);
        view.init();
        System.out.println("Client initialized.");
    }
}
