package server.frameworks_and_drivers.database;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Database {
    private final CSVReader userReader;
    private final CSVWriter userWriter;
    private final CSVWriter chatWriter;
    private final CSVReader chatReader;
    private static int newUserUid = 0;
    private static int newChatUid = 0;
    private static HashMap<Integer, Integer> msgUid;

    private final int CHAT_LIST_NON_MSG_CELLS_LENGTH = 6;

    private final int MAX_UPDATE = 1;

    private int chatUpdateCount = 0;

    private int userUpdateCount = 0;


    private final List<String[]> chatDatabase;
    private final List<String[]> userDatabase;

    public Database()
    {
        try
        {
            // Initialize all readers and writers
            this.userReader = new CSVReader(new FileReader("User.csv"));
            this.userWriter = new CSVWriter(new FileWriter("User.csv", true));

            this.chatReader = new CSVReader(new FileReader("Chat.csv"));
            this.chatWriter = new CSVWriter(new FileWriter("Chat.csv", true));

            // Save the correct value to uid variables
            List<String[]> userDatabase = userReader.readAll();
            this.userDatabase = userDatabase;
            newUserUid = userDatabase.size();

            List<String[]> chatDatabase = chatReader.readAll();
            this.chatDatabase = chatDatabase;
            for (String[] row : chatDatabase)
            {
                msgUid.put(newChatUid, row.length - CHAT_LIST_NON_MSG_CELLS_LENGTH);
                newChatUid = newChatUid + 1;
            }
        }
        catch (IOException | CsvException e)
        {
            throw new RuntimeException(e);
        }

    }

    public void newUser(int userUid, String name, String description, String ip, String password)
    {
        try
        {
            String[] content = {Integer.toString(userUid), name, description, "N/A", "T", "", "", ip, password};
            userWriter.writeNext(content);
            userWriter.flush();

        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }

    public void newChat(int chatUid, String name, String description, int adminUid, int[] memberUid)
    {
        try
        {
            String strArr = String.join("-", Arrays.stream(memberUid).mapToObj(String::valueOf).toArray(String[]::new));
            String[] content = {Integer.toString(chatUid), name, description, "", String.valueOf(adminUid), strArr, ""};
            chatWriter.writeNext(content);
            chatWriter.flush();

        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }

    public void updateUser(int uid, String[] newContent)
    {
        userDatabase.remove(uid);
        userDatabase.add(uid, newContent);
        userUpdateCount += 1;

        if (userUpdateCount == MAX_UPDATE)
        {
            userWriter.writeAll(userDatabase);
            try
            {
                userWriter.flush();
            }
            catch (IOException e)
            {
                throw new RuntimeException(e);
            }
            userUpdateCount = 0;
        }
    }

    public void updateChat(int uid, String[] newContent)
    {
        chatDatabase.remove(uid);
        chatDatabase.add(uid, newContent);
        chatUpdateCount += 1;

        if (chatUpdateCount == MAX_UPDATE)
        {
            chatWriter.writeAll(chatDatabase);
            try
            {
                chatWriter.flush();
            }
            catch (IOException e)
            {
                throw new RuntimeException(e);
            }
            chatUpdateCount = 0;
        }
    }



    public String[] readUser(int uid)
    {
        return userDatabase.get(uid);
    }

    public String[] readChat(int uid)
    {
        return chatDatabase.get(uid);
    }

    public static int returnNewUserUid() {
        int oldValue = newUserUid;
        newUserUid += 1;
        return oldValue;
    }

    public static int returnNewChatUid() {
        int oldValue = newChatUid;
        msgUid.put(oldValue, 0);
        newChatUid += 1;
        return oldValue;
    }

    public static int returnNewMsgUid(int chatUid) {
        int oldValue = msgUid.get(chatUid);
        msgUid.put(chatUid, oldValue + 1);
        return oldValue;

    }
}
