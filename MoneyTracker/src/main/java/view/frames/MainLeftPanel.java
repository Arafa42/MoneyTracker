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
import java.util.ArrayList;

public class MainLeftPanel extends JPanel {
    private JLabel title;
    private JLabel ticketType;
    private JLabel amount;
    private JTextField t_ticketType;
    private JTextField tAmnt;
    private JLabel split;
    private JRadioButton even;
    private JRadioButton uneven;
    private ButtonGroup gengp;
    private JButton sub;
    private JButton reset;
    private JButton delUser;
    private JButton updateUserDB;
    DatabasePersons personsDB = PersonsDB.getInstance();
    DatabaseTickets ticketsDB = TicketsDB.getInstance();
    UserController userController = new UserController(personsDB);
    TicketController ticketController = new TicketController(ticketsDB);
    private ArrayList<JTextField> textFields = new ArrayList<JTextField>();
    private ArrayList<JLabel> labels = new ArrayList<JLabel>();
    private DefaultListModel<String> lst = new DefaultListModel<>();
    private DefaultListModel<String> tcktlst = new DefaultListModel<>();
    private JList userList;
    private JList ticketList;
    private JTextField j;
    private JLabel l;
    private JComboBox ticketTypes;
    private String[] ticketTypesList = new String[2];

    public MainLeftPanel(){
        this.setLayout(null);

        title = new JLabel("CHOOSE USER AND CREATE TICKET");
        title.setFont(new Font("Arial", Font.BOLD, 18));
        title.setSize(350, 30);
        title.setLocation(50, 20);
        this.add(title);

        ticketType = new JLabel("Ticket");
        ticketType.setFont(new Font("Arial", Font.PLAIN, 15));
        ticketType.setSize(100, 20);
        ticketType.setLocation(50, 100);
        this.add(ticketType);

//        t_ticketType = new JTextField();
//        t_ticketType.setFont(new Font("Arial", Font.PLAIN, 15));
//        t_ticketType.setSize(200, 20);
//        t_ticketType.setLocation(200, 100);
//        c.add(t_ticketType);

        amount = new JLabel("Amount");
        amount.setFont(new Font("Arial", Font.PLAIN, 15));
        amount.setSize(100, 20);
        amount.setLocation(50, 120);
        this.add(amount);

        tAmnt = new JTextField();
        tAmnt.setFont(new Font("Arial", Font.PLAIN, 15));
        tAmnt.setSize(200, 20);
        tAmnt.setLocation(200, 120);
        this.add(tAmnt);

        split = new JLabel("Split");
        split.setFont(new Font("Arial", Font.PLAIN, 15));
        split.setSize(100, 20);
        split.setLocation(50, 140);
        this.add(split);

        even = new JRadioButton("even");
        even.setFont(new Font("Arial", Font.PLAIN, 15));
        even.setSelected(true);
        even.setSize(75, 20);
        even.setLocation(200, 140);
        //even.addActionListener(this);
        this.add(even);

        uneven = new JRadioButton("uneven");
        uneven.setFont(new Font("Arial", Font.PLAIN, 15));
        uneven.setSelected(false);
        uneven.setSize(80, 20);
        uneven.setLocation(275, 140);
        //uneven.addActionListener(this);
        this.add(uneven);

        gengp = new ButtonGroup();
        gengp.add(even);
        gengp.add(uneven);


        sub = new JButton("Create ticket");
        sub.setFont(new Font("Arial", Font.PLAIN, 15));
        sub.setSize(150, 20);
        sub.setLocation(50, 300);

        this.add(sub);

        reset = new JButton("Reset Form");
        reset.setFont(new Font("Arial", Font.PLAIN, 15));
        reset.setSize(150, 20);
        reset.setLocation(250, 300);

        this.add(reset);

        delUser = new JButton("Remove Ticket");
        delUser.setFont(new Font("Arial",Font.PLAIN,15));
        delUser.setSize(150,20);
        delUser.setLocation(250,330);

        this.add(delUser);


        updateUserDB = new JButton("Update Users DB");
        updateUserDB.setFont(new Font("Arial",Font.PLAIN,15));
        updateUserDB.setBackground(Color.red);
        updateUserDB.setSize(150,20);
        updateUserDB.setLocation(50,330);

        this.add(updateUserDB);





        ITicketFactory factory = FactoryProvider.getCinemaTicketFactory();
        Ticket cinemaTicket = factory.getTicket("cinema");
        System.out.println(cinemaTicket);
        ticketTypesList[0] = (cinemaTicket.getName().toString());
        factory = FactoryProvider.getRestaurantTicketFactory();
        Ticket restoTick = factory.getTicket("resto");
        ticketTypesList[1] = (restoTick.getName());


        ticketTypes = new JComboBox(ticketTypesList);
        ticketTypes.setFont(new Font("Arial", Font.PLAIN, 15));
        ticketTypes.setSize(200, 20);
        ticketTypes.setLocation(200, 100);
        this.add(ticketTypes);

        setVisible(true);
    }

}
