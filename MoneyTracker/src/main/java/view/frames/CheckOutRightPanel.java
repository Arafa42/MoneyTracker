package view.frames;
import controller.BillController;
import database.BillsDB;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;

public class CheckOutRightPanel extends JPanel {

    protected JList userList;
    protected JList billList;
    private DefaultListModel<String> lst = new DefaultListModel<>();
    private DefaultListModel<String> tcktlst = new DefaultListModel<>();
    private JScrollPane scrollPane2;
    private JScrollPane scrollPane;
    private BillsDB billsDB = BillsDB.getInstance();
    private BillController billController = new BillController(billsDB);

    public CheckOutRightPanel(){
        this.setLayout(new GridLayout(1,0));
        userList = new JList(lst);
        userList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                System.out.println(userList.getSelectedIndex());
                String owner = billController.getAllBillsSortedById().get(userList.getSelectedIndex()).getOwnerName();
                CheckOutPanel.checkOutLeftPanel.setName(owner);
                CheckOutPanel.checkOutLeftPanel.clearOverviewList();
                for (int i = 0; i < billController.getAllBillsSortedById().get(userList.getSelectedIndex()).getAmountToReceive().size(); i++) {
                    String name = removeFirstandLast(billController.getAllBillsSortedById().get(userList.getSelectedIndex()).getAmountToReceive().get(i).keySet().toString());
                    String val = removeFirstandLast(billController.getAllBillsSortedById().get(userList.getSelectedIndex()).getAmountToReceive().get(i).values().toString());
                    CheckOutPanel.checkOutLeftPanel.addElementToOverview("user " + name + " an amount of " + val);
                }
            }
        });
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
    public void clearUserList(){lst.clear();}
    public void removeElementFromTicketList(Integer index){tcktlst.remove(index);}


    public String removeFirstandLast(String str)
    {
        str = str.substring(1, str.length() - 1);
        return str;
    }

}
