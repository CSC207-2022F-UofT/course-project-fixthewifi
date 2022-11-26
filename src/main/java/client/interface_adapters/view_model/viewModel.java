package client.interface_adapters.view_model;

import client.entities.*;
import client.frameworks_and_drivers.view.console_view.ConsoleView;

public class viewModel
{
    private final Self self;
    private final ConsoleView view;

    public viewModel(ConsoleView view)
    {
        this.view = view;
        this.self = new Self();
    }

}

