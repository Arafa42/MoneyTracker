package controller;
import model.User;
import java.util.List;

public interface IUser {
    void addUser(User u);
    void removeUser(User u);
    List<User> getAllUsersSortedById();
    User getUserByName(String name);
    void deleteUserById(int id);
}
