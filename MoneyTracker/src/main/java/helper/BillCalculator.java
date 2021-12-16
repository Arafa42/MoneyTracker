package helper;

import controller.ITicket;
import controller.TicketController;
import controller.UserController;
import database.DatabaseTickets;
import database.PersonsDB;
import database.TicketsDB;
import model.User;

import java.util.Map;

public class BillCalculator {
    DatabaseTickets ticketsDB = TicketsDB.getInstance();
    PersonsDB personsDB = PersonsDB.getInstance();

    UserController userController = new UserController(personsDB);
    TicketController ticketController = new TicketController(ticketsDB);

    public BillCalculator() {

    }
    public void billCalculation() {

        System.out.println("CALCULATE");

        //GET ALL TICKETS
        for (int i = 0; i < ticketController.getAllTickets().size(); i++) {

            //GET OWNER OF CURRENT TICKET
            User owner = ticketController.getAllTickets().get(i).getOwner();
            if (ticketController.getAllTickets().get(i).getSplitEven()) {
                //LOOP THROUGH USERS CHECK IF USER IS NOT EQUAL TO OWNER
                for (int j = 0; j < userController.getAllUsersSortedById().size(); j++) {
                    if (userController.getAllUsersSortedById().get(j) != owner) {

                        // IF TICKET IS SPLIT EVEN GET TOTAL AMOUNT OF TICKET EN DEEL DOOR TOTAL AMOUNT OF USERS IN DB

                        Double AmountToPayOwner = ticketController.getAllTickets().get(i).getTotalAmount() / userController.getAllUsersSortedById().size();
                        System.out.println(userController.getAllUsersSortedById().get(j).getName() + " HAS TO PAY " + owner.getName() + "NEXT AMOUNT : " + AmountToPayOwner);



                    }
                }
            } else {
                for (Map.Entry<User, Double> entry : ticketController.getAllTickets().get(i).getUnevenSplitAmount().entrySet()) {
                    int k = 0;
                    k++;
                    if (entry.getKey() != owner) {
                        System.out.println(userController.getAllUsersSortedById().get(k).getName() + " HAS TO PAY " + owner.getName() + "NEXT AMOUNT : " + entry.getValue());


                    }
                }


            }
        }
    }
}
