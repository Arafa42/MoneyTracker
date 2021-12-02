package view.frames;

import javax.swing.*;

public class ListWhitePanel extends JFrame {


    public ListWhitePanel(DefaultListModel input){
        JList list = new JList(input);
        this.add(list);

        JScrollPane scrollPanel = new JScrollPane(list);
        this.add(scrollPanel);

    }

}
