import controller.TicketController;
import controller.UserController;
import database.DatabasePersons;
import database.PersonsDB;
import database.TicketsDB;
import model.Ticket;
import model.User;
import observers.UserCreationObserver;
import view.ViewFrame;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        main.run();
    }

    public Main(){
    }

    public void run() {

        //CREATE PERSONS
        DatabasePersons personsDB = PersonsDB.getInstance();
        UserController userController = new UserController(personsDB);
//        User user = new User("Arafa","Yoncalik","30/06/1999","male","lalastraat 10",0.0);
//        User user2 = new User("Pipi","Kaka","30/06/1999","male","lalastraat 10",0.0);
//        userController.addUser(user);
//        userController.addUser(user2);
//
//        CREATE SOME TICKETS FOR SOME PERSONS
//        TicketsDB ticketsDB = new TicketsDB();
//        HashMap<User,Double> uneven = new HashMap<User,Double>();
//        uneven.put(user,20.0);
//        uneven.put(user2,30.0);
//        TicketController ticketController = new TicketController(ticketsDB);
//        Ticket ticket = new Ticket(100.00,"Cinema Ticket",user,true,uneven);
//        Ticket ticket2 = new Ticket(50.00,"Racket Ticket",user,false,uneven);
//        ticketController.addTicket(ticket);
//        ticketController.addTicket(ticket2);
//
//
//        HashMap<User,Double> amountToPayForEverybody = new HashMap<User,Double>();
//        int amountOfUsers = userController.getAllUsersSortedById().size();
//        double total = 0.0;
//        Double curam = 0.0;
//
//        for (int i =0;i<ticketController.getAllTickets().size();i++){
//
//            if(ticketController.getAllTickets().get(i).getSplitEven()){
//
//                EACH PERSON PAYS SAME AMOUNT
//                    for (int j=0;j<userController.getAllUsersSortedById().size();j++){
//
//                        curam =  amountToPayForEverybody.get(userController.getAllUsersSortedById().get(j));
//                        if(curam != null) {
//                            amountToPayForEverybody.put(userController.getAllUsersSortedById().get(j), curam + (ticketController.getAllTickets().get(i).getTotalAmount() / amountOfUsers));
//                        }
//                        else{
//                            amountToPayForEverybody.put(userController.getAllUsersSortedById().get(j), (ticketController.getAllTickets().get(i).getTotalAmount() / amountOfUsers));
//                        }
//
//                    }
//            }
//
//            if(!ticketController.getAllTickets().get(i).getSplitEven()){
//
//                EACH PERSON DIFFERENT AMOUNT
//                for (int j=0;j<userController.getAllUsersSortedById().size();j++) {
//                    curam =  amountToPayForEverybody.get(userController.getAllUsersSortedById().get(j));
//                    if(curam != null) {
//                        amountToPayForEverybody.put(userController.getAllUsersSortedById().get(j), curam + (ticketController.getAllTickets().get(i).getUnevenSplitAmount().get(userController.getAllUsersSortedById().get(j))));
//                    }
//                    else{
//                        amountToPayForEverybody.put(userController.getAllUsersSortedById().get(j), (ticketController.getAllTickets().get(i).getUnevenSplitAmount().get(userController.getAllUsersSortedById().get(j))));
//                    }
//
//                }
//            }
//        }
//
//        System.out.println(ticketController.getAllTickets());
//        System.out.println(amountToPayForEverybody);
//

        ViewFrame frame = new ViewFrame();
        frame.initialize();

        UserCreationObserver userCreationObserver = new UserCreationObserver();
        personsDB.addObserver(userCreationObserver);


    }
}