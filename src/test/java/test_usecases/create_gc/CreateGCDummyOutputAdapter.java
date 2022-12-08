package test_usecases.create_gc;

import server.usecases.create_gc.CreateGCOutputBoundary;
import server.usecases.create_gc.CreateGCOutputData;

/**
 * This is an implementation of CreateGCOutputBoundary for testing CreateGCInteractor
 * independent of InterfaceAdapters layer.
 * @author Brenden McFarlane
 */
public class CreateGCDummyOutputAdapter implements CreateGCOutputBoundary {
    private CreateGCOutputData output;
    /**
     * number of calls on create() by interactor
     */
    int calls;
    public CreateGCDummyOutputAdapter(){
        this.calls = 0;
    }


    @Override
    public void prepareSuccessView(CreateGCOutputData output_data) {
        this.output = output_data;
        this.calls++;
    }
    public CreateGCOutputData getOutput(){return this.output;}
}
