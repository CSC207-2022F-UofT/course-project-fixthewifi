package client.usecases.create_gc;

import server.usecases.create_gc.CreateGCInputData;

/**
 * InputBoundary that CreateGCInteractor implements.
 */
public interface CreateGCInputBoundary {
    /**
     * Creates a new GroupChat using the data provided in input_data,
     * adds that to the database.
     * @param input_data contains List<User> of those to be added as members of the GroupChat.
     */
    void create(CreateGCInputData input_data);
}
