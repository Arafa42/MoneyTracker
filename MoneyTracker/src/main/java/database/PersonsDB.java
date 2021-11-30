package database;

import com.sun.jdi.Value;
import model.User;
import register_entry.RegisterEntry;
import register_entry.RegisterEntryNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class PersonsDB extends DatabasePersons{

    private final HashMap<User, RegisterEntry> database;
    private static PersonsDB singletonijn;


    public static PersonsDB getInstance(){
        if(singletonijn == null){ singletonijn = new PersonsDB(); }
        return singletonijn;
    }


    public PersonsDB() {
        this.database = new HashMap<>();
    }


    @Override
    public void addEntry(User user, RegisterEntry re) {
        this.database.put(user,re);
        setChanged();
        notifyObservers(user);
    }

    @Override
    public RegisterEntry getEntry(User user) {
        return this.database.getOrDefault(user,new RegisterEntryNull());
    }

    @Override
    public List<User> getAllPersons() {
        ArrayList<User> userlist = new ArrayList<User>(database.keySet());
        return userlist;
    }


}
