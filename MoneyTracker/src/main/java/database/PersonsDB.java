package database;
import model.User;
import register_entry.RegisterEntry;
import register_entry.RegisterEntryNull;
import java.util.*;

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

    @Override
    public void deleteUserById(int id,RegisterEntry re) {
        List<User> userList = sortJsonArr();
        userList.remove(id);
        database.clear();
        for (User user : userList) {
            database.put(user, re);
        }
        setChanged();
        System.out.println("delUser : " + database.keySet());
    }

    @Override
    public User getUserByName(String name) {
        ArrayList<User> userList = new ArrayList<>(database.keySet());
        for (User user : userList) {
            if (user.getName().equals(name)) {
                return user;
            }
        }
        return null;
    }

    @Override
    public List<User> sortJsonArr() {
        ArrayList<User> userlist = new ArrayList<User>(database.keySet());
        Comparator<User> comparator = new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return o1.getId() - o2.getId();
            }
        };
        Collections.sort(userlist, comparator);
        return userlist;
    }

    @Override
    public void clear() {
        database.clear();
    }
}