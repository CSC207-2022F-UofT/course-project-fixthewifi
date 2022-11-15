package test_usecases.create_gc;

import entities.GroupChat;

import usecases.create_gc.CreateGCOutputBoundary;
import usecases.create_gc.CreateGCOutputData;

/**
 * This is a dummy implementation of CreateGCOutputBoundary for testing CreateGCInteractor
 * independent of InterfaceAdapters layer.
 * @author Brenden McFarlane
 */
public class CreateGCDummyOutputAdapter implements CreateGCOutputBoundary {
    private CreateGCOutputData output;

    @Override
    public void prepareSuccessView(CreateGCOutputData output_data) {
        this.output = output_data;
    }
    public CreateGCOutputData getOutput(){return this.output;}
}
