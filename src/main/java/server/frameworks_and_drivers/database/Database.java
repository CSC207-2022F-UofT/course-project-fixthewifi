package server.frameworks_and_drivers.database;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Database
{
    private static int userUid = 0;
    private static int chatUid = 0;
    private static HashMap<Integer, Integer> msgUid;
    public Database()
    {
    }

    public void newUser(int uid, String name, String description, String ip, String password)
    {
        try {
            CSVWriter userWriter = new CSVWriter(new FileWriter("User.csv", true));
//            String str = friends.stream().map(Object::toString).collect(Collectors.joining("-"));
            String[] content = {Integer.toString(uid), name, description,"","","","", ip, password};
            userWriter.writeNext(content);
            userWriter.flush();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateUser(int Uid, int parameter, String newContent)
    {
        List<String[]> csvBody;
        try
        {
            CSVReader userReader = new CSVReader(new FileReader("User.csv"));
            csvBody = userReader.readAll();
            csvBody.get(Uid)[parameter] = newContent;

            CSVWriter userWriter = new CSVWriter(new FileWriter("User.csv", false));
            userWriter.writeAll(csvBody);
            userWriter.flush();
        } catch (IOException | CsvException e)
        {
            throw new RuntimeException(e);
        }
    }

    public String readUser(int Uid, int parameter)
    {
        List<String[]> csvBody;
        try
        {
            CSVReader userReader = new CSVReader(new FileReader("User.csv"));
            csvBody = userReader.readAll();
            return csvBody.get(Uid)[parameter];
        } catch (IOException | CsvException e)
        {
            throw new RuntimeException(e);
        }
    }

    public static int returnNewUserUid()
    {
        int oldValue = userUid;
        userUid += 1;
        return oldValue;
    }

    public static int returnNewChatUid()
    {
        int oldValue = chatUid;
        msgUid.put(oldValue, 0);
        chatUid += 1;
        return oldValue;
    }

    public static int returnNewMsgUid(int chatUid)
    {
        int oldValue = msgUid.get(chatUid);
        msgUid.put(chatUid, oldValue+1);
        return oldValue;

    }

//    public static void main(String[] args)
//    {
//        Database base = new Database();
//        ArrayList<Integer> arl = new ArrayList<Integer>();
//        arl.add(1);
//        arl.add(2);
//        arl.add(3);
//        base.newUser(Database.returnNewUserUid(), "kevin", "a guy", arl);
//        base.updateUser(0, 1, "dick");
//    }
}
