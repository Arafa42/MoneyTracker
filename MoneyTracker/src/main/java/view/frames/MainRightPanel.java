package view.frames;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class MainRightPanel extends JPanel {
    private JList userList;
    private JList ticketList;
    private DefaultListModel<String> lst = new DefaultListModel<>();
    private DefaultListModel<String> tcktlst = new DefaultListModel<>();
    public MainRightPanel(){

        this.setLayout(new GridLayout(2,0,5,5));

        userList = new JList(lst);

        this.add(userList);
        JScrollPane scrollPane = new JScrollPane(userList);
        scrollPane.setVisible(true);
        this.add(scrollPane);



        ticketList = new JList(tcktlst);

        this.add(ticketList);
        JScrollPane scrollPane2 = new JScrollPane(ticketList);
        scrollPane2.setVisible(true);
        this.add(scrollPane2);


    }
}
