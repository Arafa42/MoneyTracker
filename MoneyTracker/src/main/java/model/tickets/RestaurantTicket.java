package model.tickets;
import model.Ticket;
import model.User;
import java.util.HashMap;

public class RestaurantTicket extends Ticket {
    public RestaurantTicket(Double totalAmount, String name, User owner, Boolean splitEven, HashMap<User, Double> unevenSplitAmount) {
        super(totalAmount, name, owner, splitEven, unevenSplitAmount);
    }

    public RestaurantTicket(String name) {
        super(name);
    }
}
