package database;
import register_entry.RegisterEntry;
import model.User;
import java.util.List;
import java.util.Observable;

public abstract class DatabasePersons extends Observable{
    public DatabasePersons(){}
    public abstract void addEntry(User user, RegisterEntry re);
    public abstract RegisterEntry getEntry(User user);
    public abstract List<User> getAllPersons();
    public abstract void deleteUserById(int id, RegisterEntry re);
    public abstract User getUserByName(String name);
    public abstract List<User> sortJsonArr();
    public abstract void clear();
}
