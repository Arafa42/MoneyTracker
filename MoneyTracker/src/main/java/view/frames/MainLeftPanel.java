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
import model.User;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

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
    DatabaseTickets ticketsDB = TicketsDB.getInstance();
    PersonsDB personsDB = PersonsDB.getInstance();
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
    HashMap<User,Double>  hashmap = new HashMap<User,Double>();
    Integer rowCount = 0;
    JPanel pne = new JPanel();




    public MainLeftPanel(){

        this.setLayout(null);
        this.setBorder(new EmptyBorder(new Insets(0, 0, 0,     0)));
        title = new JLabel("CHOOSE USER AND CREATE TICKET");
        title.setFont(new Font("Arial", Font.BOLD, 18));
        title.setSize(350, 30);
        title.setLocation(10, 20);
        this.add(title);

        ticketType = new JLabel("Ticket");
        ticketType.setFont(new Font("Arial", Font.PLAIN, 15));
        ticketType.setSize(100, 20);
        ticketType.setLocation(10, 100);
        this.add(ticketType);

//        t_ticketType = new JTextField();
//        t_ticketType.setFont(new Font("Arial", Font.PLAIN, 15));
//        t_ticketType.setSize(200, 20);
//        t_ticketType.setLocation(200, 100);
//        c.add(t_ticketType);

        amount = new JLabel("Amount");
        amount.setFont(new Font("Arial", Font.PLAIN, 15));
        amount.setSize(100, 20);
        amount.setLocation(10, 120);
        this.add(amount);

        tAmnt = new JTextField();
        tAmnt.setFont(new Font("Arial", Font.PLAIN, 15));
        tAmnt.setSize(200, 20);
        tAmnt.setLocation(100, 120);
        this.add(tAmnt);

        split = new JLabel("Split");
        split.setFont(new Font("Arial", Font.PLAIN, 15));
        split.setSize(100, 20);
        split.setLocation(10, 140);
        this.add(split);

        even = new JRadioButton("even");
        even.setFont(new Font("Arial", Font.PLAIN, 15));
        even.setSelected(true);
        even.setSize(75, 20);
        even.setLocation(100, 140);
        //even.addActionListener(this);
        this.add(even);

        uneven = new JRadioButton("uneven");
        uneven.setFont(new Font("Arial", Font.PLAIN, 15));
        uneven.setSelected(false);
        uneven.setSize(80, 20);
        uneven.setLocation(175, 140);
        //uneven.addActionListener(this);
        this.add(uneven);

        gengp = new ButtonGroup();
        gengp.add(even);
        gengp.add(uneven);


        JPanel buttonPanel = new JPanel();

        sub = new JButton("Create ticket");
        sub.setFont(new Font("Arial", Font.PLAIN, 15));
        //sub.setSize(150, 20);
        //sub.setLocation(10, 300);

        buttonPanel.add(sub);

        reset = new JButton("Reset Form");
        reset.setFont(new Font("Arial", Font.PLAIN, 15));
        //reset.setSize(150, 20);
        //reset.setLocation(150, 300);

        buttonPanel.add(reset);

        delUser = new JButton("Remove Ticket");
        delUser.setFont(new Font("Arial",Font.PLAIN,15));
        //delUser.setSize(150,20);
        //delUser.setLocation(150,330);

        buttonPanel.add(delUser);



        buttonPanel.setSize(300,50);
        buttonPanel.setLocation(15,290);
        buttonPanel.setLayout(new GridLayout(2,2,10,10));
        this.add(buttonPanel);



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
        ticketTypes.setLocation(100, 100);
        this.add(ticketTypes);


        addTicketActionListener();
        evenButtonActionListener();
        unEvenButtonActionListener();

        setVisible(true);
    }

    public void addTicketActionListener(){
        this.sub.addActionListener(listener -> {

            Double totalAmnt = Double.parseDouble(tAmnt.getText());
            String name = ticketTypes.getSelectedItem().toString();
            User owner = userController.getAllUsersSortedById().get(MainPanel.mainRightPanel.userList.getSelectedIndex());
            Boolean isEven = true;
            Ticket ticket;


            if(even.isSelected()){
                isEven = true;
                ticket = new Ticket(totalAmnt,name,owner,isEven,hashmap);

                // DISABLE ALLE VELDEN

            }
            else{
                isEven = false;
            }


            ticket = new Ticket(totalAmnt,name,owner,isEven,hashmap);
            ticketController.addTicket(ticket);

        });
    }

    public void evenButtonActionListener(){
        this.even.addActionListener(listener ->{
            System.out.println("EVENVEVNEVENVENENV");
        });
    }

    public void unEvenButtonActionListener(){
        this.uneven.addActionListener(listener ->{
            generateFields();
        });
    }

    public void generateFields(){
        labels.clear();
        textFields.clear();
        rowCount++;
        //ROEP functie aan OM VELDEN TE MAKEN
        pne.removeAll();
        pne.setLayout(new GridLayout(userController.getAllUsersSortedById().size(),1,5,5));
        Integer ypos = 170;
        for(int i=0;i<userController.getAllUsersSortedById().size();i++){
            j = new JTextField();
            l = new JLabel();
            ypos += 30;
//            l.setLocation(50,ypos);
//            l.setSize(50,20);
//            j.setLocation(200,ypos);
//            j.setSize(50,20);
            textFields.add(j);
            labels.add(l);
            labels.get(i).setText(userController.getAllUsersSortedById().get(i).getName());
            pne.add(l);
            pne.add(j);
        }
        pne.setSize(200,userController.getAllUsersSortedById().size()*20);
        pne.setLocation(10,170);
        this.add(pne);
        System.out.println(labels.get(0).getText());
        revalidate();
        repaint();
    }


}
