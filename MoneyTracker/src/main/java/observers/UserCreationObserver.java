package observers;

import database.PersonsDB;
import model.User;
import register_entry.RegisterEntry;

import java.util.Observable;
import java.util.Observer;

public class UserCreationObserver implements Observer {
    @Override
    public void update(Observable o, Object arg) {

        System.out.println("OBSERVED USER CREATED");
    }
}
