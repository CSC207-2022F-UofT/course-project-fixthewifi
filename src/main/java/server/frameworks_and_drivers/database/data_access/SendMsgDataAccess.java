package server.frameworks_and_drivers.database.data_access;

import server.frameworks_and_drivers.database.Database;
import server.usecases.edit_message.EditDSGateway;
import server.usecases.edit_message.EditInputBoundary;
import server.usecases.send_message.SendMsgDsGateway;

import java.util.ArrayList;
import java.util.List;

public class SendMsgDataAccess implements SendMsgDsGateway, EditDSGateway
{
    private final Database database;

    public SendMsgDataAccess(Database database)
    {
        this.database = database;
    }
    @Override
    public void storeChatMsg(int chatUid, int senderUid, String content, String time)
    {
        database.updateChatMsg(chatUid, senderUid, content, time);
    }

    @Override
    public int generateMsgUid(int chatUid) {
        return database.returnNewMsgUid(chatUid);
    }

    @Override
    public List<Integer> getAllMemberUid(int chatUid) {
        List<Integer> toReturn = new ArrayList<>();
        for (String memberUid : database.readChat(chatUid)[5].split("-"))
        {
            toReturn.add(Integer.parseInt(memberUid));
        }
        return toReturn;
    }

    @Override
    public String getAddress(Integer memberUid) {
        return database.readUser(memberUid)[7];
    }

    @Override
    public int getPort(Integer membersUid) {
        return Integer.parseInt(database.readUser(membersUid)[10]);
    }

    @Override
    public String getName(int senderUid) {
        return database.readUser(senderUid)[1];
    }

    @Override
    public void editMessage(int chatUid, int msgUid, String newContent) {
        String[] msg = database.readChat(chatUid)[6+msgUid].split("-");
        msg[2] = newContent;
        String toDB = String.join("-", msg);
        database.updateChat(chatUid, 6+msgUid, toDB);
    }
}
