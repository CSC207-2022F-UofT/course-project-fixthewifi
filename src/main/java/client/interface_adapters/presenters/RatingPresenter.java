package client.interface_adapters.presenters;

import client.frameworks_and_drivers.view.console_view.ConsoleView;
import client.interface_adapters.model.Model;

public class RatingPresenter {
    private final Model model;
    private final ConsoleView view;
    char SPR = 30;

    public RatingPresenter(Model model, ConsoleView view) {
        this.model = model;
        this.view = view;
    }

    public void receiveConfirmation(String data) {
        String[] content = data.split("#");
        String avgRating = content[0];
        int receiverUid = Integer.parseInt(content[1]);
        model.setRating(avgRating);
        view.displayRatingSuccess();
        view.displayRating(receiverUid);
    }
}
