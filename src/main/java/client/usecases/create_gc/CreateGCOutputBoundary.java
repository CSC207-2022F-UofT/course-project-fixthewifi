package client.usecases.create_gc;

import server.usecases.create_gc.CreateGCOutputData;

/**
 * The OutputBoundary interface that CreateGCInteractor will
 */
public interface CreateGCOutputBoundary {

    void prepareSuccessView(CreateGCOutputData output_data);

}
