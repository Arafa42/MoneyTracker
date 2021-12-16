package view.frames;

import controller.BillController;
import controller.TicketController;
import controller.UserController;
import database.*;
import factory.FactoryProvider;
import factory.ITicketFactory;
import helper.Calculator;
import model.Ticket;
import model.User;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;


public class MainLeftPanel extends JPanel {
    private JLabel title;
    private JLabel ticketType;
    private JLabel amount;
    private JTextField tAmnt;
    private JLabel split;
    private JRadioButton even;
    private JRadioButton uneven;
    private ButtonGroup gengp;
    private JButton sub;
    private JButton reset;
    private JButton delUser;
    TicketsDB ticketsDB = TicketsDB.getInstance();
    PersonsDB personsDB = PersonsDB.getInstance();
    UserController userController = new UserController(personsDB);
    TicketController ticketController = new TicketController(ticketsDB);
    private ArrayList<JTextField> textFields = new ArrayList<JTextField>();
    private ArrayList<JLabel> labels = new ArrayList<JLabel>();
    private JTextField j;
    private JLabel l;
    private JComboBox ticketTypes;
    private String[] ticketTypesList = new String[2];
    HashMap<User,Double>  hashmap = new HashMap<User,Double>();
    Integer rowCount = 0;
    JPanel pne = new JPanel();
    private JButton lockButton;
    Calculator calculate = new Calculator();


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

        lockButton = new JButton("Add to Bill");
        lockButton.setFont(new Font("Arial",Font.PLAIN,15));
        buttonPanel.add(lockButton);

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
        removeTicketButtonActionListener();
        addToBillButtonActionListener();

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
                isEven = true; ticket = new Ticket(totalAmnt,name,owner,isEven);
            }
            else{
                isEven = false;
                for (int i=0;i<userController.getAllUsersSortedById().size();i++){
                    hashmap.put(userController.getAllUsersSortedById().get(i),Double.parseDouble(textFields.get(i).getText()));
                }
                ticket = new Ticket(totalAmnt,name,owner,isEven,hashmap);
            }
            ticketController.addTicket(ticket);

            System.out.println(ticketController.getAllTickets());
            MainPanel.mainRightPanel.clearTicketList();
            for(int i =0;i<ticketController.getAllTickets().size();i++){
                MainPanel.mainRightPanel.addElementToTicketList(ticketController.getAllTickets().get(i).getOwner().toString());
            }
        });
    }

    public void removeTicketButtonActionListener(){
        this.delUser.addActionListener(listener ->{
            Integer s =  MainPanel.mainRightPanel.ticketList.getSelectedIndex();
            ticketController.deleteTicketById(s);
            System.out.println(ticketController.getAllTicketsSortedById());
            DeleteTicketList(s);
        });
    }


    public void addToBillButtonActionListener(){
        this.lockButton.addActionListener(listener->{
            System.out.println("CALCULATE");
            calculate.BillCalculation();
        });
    }


    public void evenButtonActionListener(){
        this.even.addActionListener(listener ->{
            pne.removeAll();
            revalidate();
            repaint();
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
        pne.removeAll();
        pne.setLayout(new GridLayout(userController.getAllUsersSortedById().size(),1,5,5));
        Integer ypos = 170;
        for(int i=0;i<userController.getAllUsersSortedById().size();i++){
            j = new JTextField();
            l = new JLabel();
            ypos += 30;
            textFields.add(j);
            labels.add(l);
            labels.get(i).setText(userController.getAllUsersSortedById().get(i).getName());
            pne.add(l);
            pne.add(j);
        }
        pne.setSize(200,userController.getAllUsersSortedById().size()*20);
        pne.setLocation(10,170);
        this.add(pne);
        revalidate();
        repaint();
    }

    public void DeleteTicketList(Integer index){
        MainPanel.mainRightPanel.removeElementFromTicketList(index);
    }

}
