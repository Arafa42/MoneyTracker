package model.tickets;
import model.Ticket;
import model.User;
import java.util.HashMap;

public class CinemaTicket extends Ticket {

    public CinemaTicket(Double totalAmount, String name, User owner, Boolean splitEven, HashMap<User, Double> unevenSplitAmount) {
        super(totalAmount, name, owner, splitEven, unevenSplitAmount);
    }

    public CinemaTicket(String name) {
        super(name);
    }
}
