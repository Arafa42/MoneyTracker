package iterator;
import controller.UserController;
import database.PersonsDB;
import model.User;
import java.util.List;

public class UserRepository implements Collection{

    PersonsDB personsDB = PersonsDB.getInstance();
    UserController userController = new UserController(personsDB);
    List<User> userList = userController.getAllUsersSortedById();

    @Override
    public Iterator createIterator() {
        return new NameIterator();
    }

    private class NameIterator implements Iterator {

        int index;

        @Override
        public boolean hasNext() {
            if(index < userList.size()){ return true; }
            return false;
        }

        @Override
        public Object next() {
            if(this.hasNext()){ return userList.get(index++); }
            return null;
        }
    }
}
