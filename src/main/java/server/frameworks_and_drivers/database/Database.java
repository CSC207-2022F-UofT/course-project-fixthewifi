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
            List<String[]> userData = userReader.readAll();
            newUserUid = userData.size();

            List<String[]> chatData = chatReader.readAll();
            for (String[] row : chatData)
            {
                msgUid.put(newChatUid, row.length - CHAT_LIST_NON_MSG_CELLS_LENGTH);
                newChatUid = newChatUid + 1;
            }
        } catch (IOException | CsvException e)
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
            userWriter.writeNext(content);
            userWriter.flush();

        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }

    public void updateUser(int Uid, int parameter, String newContent)
    {
        updateHelper(Uid, parameter, newContent, userReader, userWriter);
    }

    public void updateChat(int Uid, int parameter, String newContent)
    {
        updateHelper(Uid, parameter, newContent, chatReader, chatWriter);
    }


    private void updateHelper(int Uid, int parameter, String newContent, CSVReader userReader, CSVWriter userWriter) {
        List<String[]> csvBody;
        try
        {
            csvBody = userReader.readAll();
            csvBody.get(Uid)[parameter] = newContent;

            userWriter.writeAll(csvBody);
            userWriter.flush();
        } catch (IOException | CsvException e)
        {
            throw new RuntimeException(e);
        }
    }

    public String readUser(int Uid, int whichCell) {
        List<String[]> csvBody;
        try {
            csvBody = userReader.readAll();
            return csvBody.get(Uid)[whichCell];
        } catch (IOException | CsvException e) {
            throw new RuntimeException(e);
        }
    }

    public String readChat(int Uid, int whichCell) {
        List<String[]> csvBody;
        try {
            csvBody = chatReader.readAll();
            return csvBody.get(Uid)[whichCell];
        } catch (IOException | CsvException e) {
            throw new RuntimeException(e);
        }
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
