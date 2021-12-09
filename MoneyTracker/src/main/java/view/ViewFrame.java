package view;

import view.frames.CheckOutPanel;
import view.frames.MainPanel;
import view.frames.RegistrationPanel;

import javax.swing.*;
import java.awt.*;

public class ViewFrame extends JFrame {

    private MainPanel mainPanel;
    protected RegistrationPanel registrationPanel;
    private CheckOutPanel checkOutPanel;

    public ViewFrame(){super("MoneyTracker");}

    public void initialize()
    {
        this.setSize(1000, 420);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mainPanel = new MainPanel();
        registrationPanel = new RegistrationPanel();
        checkOutPanel = new CheckOutPanel();

        GridLayout layout = new GridLayout();
        this.setLayout(layout);

        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.add("create users",registrationPanel);
        tabbedPane.add("Money Tracker",mainPanel);
        tabbedPane.add("Bill",checkOutPanel);

        this.add(tabbedPane);
        this.setVisible(true);
    }
    public void switchPanels(){
        this.removeAll();
    }
}