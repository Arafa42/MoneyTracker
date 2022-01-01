package iterator;


import controller.UserController;
import database.PersonsDB;
import model.User;

import java.util.List;

public class UserBar {

    PersonsDB personsDB = PersonsDB.getInstance();
    UserController userController = new UserController(personsDB);
    List<User> userList = userController.getAllUsersSortedById();

    public UserBar(List<User> userList)
    {
        this.userList = userList;
    }

    public void printNotifications()
    {
        Iterator iterator = userController.createIterator();
        System.out.println("-------USER BAR------------");
        while (iterator.hasNext())
        {
            User n = (User) iterator.next();
            System.out.println(n);
        }
    }

}
