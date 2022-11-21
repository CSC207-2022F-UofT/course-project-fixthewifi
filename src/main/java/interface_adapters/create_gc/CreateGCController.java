package interface_adapters.create_gc;

import usecases.create_gc.CreateGCInputBoundary;
import usecases.create_gc.CreateGCInputData;

import java.util.ArrayList;

public class CreateGCController {
    private final CreateGCInputBoundary interactor;

    public CreateGCController(CreateGCInputBoundary interactor){
        this.interactor =  interactor;
    }

    public void execute(String input){
        int admin = Integer.parseInt(input.substring(0,6));
        ArrayList<Integer> members= new ArrayList<>();
        int index = 6;
        while(index < input.length()){
            members.add(Integer.parseInt(input.substring(index, index + 6)));
            index += 6;
        }


    }
}
