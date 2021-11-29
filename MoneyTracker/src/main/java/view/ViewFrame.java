package view;
import controller.UserController;
import database.DatabasePersons;
import database.PersonsDB;
import model.User;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Observable;

public class ViewFrame extends JFrame implements ActionListener {

    private Container c;
    private JLabel title;
    private JLabel name;
    private JLabel surName;
    private JTextField tname;
    private JTextField tsurName;
    private JLabel mno;
    private JTextField tmno;
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
    private DefaultListModel<String> lst = new DefaultListModel<>();
    private JList<String> userList;

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


    public ViewFrame(){
        setTitle("USER MANAGER");
        setBounds(300, 90, 900, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        c = getContentPane();
        c.setLayout(null);

        title = new JLabel("MONEY TRACKER USER REGISTRATION");
        title.setFont(new Font("Arial", Font.BOLD, 18));
        title.setSize(350, 30);
        title.setLocation(50, 20);
        c.add(title);

        name = new JLabel("Name");
        name.setFont(new Font("Arial", Font.PLAIN, 15));
        name.setSize(100, 20);
        name.setLocation(50, 100);
        c.add(name);

        tname = new JTextField();
        tname.setFont(new Font("Arial", Font.PLAIN, 15));
        tname.setSize(200, 20);
        tname.setLocation(200, 100);
        c.add(tname);

        surName = new JLabel("Surname");
        surName.setFont(new Font("Arial", Font.PLAIN, 15));
        surName.setSize(100, 20);
        surName.setLocation(50, 120);
        c.add(surName);

        tsurName = new JTextField();
        tsurName.setFont(new Font("Arial", Font.PLAIN, 15));
        tsurName.setSize(200, 20);
        tsurName.setLocation(200, 120);
        c.add(tsurName);

        gender = new JLabel("Gender");
        gender.setFont(new Font("Arial", Font.PLAIN, 15));
        gender.setSize(100, 20);
        gender.setLocation(50, 140);
        c.add(gender);

        male = new JRadioButton("Male");
        male.setFont(new Font("Arial", Font.PLAIN, 15));
        male.setSelected(true);
        male.setSize(75, 20);
        male.setLocation(200, 140);
        c.add(male);

        female = new JRadioButton("Female");
        female.setFont(new Font("Arial", Font.PLAIN, 15));
        female.setSelected(false);
        female.setSize(80, 20);
        female.setLocation(275, 140);
        c.add(female);

        gengp = new ButtonGroup();
        gengp.add(male);
        gengp.add(female);

        dob = new JLabel("Birthdate");
        dob.setFont(new Font("Arial", Font.PLAIN, 15));
        dob.setSize(100, 20);
        dob.setLocation(50, 160);
        c.add(dob);

        date = new JComboBox(dates);
        date.setFont(new Font("Arial", Font.PLAIN, 15));
        date.setSize(50, 20);
        date.setLocation(200, 160);
        c.add(date);

        month = new JComboBox(months);
        month.setFont(new Font("Arial", Font.PLAIN, 15));
        month.setSize(60, 20);
        month.setLocation(250, 160);
        c.add(month);

        year = new JComboBox(years);
        year.setFont(new Font("Arial", Font.PLAIN, 15));
        year.setSize(60, 20);
        year.setLocation(320, 160);
        c.add(year);

        add = new JLabel("Address");
        add.setFont(new Font("Arial", Font.PLAIN, 15));
        add.setSize(100, 20);
        add.setLocation(50, 180);
        c.add(add);

        tadd = new JTextArea();
        tadd.setFont(new Font("Arial", Font.PLAIN, 15));
        tadd.setSize(200, 75);
        tadd.setLocation(200, 185);
        tadd.setLineWrap(true);
        c.add(tadd);

        sub = new JButton("Create User");
        sub.setFont(new Font("Arial", Font.PLAIN, 15));
        sub.setSize(150, 20);
        sub.setLocation(50, 300);
        sub.addActionListener(this);
        c.add(sub);

        reset = new JButton("Reset Form");
        reset.setFont(new Font("Arial", Font.PLAIN, 15));
        reset.setSize(150, 20);
        reset.setLocation(250, 300);
        reset.addActionListener(this);
        c.add(reset);

        userList = new JList(lst);
        userList.setSize(450,600);
        userList.setLocation(450,0);
        c.add(userList);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == sub) {

            //GENDER CHECK
            String newGender;
            if(male.isSelected()){
                newGender = "Male";
            }
            else{newGender = "Female";}


            //GET ALL USERS FROM DB AND LIST THEM IN GUI

            DatabasePersons personsDB = PersonsDB.getInstance();
            UserController userController = new UserController(personsDB);
            User newUser = new User(UserController.id,tname.getText(),tsurName.getText(),date.getSelectedItem()+"/"+month.getSelectedItem()+"/"+year.getSelectedItem(),newGender,tadd.getText());
            userController.addUser(newUser);
            //System.out.println(userController.getAllUsersSortedById());
            System.out.println(userController.sortJsonArr());
            lst.addElement(userController.getAllUsersSortedById().get(userController.getAllUsersSortedById().size()-1).getName().toString() + " " + userController.getAllUsersSortedById().get(userController.getAllUsersSortedById().size()-1).getSurname().toString());
        }

        //RESET FORM

        else if (e.getSource() == reset) {
            String def = "";
            tname.setText(def);
            tsurName.setText(def);
            tadd.setText(def);
            date.setSelectedIndex(0);
            month.setSelectedIndex(0);
            year.setSelectedIndex(0);
        }
    }
}

