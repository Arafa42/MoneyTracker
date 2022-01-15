package view.frames;

import controller.BillController;
import database.BillsDB;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class CheckOutLeftPanel extends JPanel {
    private JLabel title;
    private JLabel subTitle;
    private JPanel bill;
    private JLabel ownerName;
    private JLabel amnt;
    private BillsDB billsDB = BillsDB.getInstance();
    private BillController billController = new BillController(billsDB);
    private JButton payButton;
    private JLabel name;
    private JList userList;
    private DefaultListModel<String> lst = new DefaultListModel<>();
    private JScrollPane scrollPane;

    public CheckOutLeftPanel(){
        this.setLayout(null);
        this.setBorder(new EmptyBorder(new Insets(0,0,0,0)));

        title = new JLabel("MONEY TRACKER CHECKOUT");
        title.setFont(new Font("Arial",Font.BOLD,18));
        title.setSize(350,30);
        title.setLocation(10,20);
        this.add(title);

        subTitle = new JLabel("SELECT A RECIPIENT ->");
        subTitle.setFont(new Font("Arial", Font.BOLD,14));
        subTitle.setSize(300,20);
        subTitle.setLocation(10,55);
        this.add(subTitle);

        name = new JLabel("DEFAULT NAME");
        name.setSize(300,20);
        name.setLocation(60,100);
        name.setForeground(Color.BLUE);
        this.add(name);

        userList = new JList(lst);
        this.add(userList);
        scrollPane = new JScrollPane(userList);
        scrollPane.setVisible(true);
        scrollPane.setLocation(10,150);
        scrollPane.setSize(250,120);
        this.add(scrollPane);

        bill = new JPanel();

        ownerName = new JLabel("USER :");

        amnt = new JLabel("HAS TO RECEIVE FROM :");
        amnt.setSize(300,30);


        bill.add(ownerName);
        bill.add(amnt);
        bill.setLayout(new GridLayout(2,1));
        bill.setSize(250,40);
        bill.setLocation(10,100);
        this.add(bill);

        payButton = new JButton("Pay");
        payButton.setFont(new Font("Arial",Font.PLAIN,15));
        payButton.setLocation(15,290);
        payButton.setSize(90,20);
        this.add(payButton);

        this.setVisible(true);
    }

    public void addElementToOverview(String elem){ lst.addElement(elem); }
    public void clearOverviewList(){lst.clear();}
    public void setName(String nm){name.setText(nm);}



}
