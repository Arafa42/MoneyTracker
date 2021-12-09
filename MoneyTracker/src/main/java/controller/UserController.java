package controller;
import database.DatabasePersons;
import model.User;
import register_entry.RegisterEntry;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class UserController implements IUser, Observer {

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
    public List<User> getAllUsersSortedById() {
        return database.sortJsonArr();
    }

    @Override
    public void deleteUserById(int id) {
        RegisterEntry registerEntry = new RegisterEntry(false);
        database.deleteUserById(id,registerEntry);
    }


    @Override
    public void update(Observable o, Object arg) {
            System.out.println("Usercontroller observer blabla");
    }
}