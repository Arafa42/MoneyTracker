package view.frames;

import javax.swing.*;

public class MainRightPanel extends JPanel {
    private JList userList;
    private JList ticketList;
    private DefaultListModel<String> lst = new DefaultListModel<>();
    private DefaultListModel<String> tcktlst = new DefaultListModel<>();
    public MainRightPanel(){
        userList = new JList(lst);
        userList.setSize(400,300);
        userList.setLocation(450,0);
        this.add(userList);

        ticketList = new JList(tcktlst);
        ticketList.setSize(400,300);
        ticketList.setLocation(0,0);
        this.add(ticketList);

        JScrollPane scrollPane = new JScrollPane(userList);
        scrollPane.setVisible(true);
        scrollPane.setSize(435,180);
        scrollPane.setLocation(0,0);
        this.add(scrollPane);

        JScrollPane scrollPane2 = new JScrollPane(ticketList);
        scrollPane2.setVisible(true);
        scrollPane2.setSize(435,180);
        scrollPane2.setLocation(0,181);
        this.add(scrollPane2);
    }
}
