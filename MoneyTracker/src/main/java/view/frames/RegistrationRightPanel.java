package view.frames;

import javax.swing.*;
import java.awt.*;

public class RegistrationRightPanel extends JPanel {

    private DefaultListModel<String> lst = new DefaultListModel<>();
    protected JList userList;

    public RegistrationRightPanel(){
        this.setLayout(new GridLayout(1,0));
        userList = new JList(lst);
        this.add(userList);
        JScrollPane scrollPane = new JScrollPane(userList);
        scrollPane.setVisible(true);
        this.add(scrollPane);
        setVisible(true);
    }

    public void addElementToList(String elem){ lst.addElement(elem); }
    public void removeElementFromList(Integer index){lst.remove(index);}
}
