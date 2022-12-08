package server.interface_adapters.edit_delete_msg;

import server.usecases.edit_message.EditInputBoundary;
import server.usecases.send_message.SendMsgInputBoundary;
import server.usecases.send_message.SendMsgInputModel;

public class EditMsgController
{
    char CONTENT_SPR = 30;
    final EditInputBoundary useCase;

    public EditMsgController(EditInputBoundary useCase)
    {
        this.useCase = useCase;
    }

    public void editMsg(String msg)
    {
        String[] content = msg.split(String.valueOf(CONTENT_SPR));
        useCase.editMessage(Integer.parseInt(content[0]), Integer.parseInt(content[1]), Integer.parseInt(content[2]), Integer.parseInt(content[3]), content[4]);
    }
}
