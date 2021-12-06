package view;



import view.frames.MainPanel;
import view.frames.RegistrationPanel;

import javax.swing.*;
import java.awt.*;

public class ViewFrame extends JFrame {

    private MainPanel mainPanel;
    private RegistrationPanel registrationPanel;


    public ViewFrame(){super("MoneyTracker");}

    public void initialize()
    {
        this.setSize(800    , 420);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mainPanel = new MainPanel();
        registrationPanel = new RegistrationPanel();

        GridLayout layout = new GridLayout();
        this.setLayout(layout);

        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.add("create users",registrationPanel);
        tabbedPane.add("Money Tracker",mainPanel);

        this.add(tabbedPane);
        this.setVisible(true);
    }
    public void switchPanels(){
        this.removeAll();
    }
}