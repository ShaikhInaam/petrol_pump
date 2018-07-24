package app;

import gui.MainFrame;
import operations.DatabaseOperations;

public class Main {

    public static void main(String arg[])
    {
        DatabaseOperations.setup();
        new MainFrame().setVisible(true);
    }
}
