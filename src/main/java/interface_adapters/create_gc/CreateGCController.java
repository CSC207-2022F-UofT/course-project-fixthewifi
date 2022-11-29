package interface_adapters.create_gc;

import usecases.create_gc.CreateGCInputBoundary;
import usecases.create_gc.CreateGCInputData;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Objects;

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
     * the next the time in format "yyyy-MM-ddThh:mm", followed by the UID of all users who will also be added to
     * the GroupChat.
     * there are at least 2 users also being added to the new GroupChat.
     */
    public void execute(String input){
        ArrayList<Object> parsed_input = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        while (input.length()>0){
            int i = input.indexOf(CONTENT_SPR);
            parsed_input.add(input.substring(0, i));
            input = input.substring(i + 1);
        }
        int admin = Integer.parseInt((String) parsed_input.remove(0));
        LocalDateTime time = LocalDateTime.parse((String)parsed_input.remove(0), formatter);
        ArrayList<Integer> UIDs = new ArrayList<>();
        for(Object s: parsed_input){UIDs.add(Integer.parseInt((String) s));}
        CreateGCInputData input_data = new CreateGCInputData(admin, UIDs, time);
        interactor.create(input_data);

    }
}
