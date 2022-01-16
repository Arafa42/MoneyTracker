package observers;

import database.PersonsDB;
import model.User;
import register_entry.RegisterEntry;

import java.util.Observable;
import java.util.Observer;

public class UserCreationObserver implements Observer {
    // Jens heeft gekeken en vond het in orde om dit te gebruiken!
    // propertychangelistener
    @Override
    public void update(Observable o, Object arg) {
        User user = (User) arg;
        String nameUser = user.getName();
        RegisterEntry registerEntry = PersonsDB.getInstance().getEntry((User) arg);
        System.out.println("Name: "+ nameUser +", and user entry: "+ registerEntry);
    }
}
