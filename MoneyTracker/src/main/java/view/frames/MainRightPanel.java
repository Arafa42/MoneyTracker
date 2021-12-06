package view.frames;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class MainRightPanel extends JPanel {
    protected JList userList;
    protected JList ticketList;
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
    public void addElementToUserList(String elem){ lst.addElement(elem); }
    public void removeElementFromList(Integer index){lst.remove(index);}
    public void addElementToTicketList(String elem){ tcktlst.addElement(elem); }
    public void clearTicketList(){tcktlst.clear();}
    public void removeElementFromTicketList(Integer index){tcktlst.remove(index);}
}
