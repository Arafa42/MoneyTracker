package view.frames;
import javax.swing.*;
import java.awt.*;

public class MainRightPanel extends JPanel {
    public JList userList;
    protected JList ticketList;
    private DefaultListModel<String> lst = new DefaultListModel<>();
    private DefaultListModel<String> tcktlst = new DefaultListModel<>();
    private JScrollPane scrollPane2;
    private JScrollPane scrollPane;

    public MainRightPanel(){

        this.setLayout(new GridLayout(2,0,5,5));

        userList = new JList(lst);

        this.add(userList);
        scrollPane = new JScrollPane(userList);
        scrollPane.setVisible(true);
        this.add(scrollPane);

        ticketList = new JList(tcktlst);

        this.add(ticketList);
        scrollPane2 = new JScrollPane(ticketList);
        scrollPane2.setVisible(true);
        this.add(scrollPane2);

        this.setVisible(true);

    }
    public void addElementToUserList(String elem){ lst.addElement(elem); }
    public void removeElementFromList(Integer index){lst.remove(index);}
    public void addElementToTicketList(String elem){ tcktlst.addElement(elem); }
    public void clearTicketList(){tcktlst.clear();}
    public void clearUserList(){lst.clear();}
    public void removeElementFromTicketList(Integer index){tcktlst.remove(index);}

}
