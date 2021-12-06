package view.frames;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class CheckOutLeftPanel extends JPanel {
    private JLabel title;
    private JLabel subTitle;
    private JPanel bill;
    private SpringLayout springLayoutPanel;
    private JLabel ownerName;
    private JLabel name;
    private JLabel amnt;
    private JLabel amntToPay;


    private JButton payButton;

    public CheckOutLeftPanel(){
        this.setLayout(null);
        this.setBorder(new EmptyBorder(new Insets(0,0,0,0)));

        title = new JLabel("MONEY TRACKER CHECKOUT");
        title.setFont(new Font("Arial",Font.BOLD,18));
        title.setSize(350,30);
        title.setLocation(10,20);
        this.add(title);

        subTitle = new JLabel("Choose a user for paying his debt ->");
        subTitle.setFont(new Font("Arial", Font.BOLD,14));
        subTitle.setSize(300,20);
        subTitle.setLocation(10,55);
        this.add(subTitle);


        bill = new JPanel();
        springLayoutPanel = new SpringLayout();

        ownerName = new JLabel("Owner name:");
        name = new JLabel("arafa");

        amnt = new JLabel("Amount:");
        amntToPay = new JLabel("330euro");

        bill.add(ownerName);
        bill.add(name);
        bill.add(amnt);
        bill.add(amntToPay);
        //springLayoutPanel.putConstraint(SpringLayout.WEST, ownerName, 10, SpringLayout.WEST, bill);
        //springLayoutPanel.putConstraint(SpringLayout.NORTH, ownerName, 25, SpringLayout.NORTH, bill);
        //springLayoutPanel.putConstraint(SpringLayout.NORTH, name, 25, SpringLayout.NORTH, bill);
        //springLayoutPanel.putConstraint(SpringLayout.WEST, name, 20, SpringLayout.EAST, ownerName);

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

}
