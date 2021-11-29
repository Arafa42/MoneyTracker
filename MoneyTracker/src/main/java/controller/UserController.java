package controller;

import database.DatabasePersons;
import model.User;
import register_entry.RegisterEntry;

import java.util.HashMap;
import java.util.List;

public class UserController implements IUser{

    private DatabasePersons database;

    public UserController(DatabasePersons database){
        this.database = database;
    }

    @Override
    public void addUser(User u) {
        RegisterEntry registerEntry = new RegisterEntry(true);
        database.addEntry(u,registerEntry);
    }

    @Override
    public void removeUser(User u) {
        RegisterEntry registerEntry = new RegisterEntry(false);
        database.addEntry(u,registerEntry);
    }

    @Override
    public List<User> getAllUsers() {
        return database.getAllPersons();
    }


}
