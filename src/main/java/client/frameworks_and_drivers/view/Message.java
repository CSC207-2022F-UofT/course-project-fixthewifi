package client.frameworks_and_drivers.view;

import javax.swing.*;

public class Message extends JFrame{
    private JTextPane text;
    private JLabel lab;
    private JPanel panel;

    public Message()
    {
        setTitle("haha");
        setSize(450, 300);
        setVisible(true);
        setContentPane(panel);
    }

    public static void main(String[] args)
    {
        Message myFrame = new Message();
    }
}
