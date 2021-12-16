package observers;

import model.Ticket;
import model.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;

public class CalculateObserver implements Observer {
    @Override
    public void update(Observable o, Object arg) {
        Ticket  ticket = (Ticket) arg;
        boolean splitEven = ticket.getSplitEven();

        User user = ticket.getPaidBy();

        ArrayList<User> usersGiving = ticket.getPaidFor();

        HashMap<User,Double> users = new HashMap<>();

        for (User u : usersGiving){
           // users.put(u,u.getAmountToPay());
        }


    }
}
