package controller;

import database.DatabasePersons;
import model.User;
import register_entry.RegisterEntry;
import java.util.*;
import java.util.List;

public class UserController implements IUser{

    private DatabasePersons database;
    public static Integer id = 0;

    public UserController(DatabasePersons database){
        this.database = database;
    }

    @Override
    public void addUser(User u) {
        u.setId(id++);
        RegisterEntry registerEntry = new RegisterEntry(true);
        database.addEntry(u,registerEntry);
    }

    @Override
    public void removeUser(User u) {
        RegisterEntry registerEntry = new RegisterEntry(false);
        database.addEntry(u,registerEntry);
    }

    @Override
    public List<User> getAllUsersSortedById() { return sortJsonArr(); }



    public List<User> sortJsonArr(){
        List<User> list = new ArrayList<User>();
        list = database.getAllPersons();
        Comparator<User> comparator = new Comparator<User>() {
                @Override
                public int compare(User o1, User o2) {
                    return o1.getId() - o2.getId();
                }
            };
            Collections.sort(list, comparator);
            return list;

    }




}
