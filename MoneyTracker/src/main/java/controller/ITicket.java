package controller;
import model.Ticket;
import java.util.List;

public interface ITicket {
    void addTicket(Ticket t);
    void removeTicket(Ticket t);
    List<Ticket> getAllTickets();
    List<Ticket> getAllTicketsSortedById();
    void deleteTicketById(int id);
    String deleteAllTickets();

}