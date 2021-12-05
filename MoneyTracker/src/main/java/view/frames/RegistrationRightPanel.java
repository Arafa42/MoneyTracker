package view.frames;

import javax.swing.*;
import java.awt.*;

public class RegistrationRightPanel extends JPanel {
    private JLabel title;
    private JLabel name;
    private JLabel surName;
    private JTextField tname;
    private JTextField tsurName;
    private JLabel gender;
    private JRadioButton male;
    private JRadioButton female;
    private ButtonGroup gengp;
    private JLabel dob;
    private JComboBox date;
    private JComboBox month;
    private JComboBox year;
    private JLabel add;
    private JTextArea tadd;
    private JButton sub;
    private JButton reset;
    private JButton delUser;
    private DefaultListModel<String> lst = new DefaultListModel<>();
    private JList userList;
    private JPanel panel = new JPanel();

    private String dates[]
            = { "1", "2", "3", "4", "5",
            "6", "7", "8", "9", "10",
            "11", "12", "13", "14", "15",
            "16", "17", "18", "19", "20",
            "21", "22", "23", "24", "25",
            "26", "27", "28", "29", "30",
            "31" };
    private String months[]
            = { "Jan", "feb", "Mar", "Apr",
            "May", "Jun", "July", "Aug",
            "Sup", "Oct", "Nov", "Dec" };
    private String years[]
            = { "1995", "1996", "1997", "1998",
            "1999", "2000", "2001", "2002",
            "2003", "2004", "2005", "2006",
            "2007", "2008", "2009", "2010",
            "2011", "2012", "2013", "2014",
            "2015", "2016", "2017", "2018",
            "2019" };

    public RegistrationRightPanel(){
        this.setLayout(new GridLayout(1,0));
        userList = new JList(lst);
        //userList.setSize(400,300);
        //userList.setLocation(450,0);
        this.add(userList);
        JScrollPane scrollPane = new JScrollPane(userList);
        scrollPane.setVisible(true);
        //scrollPane.setSize(435,362);
        //scrollPane.setLocation(450,0);
        this.add(scrollPane);
    }
}
