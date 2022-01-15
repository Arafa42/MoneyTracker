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
    static JTabbedPane tabbedPane = new JTabbedPane();


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

        tabbedPane.add("create users",registrationPanel);
        tabbedPane.add("Money Tracker",mainPanel);
        tabbedPane.add("Bill",checkOutPanel);
        this.add(tabbedPane);
        this.setVisible(true);
    }

    public static void disableTab(int index){
        tabbedPane.setEnabledAt(index,false);
    }

    public static void switchFromTab(int index){
        tabbedPane.setSelectedIndex(index);
    }

    public void switchPanels(){
        this.removeAll();
    }
}