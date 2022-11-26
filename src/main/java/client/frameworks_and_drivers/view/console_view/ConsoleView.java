package client.frameworks_and_drivers.view.console_view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleView
{
    ActionSorter sorter;

    public ConsoleView()
    {
    }

    public void init() throws IOException
    {
        System.out.println("Application initialized.");
        displayLoginPage();
        while (true)
        {
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(System.in));

            // Reading data using readLine
            String[] cotent = reader.readLine().split(" ", 2);

            sorter.sort(cotent[0], cotent[1]);
        }
    }



//    @Override
//    public void displayMainPage(String userName, ArrayList<String> chatList)
//    {
//        System.out.println("++++++++++++++++++++ " + userName + " ++++++++++++++++++++ ");
//        System.out.println("Friends:");
//        for (String element : chatList)
//        {
//            System.out.println(element);
//        }
//        System.out.println("++++++++++++++++++++ " + userName + " ++++++++++++++++++++ ");
//
//    }

    public void displayLoginPage()
    {
        System.out.println("please enter username: ");
    }

//    @Override
//    public void displayChatPage(ArrayList<ChatMessage> chatList)
//    {
//        System.out.println("++++++++++++++++++++ Conversation with " + chatList.get(0).sentBy + " ++++++++++++++++++++ ");
//
//        for (ChatMessage element : chatList)
//        {
//            System.out.println(element.sentBy + ": " + element.data);
//        }
//    }
//
//    @Override
//    public void setInputListener(InputListener listener) {
//        this.listener = listener;
//    }
}
