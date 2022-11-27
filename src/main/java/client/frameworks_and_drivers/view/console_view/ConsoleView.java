package client.frameworks_and_drivers.view.console_view;

import client.interface_adapters.model.Model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;

public class ConsoleView
{
    Model model;

    public ConsoleView()
    {
    }

    public void init()
    {
        try
        {
            System.out.println("Application initialized.");
            displayLoginPage();
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            while (true)
            {
                // Reading data using readLine
                String[] content = new String[0];
                content = reader.readLine().split(" ", 2);

                if (Objects.equals(model.pageState, "LOGIN_PAGE"))
                {
                    sortLogin(content[0], content[1]);
                }
                else
                {
                    sort(content[0], content[1]);
                }
            }
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }

    public void sort(String operation, String operand)
    {
    }

    public void sortLogin(String operation, String operand)
    {
    }
    public void displayLoginPage()
    {
        System.out.println("please enter username: ");
    }

    public void disPlayUserProfile(int uid, String name, String description)
    {
        System.out.println("===========Profile===========");
        System.out.println("uid: " + uid);
        System.out.println("name: " + name);
        System.out.println("description: " + description);
    }

}
