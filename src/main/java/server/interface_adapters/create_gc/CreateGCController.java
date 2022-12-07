package server.interface_adapters.create_gc;

import server.usecases.create_gc.CreateGCInputBoundary;
import server.usecases.create_gc.CreateGCInputData;

import java.util.ArrayList;


public class CreateGCController {
    char CONTENT_SPR = 30;
    private final CreateGCInputBoundary interactor;

    public CreateGCController(CreateGCInputBoundary interactor){
        this.interactor =  interactor;
    }

    /**
     *
     * @param input
     * preconditions:
     * input has char CONTENT_SPR that separates the code. the first segment contains the UID of User creating the GroupChat,
     * followed by the UID of all users who will also be added to
     * the GroupChat.
     * there are at least 2 users also being added to the new GroupChat.
     */
    public void execute(String input){
        ArrayList<Object> parsed_input = new ArrayList<>();
        while (input.length()>0){
            int i = input.indexOf(CONTENT_SPR);
            parsed_input.add(input.substring(0, i));
            input = input.substring(i + 1);
        }
        int admin = Integer.parseInt((String) parsed_input.remove(0));
        ArrayList<Integer> UIDs = new ArrayList<>();
        for(Object s: parsed_input){UIDs.add(Integer.parseInt((String) s));}
        CreateGCInputData input_data = new CreateGCInputData(admin, UIDs);
        interactor.create(input_data);

    }
}
