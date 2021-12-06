package view.frames;

import controller.TicketController;
import controller.UserController;
import database.DatabasePersons;
import database.DatabaseTickets;
import database.PersonsDB;
import database.TicketsDB;
import factory.FactoryProvider;
import factory.ITicketFactory;
import model.Ticket;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MainPanel extends JPanel    implements ActionListener {

    JButton createUser;
    public static MainRightPanel mainRightPanel;
    private MainLeftPanel mainLeftPanel;


    public MainPanel(){
        mainRightPanel = new MainRightPanel();
        mainLeftPanel = new MainLeftPanel();
        this.add(mainLeftPanel);
        this.add(mainRightPanel);
        this.setLayout(new GridLayout(1,1));
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
