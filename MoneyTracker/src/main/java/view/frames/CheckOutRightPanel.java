package view.frames;
import controller.BillController;
import database.BillsDB;
import view.GuiHandler.CheckOutRightPanelHandler;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;

public class CheckOutRightPanel extends JPanel {

    protected JList userList;
    private DefaultListModel<String> lst = new DefaultListModel<>();
    private DefaultListModel<String> tcktlst = new DefaultListModel<>();
    private JScrollPane scrollPane;
    private BillsDB billsDB = BillsDB.getInstance();
    private BillController billController = new BillController(billsDB);
    CheckOutRightPanelHandler checkOutRightPanelHandler = new CheckOutRightPanelHandler();

    public CheckOutRightPanel(){
        this.setLayout(new GridLayout(1,0));
        userList = new JList(lst);
        userList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                checkOutRightPanelHandler.userListSelectionOnChange(billController,userList);
            }
        });
        this.add(userList);
        scrollPane = new JScrollPane(userList);
        scrollPane.setVisible(true);
        this.add(scrollPane);
        setVisible(true);
    }

    public void addElementToUserList(String elem){ lst.addElement(elem); }


}
