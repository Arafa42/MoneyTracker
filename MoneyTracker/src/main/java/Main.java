import controller.UserController;
import database.*;
import observers.BillObserver;
import observers.TicketObserver;
import observers.UserCreationObserver;
import view.ViewFrame;

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
        UserCreationObserver userCreationObserver = new UserCreationObserver();
        personsDB.addObserver(userCreationObserver);

        ViewFrame frame = new ViewFrame();
        frame.initialize();
        
    }
}