package client.interface_adapters.presenters;

import client.frameworks_and_drivers.view.console_view.ConsoleView;
import client.interface_adapters.model.Model;
import client.interface_adapters.model.ModelInterface;
import client.interface_adapters.model.model_entities.UserFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LoginPresenter implements LoginPresenterInputBoundary
{
    private final ModelInterface model;
    char SPR = 30;

    private final int MSG_START_POS = 6;


    public LoginPresenter(ModelInterface model)
    {
        this.model = model;
    }

    /**
     * Determines the type of login information and calls the corresponding helper method to construct all local data.
     * @param data1 the data string from the server, the head of the string contains the case number
     */
    public void receiveLoginConfirmation(String data1)
    {
        String[] content = data1.split(" ", 2);
        if (Integer.parseInt(content[0]) == 0)
        {
            String[] data = content[1].split(String.valueOf(SPR));
            addSelfProfile(data);
            System.out.println(model);
            model.setPageState("MAIN_PAGE");
        }
        else if (Integer.parseInt(content[0]) == 1)
        {
            String[] data = content[1].split(String.valueOf(SPR));
            addFriendProfile(data);
            System.out.println(model);
            model.setPageState("MAIN_PAGE");
        }
        else if (Integer.parseInt(content[0]) == 2)
        {
            String[] data = content[1].split(String.valueOf(SPR));
            addChatData(data);
            System.out.println(model);
            model.setPageState("MAIN_PAGE");
        }
        else if (Integer.parseInt(content[0]) == 3)
        {
            String[] data = content[1].split(String.valueOf(SPR));
            addUserData(data);
            System.out.println(model);
            model.setPageState("MAIN_PAGE");
        }
        else if (Integer.parseInt(content[0]) == 4)
        {
            model.notifyView("Login failed.");
        }
    }

    /**
     * Takes in data from the server and displays confirmation.
     * @param "success" or "fail"
     */
    public void receiveRegisterConfirmation(String data)
    {
        String[] content = data.split(String.valueOf(SPR));
        if (content[0].equals("success"))
        {
//            model.setSelfStatus(true);
            model.setSelfName(content[2]);
            model.notifyView("Successfully registered.");
            model.setSelfUid(Integer.parseInt(content[1]));
            model.setPageState("MAIN_PAGE");
            System.out.println(model);
        }
        else
        {
            model.notifyView("Register failed.");

        }
    }

    /**
     * Takes in data array sent from the server and creates self object, with empty chat list and empty friendlist.
     * @param data content of a chat in string array format, arranged in the format the same as a database row.
     */
    private void addSelfProfile(String[] data)
    {
        model.setSelfUid(Integer.parseInt(data[0]));
        model.setSelfName(data[1]);
        model.setSelfStatus(true);
        model.setSelfDescription(data[2]);
        model.setRating(Double.parseDouble(data[3].split("-")[0]));
    }

    /**
     * Takes in data array sent from the server and creates friend object locally.
     * @param data content of a chat in string array format, arranged in the format the same as a database row.
     */
    private void addFriendProfile(String[] data)
    {
        boolean online = data[4].equals("T");
        model.addFriend(Integer.parseInt(data[0]), data[1], data[2], Double.parseDouble(data[3].split("-")[0]), online);
    }

    /**
     * Takes in data array sent from the server and creates chat object locally, the type of chat created dedpends on if the admin is -1.
     * @param data content of a chat in string array format, arranged in the format the same as a database row.
     */
    private void addChatData(String[] data)
    {
        System.out.println(Arrays.toString(data));
        if (Integer.parseInt(data[4]) == -1)
        {
            String[] members = data[5].split("-");
            int friendUid = Integer.parseInt(members[0]);
            if (friendUid == model.getSelfUid())
            {
                friendUid = Integer.parseInt(members[1]);
            }
            model.addPrivateChat(Integer.parseInt(data[0]), data[1], data[2], friendUid);
            for (int i = MSG_START_POS; i< data.length; i++)
            {
                String[] msgContent = data[i].split("-");
                model.addMsg(i-MSG_START_POS, Integer.parseInt(msgContent[0]), msgContent[2], msgContent[1], Integer.parseInt(data[0]));
            }
        }
        else
        {
            String[] members = data[5].split("-");
            List<Integer> membersUid = new ArrayList<>();
            for (String member : members)
            {
                membersUid.add(Integer.parseInt(member));
            }
            model.addGroupChat(Integer.parseInt(data[0]), data[1], data[2], Integer.parseInt(data[4]), membersUid);
            for (int i = MSG_START_POS; i< data.length; i++)
            {
                String[] msgContent = data[i].split("-");
                model.addMsg(i-MSG_START_POS, Integer.parseInt(msgContent[0]), msgContent[2], msgContent[1], Integer.parseInt(data[0]));
            }
        }
    }

    private void addUserData(String[] data)
    {
        boolean online = data[4].equals("T");
        model.addUserToChat(Integer.parseInt(data[0]), data[1], data[2], Double.parseDouble(data[3].split("-")[0]), online, Integer.parseInt(data[12]), Integer.parseInt(data[13]));
    }
}
