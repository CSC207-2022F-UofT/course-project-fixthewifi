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
    private int newUserUid = 0;
    private int newChatUid = 0;
    private HashMap<Integer, Integer> msgUid;

    private final int CHAT_LIST_NON_MSG_CELLS_LENGTH = 6;

    private final int MAX_UPDATE = 1;

    private int chatUpdateCount = 0;

    private int userUpdateCount = 0;


    private final List<String[]> chatDatabase;
    private final List<String[]> userDatabase;

    private final String userURL;
    private final String chatURL;
    public Database(String userURL, String chatURL)
    {
        try
        {
            msgUid = new HashMap<>();
            this.userURL = userURL;
            this.chatURL = chatURL;
            // Initialize all readers
            this.userReader = new CSVReader(new FileReader(userURL));
            this.chatReader = new CSVReader(new FileReader(chatURL));

            // Initialize all writers
            this.userWriter = new CSVWriter(new FileWriter(userURL, true));
            this.chatWriter = new CSVWriter(new FileWriter(chatURL, true));

            List<String[]> userDatabase = new ArrayList<>(userReader.readAll());

            List<String[]> chatDatabase = new ArrayList<>(chatReader.readAll());
            this.chatDatabase = chatDatabase;

            // Save the correct value to uid variables
            newUserUid = userDatabase.size();
            this.userDatabase = userDatabase;
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

    /**
     * Creates a new user with the minimum necessary information.
     */
    public void newUser(int userUid, String name, String description, String ip, String password, int port)
    {
        String[] content = {Integer.toString(userUid), name, description, "0-0-0", "T", "", "", ip, password, "", String.valueOf(port), ""};
        userDatabase.add(content);
        userWriter.writeNext(content);
        try
        {
            userWriter.flush();
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
        //debug
//        for (String[] cot : userDatabase)
//        {
//            System.out.println(Arrays.toString(cot));
//        }
    }

    /**
     * Updates an existing user.
     * @param uid chatuid
     * @param newContent the new content
     */
    public void updateUser(int uid, String[] newContent)
    {
        userUpdateHelper(uid, newContent);
    }

    /**
     * Updates an existing user.
     * @param uid chatuid
     * @param whichCell the cell that you wish to change, 0 = first cell
     * @param newContent the new content
     */
    public void updateUser(int uid, int whichCell, String newContent)
    {
        String[] content = readUser(uid);
        content[whichCell] = newContent;
        userUpdateHelper(uid, content);
    }

    private void userUpdateHelper(int userUid, String[] content)
    {
        String[] toUpdate = userDatabase.get(userUid);
        System.arraycopy(content, 0, toUpdate, 0, toUpdate.length);

        userUpdateCount += 1;
        if (userUpdateCount == MAX_UPDATE)
        {
            // clear the file
            try
            {
                new FileWriter(userURL, false).close();
                userWriter.writeAll(userDatabase);
                userWriter.flush();
                userUpdateCount = 0;
            }
            catch (IOException e)
            {
                throw new RuntimeException(e);
            }
        }
        // debug
//        for (String[] cot : userDatabase)
//        {
//            System.out.println(Arrays.toString(cot));
//        }
    }

    /**
     * Creates a new chat with the minimum necessary information.
     */
    public void newChat(int chatUid, String name, String description, int adminUid, int[] memberUid)
    {
        String strArr = String.join("-", Arrays.stream(memberUid).mapToObj(String::valueOf).toArray(String[]::new));
        String[] content = {Integer.toString(chatUid), name, description, "", String.valueOf(adminUid), strArr, ""};
        chatDatabase.add(chatUid, content);
        chatWriter.writeNext(content);
        try {
            chatWriter.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Updates an existing chat.
     * @param uid chatuid
     * @param newContent the new content
     */
    public void updateChat(int uid, String[] newContent)
    {
        chatUpdateHelper(uid, newContent);
    }

    /**
     * Updates an existing chat.
     * @param uid chatuid
     * @param whichCell the cell that you wish to change, 0 = first cell
     * @param newContent the new content
     */
    public void updateChat(int uid, int whichCell, String newContent)
    {
        String[] content = readChat(uid);
        content[whichCell] = newContent;
        chatUpdateHelper(uid, content);
    }

    public void updateChatMsg(int uid, int senderUid, String content, String time)
    {
        String[] oldContent = chatDatabase.get(uid);
        String msg = senderUid + "-" + time + "-" + content;
        String[] newContent = new String[oldContent.length];
        System.arraycopy(oldContent, 0, newContent, 0, oldContent.length);
        newContent[oldContent.length - 1] = msg;
        chatDatabase.remove(uid);
        chatDatabase.add(uid, newContent);

        writeToChatHelper();
    }

    private void writeToChatHelper() {
        chatUpdateCount += 1;
        if (chatUpdateCount == MAX_UPDATE)
        {
            // clear the file
            try {
                new FileWriter(chatURL, false).close();
                chatWriter.writeAll(chatDatabase);
                chatWriter.flush();
                chatUpdateCount = 0;
            }
            catch (IOException e)
            {
                throw new RuntimeException(e);
            }
        }
    }

    /**
     *
     * @param chatUid the uid of the that you wish to update, the user must exist in the database
     * @param content the new content
     */
    private void chatUpdateHelper(int chatUid, String[] content)
    {
        String[] toUpdate = chatDatabase.get(chatUid);
        System.arraycopy(content, 0, toUpdate, 0, toUpdate.length);

        writeToChatHelper();
    }

    /**
     *
     * @return returns the information of the user, in string array
     */

    public String[] readUser(int uid)
    {
        return userDatabase.get(uid).clone();
    }

    /**
     *
     * @return returns the information of the chat, in string array
     */
    public String[] readChat(int uid)
    {
        return chatDatabase.get(uid).clone();
    }


    public boolean checkUserExist(int UserUid)
    {
        return UserUid < newUserUid;
    }

    public boolean checkChatExist(int ChatUid)
    {
        return ChatUid < newChatUid;
    }

    /**
     *
     * @return a new user unique id that is 1 more than the current exiting maximum user Uid.
     */
    public int returnNewUserUid() {
        int oldValue = newUserUid;
        newUserUid += 1;
        return oldValue;
    }

    /**
     *
     * @return a new chat unique id that is 1 more than the current exiting maximum chat Uid.
     */
    public int returnNewChatUid() {
        int oldValue = newChatUid;
        msgUid.put(oldValue, 0);
        newChatUid += 1;
        return oldValue;
    }

    /**
     *
     * @return a new message unique id that is 1 more than the current exiting maximum chat Uid for the specified chat.
     */
    public int returnNewMsgUid(int chatUid) {
        int oldValue = msgUid.get(chatUid);
        msgUid.put(chatUid, oldValue + 1);
        return oldValue;
    }
}
