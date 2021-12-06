package view.frames;

import com.sun.tools.javac.Main;
import controller.UserController;
import database.DatabasePersons;
import database.PersonsDB;
import model.User;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.ArrayList;

public class RegistrationLeftPanel extends JPanel {
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
    private JPanel panel = new JPanel();
    private DatabasePersons personsDB = PersonsDB.getInstance();
    private UserController userController = new UserController(personsDB);
    private DefaultListModel<String> lst = new DefaultListModel<>();


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

    public RegistrationLeftPanel(){

        this.setLayout(null);
        this.setBorder(new EmptyBorder(new Insets(0, 0, 0,     0)));
        title = new JLabel("MONEY TRACKER USER REGISTRATION");
        title.setFont(new Font("Arial", Font.BOLD, 18));
        title.setSize(350, 30);
        title.setLocation(10, 20);
        this.add(title);

        name = new JLabel("Name");
        name.setFont(new Font("Arial", Font.PLAIN, 15));
        name.setSize(100, 20);
        name.setLocation(10, 100);
        this.add(name);

        tname = new JTextField();
        tname.setFont(new Font("Arial", Font.PLAIN, 15));
        tname.setSize(200, 20);
        tname.setLocation(150, 100);
        this.add(tname);

        surName = new JLabel("Surname");
        surName.setFont(new Font("Arial", Font.PLAIN, 15));
        surName.setSize(100, 20);
        surName.setLocation(10, 120);
        this.add(surName);

        tsurName = new JTextField();
        tsurName.setFont(new Font("Arial", Font.PLAIN, 15));
        tsurName.setSize(200, 20);
        tsurName.setLocation(150, 120);
        this.add(tsurName);

        gender = new JLabel("Gender");
        gender.setFont(new Font("Arial", Font.PLAIN, 15));
        gender.setSize(100, 20);
        gender.setLocation(10, 140);
        this.add(gender);

        male = new JRadioButton("Male");
        male.setFont(new Font("Arial", Font.PLAIN, 15));
        male.setSelected(true);
        male.setSize(75, 20);
        male.setLocation(150, 140);
        this.add(male);

        female = new JRadioButton("Female");
        female.setFont(new Font("Arial", Font.PLAIN, 15));
        female.setSelected(false);
        female.setSize(80, 20);
        female.setLocation(225, 140);
        this.add(female);

        gengp = new ButtonGroup();
        gengp.add(male);
        gengp.add(female);

        dob = new JLabel("Birthdate");
        dob.setFont(new Font("Arial", Font.PLAIN, 15));
        dob.setSize(100, 20);
        dob.setLocation(10, 160);
        this.add(dob);

        date = new JComboBox(dates);
        date.setFont(new Font("Arial", Font.PLAIN, 15));
        date.setSize(50, 20);
        date.setLocation(150, 160);
        this.add(date);

        month = new JComboBox(months);
        month.setFont(new Font("Arial", Font.PLAIN, 15));
        month.setSize(60, 20);
        month.setLocation(200, 160);
        this.add(month);

        year = new JComboBox(years);
        year.setFont(new Font("Arial", Font.PLAIN, 15));
        year.setSize(60, 20);
        year.setLocation(260, 160);
        this.add(year);

        add = new JLabel("Address");
        add.setFont(new Font("Arial", Font.PLAIN, 15));
        add.setSize(100, 20);
        add.setLocation(10, 180);
        this.add(add);

        tadd = new JTextArea();
        tadd.setFont(new Font("Arial", Font.PLAIN, 15));
        tadd.setSize(200, 75);
        tadd.setLocation(150, 185);
        tadd.setLineWrap(true);
        this.add(tadd);
        JPanel buttonPanel = new JPanel();

        sub = new JButton("Create User");
        sub.setFont(new Font("Arial", Font.PLAIN, 15));
        //sub.setSize(150, 20);
        //sub.setLocation(50, 300);
        //sub.addActionListener(this);
        buttonPanel.add(sub);

        reset = new JButton("Reset Form");
        reset.setFont(new Font("Arial", Font.PLAIN, 15));
        //reset.setSize(150, 20);
        //reset.setLocation(250, 300);
        //reset.addActionListener(this);
        buttonPanel.add(reset);

        //userList = new JList(lst);
        //userList.setSize(400,300);
        //userList.setLocation(450,0);
        //c.add(userList);

        delUser = new JButton("Remove User");
        delUser.setFont(new Font("Arial",Font.PLAIN,15));
        //delUser.setSize(150,20);
        //delUser.setLocation(250,330);
        //delUser.addActionListener(this);
        buttonPanel.add(delUser);

        //JScrollPane scrollPane = new JScrollPane(userList);
        //scrollPane.setVisible(true);
        //scrollPane.setSize(435,362);
        //scrollPane.setLocation(450,0);
        //this.add(scrollPane);
        buttonPanel.setSize(300,50);
        buttonPanel.setLocation(15,290);
        buttonPanel.setLayout(new GridLayout(2,2,10,10));
        this.add(buttonPanel);

        setVisible(true);


        createUserButtonActionListener();
        removeUserButtonActionListener();
        resetFormButtonActionListener();

    }

    public void createUserButtonActionListener(){
        this.sub.addActionListener(listener ->{
            String name = tname.getText();
            String surname = tsurName.getText();
            String birthday = date.getSelectedItem().toString() + "/" + month.getSelectedItem().toString() + "/" + year.getSelectedItem().toString();
            String gender;
            if(male.isSelected()){ gender = "Male"; }
            else{gender = "Female";}
            String address = tadd.getText();
            User user = new User(name,surname,birthday,gender,address,0.0);
            userController.addUser(user);
            System.out.println(userController.getAllUsersSortedById());
            updateUserList();
            resetForm();
        });
    }

    public void removeUserButtonActionListener(){
        this.delUser.addActionListener(listener ->{
           Integer s =  RegistrationPanel.registrationRightPanel.userList.getSelectedIndex();
           userController.deleteUserById(s);
           System.out.println(userController.getAllUsersSortedById());
            DeleteUserList(s);
        });
    }


    public void resetFormButtonActionListener(){
        this.reset.addActionListener(listener -> {
            resetForm();
        });
    }



    public void DeleteUserList(Integer index){
        RegistrationPanel.registrationRightPanel.removeElementFromList(index);
        MainPanel.mainRightPanel.removeElementFromList(index);
    }

    public void updateUserList(){
        MainPanel.mainRightPanel.addElementToUserList(userController.getAllUsersSortedById().get(userController.getAllUsersSortedById().size()-1).getName().toString() + " " + userController.getAllUsersSortedById().get(userController.getAllUsersSortedById().size()-1).getSurname().toString());
        RegistrationPanel.registrationRightPanel.addElementToList(userController.getAllUsersSortedById().get(userController.getAllUsersSortedById().size()-1).getName().toString() + " " + userController.getAllUsersSortedById().get(userController.getAllUsersSortedById().size()-1).getSurname().toString());
    }

    public void resetForm(){
        String def = "";
        tname.setText(def);
        tsurName.setText(def);
        tadd.setText(def);
        date.setSelectedIndex(0);
        month.setSelectedIndex(0);
        year.setSelectedIndex(0);
    }

}
