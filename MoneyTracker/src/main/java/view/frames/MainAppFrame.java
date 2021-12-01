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
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainAppFrame extends JFrame implements ActionListener, CaretListener {

    private Container c;
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




    public MainAppFrame(){

        setTitle("MONEY TRACKER APPLICATION");
        setBounds(300, 550, 900, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        c = getContentPane();
        c.setLayout(null);

        title = new JLabel("CHOOSE USER AND CREATE TICKET");
        title.setFont(new Font("Arial", Font.BOLD, 18));
        title.setSize(350, 30);
        title.setLocation(50, 20);
        c.add(title);

        ticketType = new JLabel("Ticket");
        ticketType.setFont(new Font("Arial", Font.PLAIN, 15));
        ticketType.setSize(100, 20);
        ticketType.setLocation(50, 100);
        c.add(ticketType);

//        t_ticketType = new JTextField();
//        t_ticketType.setFont(new Font("Arial", Font.PLAIN, 15));
//        t_ticketType.setSize(200, 20);
//        t_ticketType.setLocation(200, 100);
//        c.add(t_ticketType);

        amount = new JLabel("Amount");
        amount.setFont(new Font("Arial", Font.PLAIN, 15));
        amount.setSize(100, 20);
        amount.setLocation(50, 120);
        c.add(amount);

        tAmnt = new JTextField();
        tAmnt.setFont(new Font("Arial", Font.PLAIN, 15));
        tAmnt.setSize(200, 20);
        tAmnt.setLocation(200, 120);
        c.add(tAmnt);

        split = new JLabel("Split");
        split.setFont(new Font("Arial", Font.PLAIN, 15));
        split.setSize(100, 20);
        split.setLocation(50, 140);
        c.add(split);

        even = new JRadioButton("even");
        even.setFont(new Font("Arial", Font.PLAIN, 15));
        even.setSelected(true);
        even.setSize(75, 20);
        even.setLocation(200, 140);
        even.addActionListener(this);
        c.add(even);

        uneven = new JRadioButton("uneven");
        uneven.setFont(new Font("Arial", Font.PLAIN, 15));
        uneven.setSelected(false);
        uneven.setSize(80, 20);
        uneven.setLocation(275, 140);
        uneven.addActionListener(this);
        c.add(uneven);

        gengp = new ButtonGroup();
        gengp.add(even);
        gengp.add(uneven);


        sub = new JButton("Create ticket");
        sub.setFont(new Font("Arial", Font.PLAIN, 15));
        sub.setSize(150, 20);
        sub.setLocation(50, 300);
        sub.addActionListener(this);
        c.add(sub);

        reset = new JButton("Reset Form");
        reset.setFont(new Font("Arial", Font.PLAIN, 15));
        reset.setSize(150, 20);
        reset.setLocation(250, 300);
        reset.addActionListener(this);
        c.add(reset);

        delUser = new JButton("Remove Ticket");
        delUser.setFont(new Font("Arial",Font.PLAIN,15));
        delUser.setSize(150,20);
        delUser.setLocation(250,330);
        delUser.addActionListener(this);
        c.add(delUser);


        updateUserDB = new JButton("Update Users DB");
        updateUserDB.setFont(new Font("Arial",Font.PLAIN,15));
        updateUserDB.setBackground(Color.red);
        updateUserDB.setSize(150,20);
        updateUserDB.setLocation(50,330);
        updateUserDB.addActionListener(this);
        c.add(updateUserDB);

        userList = new JList(lst);
        userList.setSize(400,300);
        userList.setLocation(450,0);
        c.add(userList);

        ticketList = new JList(tcktlst);
        ticketList.setSize(400,300);
        ticketList.setLocation(450,0);
        c.add(ticketList);

        JScrollPane scrollPane = new JScrollPane(userList);
        scrollPane.setVisible(true);
        scrollPane.setSize(435,180);
        scrollPane.setLocation(450,0);
        c.add(scrollPane);

        JScrollPane scrollPane2 = new JScrollPane(ticketList);
        scrollPane2.setVisible(true);
        scrollPane2.setSize(435,180);
        scrollPane2.setLocation(450,181);
        c.add(scrollPane2);



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
        c.add(ticketTypes);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == sub) {

            //TICKET CREATION

            int selectedUser = userList.getSelectedIndex();
            List<User> allUsers = userController.getAllUsersSortedById();
            Boolean iseven = true;
            Ticket ticket = new Ticket();
            String selectedTicket = ticketTypes.getSelectedItem().toString();
            Double amount = Double.parseDouble(tAmnt.getText());
            HashMap<User,Double> unevenhashmap = new HashMap<User,Double>();
            HashMap<User,Double> unevenhashmapEmpty = new HashMap<User,Double>();

            if(e.getSource() == even){ iseven = true; }
            else if(e.getSource() == uneven){ iseven = false; }

            ticket.setOwner(allUsers.get(selectedUser));
            ticket.setName(ticketTypes.getSelectedItem().toString());
            ticket.setTotalAmount(amount);
            ticket.setSplitEven(iseven);

            if(ticket.getSplitEven()){
                //HASHMAP WITH VALUES
                for(int i=0;i<textFields.size();i++) {
                    unevenhashmap.put(allUsers.get(i),Double.parseDouble(textFields.get(i).getText()));
                    ticket.setUnevenSplitAmount(unevenhashmap);
                }
            }
            else{ ticket.setUnevenSplitAmount(unevenhashmapEmpty); }

            ticketController.addTicket(ticket);
            System.out.println(ticketController.getAllTickets());
        }

        //RESET FORM
        else if (e.getSource() == reset) {
            String def = "";
            //t_ticketType.setText(def);
            tAmnt.setText(def);
        }

        //DELETE TICKET MOET HIER GEBEUREN
        else if(e.getSource() == delUser) {
            lst.clear();
            for(int i=0;i<userController.getAllUsersSortedById().size();i++){
                lst.addElement(userController.getAllUsersSortedById().get(i).getName() + " " + userController.getAllUsersSortedById().get(i).getSurname());
            }

        }

        //WANNEER USER WORDT TOEGEVOEGD KLIK OP DEZE KNOP OM DE USERLIST TE UPDATEN EN NODIGE FIELDS AAN TE MAKEN VOOR UNEVEN SPLIT
        else if(e.getSource() == updateUserDB) {
            Integer ypos = 170;
            lst.clear();
            labels.clear();
            textFields.clear();

            for (int s=0;s<labels.size();s++){
                labels.get(s).setVisible(false);
                labels.get(s).setText("");
                textFields.get(s).setVisible(false);
            }

            for(int i=0;i<userController.getAllUsersSortedById().size();i++){
                 lst.addElement(userController.getAllUsersSortedById().get(i).getName() + " " + userController.getAllUsersSortedById().get(i).getSurname());
                 j = new JTextField();
                 l = new JLabel();
                 l.setLocation(50,ypos);
                 l.setSize(50,20);
                 j.setLocation(200,ypos);
                 j.setSize(50,20);
                 j.setEditable(false);
                 ypos += 30;
                 textFields.add(j);
                 labels.add(l);
                 labels.get(i).setText(userController.getAllUsersSortedById().get(i).getName());
                 c.add(l);
                 c.add(j);
            }
            c.revalidate();
            c.repaint();
        }

        //IF EVEN OR NOT ENABLE DISABLE EDITABLE FIELDS
        else if(e.getSource() == even){
            for (int i =0;i< textFields.size();i++){
                textFields.get(i).setEditable(false);
            }
        }
        else if(e.getSource() == uneven){
            for (int i =0;i< textFields.size();i++){
                textFields.get(i).setEditable(true);
            }
        }

    }

    @Override
    public void caretUpdate(CaretEvent e) {
        System.out.println("UPPP");
    }
}
