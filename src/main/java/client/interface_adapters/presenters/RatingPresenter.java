package client.interface_adapters.presenters;

import client.frameworks_and_drivers.view.console_view.ConsoleView;
import client.interface_adapters.model.Model;
import client.interface_adapters.model.ModelInterface;

public class RatingPresenter implements RatingPresenterInputBoundary{
    private final ModelInterface model;
    char SPR = 30;

    public RatingPresenter(ModelInterface model) {
        this.model = model;
    }

    public void receiveConfirmation(String data) {
        String[] content = data.split("#");
        String avgRating = content[0];
        model.setRating(Double.parseDouble(avgRating));

    }
}
