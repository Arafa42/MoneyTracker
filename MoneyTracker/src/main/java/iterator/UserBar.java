package iterator;
import controller.UserController;
import database.PersonsDB;
import model.User;
import java.util.List;

public class UserBar {

    private final PersonsDB personsDB = PersonsDB.getInstance();
    private final UserController userController = new UserController(personsDB);
    private List<User> userList = userController.getAllUsersSortedById();
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
