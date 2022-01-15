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
import view.ViewFrame;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
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
    private String[] ticketTypesList = new String[5];
    Integer rowCount = 0;
    JPanel pne = new JPanel();
    private JButton lockButton;
    Calculator calculate = new Calculator();
    Integer selected = -1;
    boolean hasText = false;
    private BillsDB billsDB = BillsDB.getInstance();
    private BillController billController = new BillController(billsDB);

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
        this.add(even);

        uneven = new JRadioButton("uneven");
        uneven.setFont(new Font("Arial", Font.PLAIN, 15));
        uneven.setSelected(false);
        uneven.setSize(80, 20);
        uneven.setLocation(175, 140);
        this.add(uneven);

        gengp = new ButtonGroup();
        gengp.add(even);
        gengp.add(uneven);

        JPanel buttonPanel = new JPanel();

        sub = new JButton("Create ticket");
        sub.setFont(new Font("Arial", Font.PLAIN, 15));
        sub.setEnabled(false);
        buttonPanel.add(sub);

        reset = new JButton("Reset Form");
        reset.setFont(new Font("Arial", Font.PLAIN, 15));
        buttonPanel.add(reset);

        delUser = new JButton("Remove Ticket");
        delUser.setFont(new Font("Arial",Font.PLAIN,15));
        buttonPanel.add(delUser);

        lockButton = new JButton("Calculate");
        lockButton.setFont(new Font("Arial",Font.PLAIN,15));
        buttonPanel.add(lockButton);

        buttonPanel.setSize(300,50);
        buttonPanel.setLocation(15,290);
        buttonPanel.setLayout(new GridLayout(2,2,10,10));
        this.add(buttonPanel);

        ITicketFactory factory = FactoryProvider.getCinemaTicketFactory();
        Ticket cinemaTicket = factory.getTicket("cinema");
        ticketTypesList[0] = (cinemaTicket.getName().toString());
        factory = FactoryProvider.getRestaurantTicketFactory();
        Ticket restoTick = factory.getTicket("resto");
        ticketTypesList[1] = (restoTick.getName());
        factory = FactoryProvider.getFlightTicketFactory();
        Ticket flightTick = factory.getTicket("flight");
        ticketTypesList[2] = (flightTick.getName());
        factory = FactoryProvider.getConcertTicketFactory();
        Ticket concTick = factory.getTicket("concert");
        ticketTypesList[3] = (concTick.getName());
        factory = FactoryProvider.getOtherTicketFactory();
        Ticket otherTick = factory.getTicket("other");
        ticketTypesList[4] = (otherTick.getName());

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
        resetBtnActionListener();

        setVisible(true);

        MainPanel.mainRightPanel.userList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                selected = MainPanel.mainRightPanel.userList.getSelectedIndex();
            }
        });


        tAmnt.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) { changed(); }
            @Override
            public void removeUpdate(DocumentEvent e) { changed(); }
            @Override
            public void changedUpdate(DocumentEvent e) { changed(); }
            public void changed(){
                if(tAmnt.getText().equals("")){
                    sub.setEnabled(false);
                    hasText = false;
                }
                else{
                    hasText = true;
                    if(selected >= 0 && hasText) {
                        sub.setEnabled(true);
                    }
                }
            }
        });


        tAmnt.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if(!(Character.isDigit(c) || (c==KeyEvent.VK_BACK_SPACE) || (c==KeyEvent.VK_DELETE ) || (c==KeyEvent.VK_PERIOD))) {
                    e.consume();  // ignore the event if it's not an alphabet
                }
            }
        });
    }


    public void addTicketActionListener(){
        this.sub.addActionListener(listener -> {

            Double totalAmnt = Double.parseDouble(tAmnt.getText());
            String name = ticketTypes.getSelectedItem().toString();
            User owner = userController.getAllUsersSortedById().get(MainPanel.mainRightPanel.userList.getSelectedIndex());
            boolean isEven = true;
            HashMap<User,Double>  hashmap = new HashMap<User,Double>();
            Ticket ticket = null;

            if(even.isSelected()){
                isEven = true; ticket = new Ticket(totalAmnt,name,owner,isEven);
                ticketController.addTicket(ticket);
                ViewFrame.disableTab(0);
            }
            else{

                Double sum = 0.0;

                for (JTextField textField : textFields) { sum += Double.parseDouble(textField.getText()); }

                if(sum.equals(totalAmnt)) {
                    isEven = false;
                    for (int i = 0; i < userController.getAllUsersSortedById().size(); i++) {
                        hashmap.put(userController.getAllUsersSortedById().get(i), Double.parseDouble(textFields.get(i).getText()));
                    }
                    ticket = new Ticket(totalAmnt, name, owner, isEven, hashmap);
                    ticketController.addTicket(ticket);
                }

                else{
                    JOptionPane.showMessageDialog(null,"CHECK IF SUM OF FIELDS IS EQUAL TO TOTAL AMOUNT !");
                }

            }

            MainPanel.mainRightPanel.clearTicketList();
            for(int i =0;i<ticketController.getAllTickets().size();i++){
                MainPanel.mainRightPanel.addElementToTicketList(ticketController.getAllTickets().get(i).getOwner().toString());
            }
        });
    }

    public void removeTicketButtonActionListener(){
        this.delUser.addActionListener(listener ->{
            int s =  MainPanel.mainRightPanel.ticketList.getSelectedIndex();
            ticketController.deleteTicketById(s);
            deleteTicketList(s);
        });
    }


    public void addToBillButtonActionListener(){
        this.lockButton.addActionListener(listener->{
         int res = JOptionPane.showConfirmDialog(null, "Are you sure that you added all the tickets ?");
            if(res == 0) {
                calculate.BillCalculation();
                ticketController.deleteAllTickets();
                MainPanel.mainRightPanel.clearTicketList();
                for(int i=0;i<billController.getAllBillsSortedById().size();i++){
                    CheckOutPanel.checkOutRightPanel.addElementToUserList(billController.getAllBillsSortedById().get(i).getOwnerName());
                }
                ViewFrame.switchFromTab(2);
                ViewFrame.disableTab(1);
            }
        });
    }

    public void resetBtnActionListener(){
        this.reset.addActionListener(listeenr->{
            tAmnt.setText("");
            for (JTextField textField : textFields) { textField.setText(""); }
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
        int ypos = 170;
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

    public void deleteTicketList(Integer index){
        MainPanel.mainRightPanel.removeElementFromTicketList(index);
    }

}
