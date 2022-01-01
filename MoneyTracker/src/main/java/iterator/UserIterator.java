package iterator;
import model.User;

import java.util.List;

public class UserIterator implements Iterator{
    List<User> userList;

    int pos = 0;

    public  UserIterator (List<User> userList)
    {
        this.userList = userList;
    }

    public Object next()
    {
        User user =  userList.get(pos);
        pos += 1;
        return user;
    }

    public boolean hasNext()
    {
        if (pos >= userList.size() ||
                userList.get(pos) == null)
            return false;
        else
            return true;
    }
}
