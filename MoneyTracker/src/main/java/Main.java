import controller.TicketController;
import controller.UserController;
import database.DatabasePersons;
import database.PersonsDB;
import database.TicketsDB;
import iterator.UserBar;
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

        ViewFrame frame = new ViewFrame();
        frame.initialize();

        UserCreationObserver userCreationObserver = new UserCreationObserver();
        personsDB.addObserver(userCreationObserver);





    }
}