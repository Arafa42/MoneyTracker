package view.frames;

import javax.swing.*;
import java.awt.*;

public class CheckOutRightPanel extends JPanel {

    protected JList userList;
    protected JList ticketList;
    private DefaultListModel<String> lst = new DefaultListModel<>();
    private DefaultListModel<String> tcktlst = new DefaultListModel<>();
    private JScrollPane scrollPane2;
    private JScrollPane scrollPane;

    public CheckOutRightPanel(){
        this.setLayout(new GridLayout(1,0));
        userList = new JList(lst);
        this.add(userList);
        scrollPane = new JScrollPane(userList);
        scrollPane.setVisible(true);
        this.add(scrollPane);
        setVisible(true);
    }
    public void addElementToUserList(String elem){ lst.addElement(elem); }
    public void removeElementFromList(Integer index){lst.remove(index);}
    public void addElementToTicketList(String elem){ tcktlst.addElement(elem); }
    public void clearTicketList(){tcktlst.clear();}
    public void removeElementFromTicketList(Integer index){tcktlst.remove(index);}

}
