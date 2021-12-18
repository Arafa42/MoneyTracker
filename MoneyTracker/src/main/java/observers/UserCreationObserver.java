package observers;

import database.PersonsDB;
import model.User;
import register_entry.RegisterEntry;

import java.util.Observable;
import java.util.Observer;

public class UserCreationObserver implements Observer {
    // Jens heeft gekeken en vondt het in orde omdit tegebruiken!
    // propertychangelistener
    @Override
    public void update(Observable o, Object arg) {
        User user = (User) arg;
        String nameUser = user.getName();
        RegisterEntry registerEntry = PersonsDB.getInstance().getEntry((User) arg);

        System.out.println("Name: "+ nameUser +", and entry: "+ registerEntry);
        //System.out.println("OBSERVED USER CREATED");
    }
}
