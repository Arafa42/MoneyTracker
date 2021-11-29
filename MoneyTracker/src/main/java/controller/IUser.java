package controller;
import model.User;
import register_entry.RegisterEntry;

import java.util.HashMap;
import java.util.List;

public interface IUser {
    void addUser(User u);
    void removeUser(User u);
    List<User> getAllUsersSortedById();
}
