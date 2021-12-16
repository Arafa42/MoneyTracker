package helper;

import controller.BillController;
import controller.TicketController;
import controller.UserController;
import database.BillsDB;
import database.PersonsDB;
import database.TicketsDB;
import model.Bill;
import model.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Calculator {

    BillsDB billsDB = BillsDB.getInstance();
    PersonsDB personsDB = PersonsDB.getInstance();
    TicketsDB ticketsDB = TicketsDB.getInstance();
    TicketController ticketController = new TicketController(ticketsDB);
    BillController billController = new BillController(billsDB);
    UserController userController = new UserController(personsDB);

    public void BillCreation(){

        List<HashMap<String,Double>> amountToReceive = new ArrayList<HashMap<String,Double>>();
        for (int i =0;i<userController.getAllUsersSortedById().size();i++){
            Bill bill = new Bill(amountToReceive,userController.getAllUsersSortedById().get(i).getName().toString());
            billController.addBill(bill);
        }

        for (int i =0;i<billController.getAllBills().size();i++) {
            List<HashMap<String,Double>> hshmpList = new ArrayList<HashMap<String,Double>>();
            for(int j=0;j<userController.getAllUsersSortedById().size();j++){
                if(billController.getAllBills().get(i).getOwnerName() != userController.getAllUsersSortedById().get(j).getName()){
                    HashMap<String,Double> hshmp = new HashMap<String,Double>();
                    hshmp.put(userController.getAllUsersSortedById().get(j).getName(),0.0);
                    hshmpList.add(hshmp);
                    billController.getAllBills().get(i).setAmountToReceive(hshmpList);
                }
            }
        }

        System.out.println(billController.getAllBills());

    }


    public void BillCalculation(){

        BillCreation();

        //GET ALL TICKETS
        for (int i=0;i<ticketController.getAllTickets().size();i++){

            //GET OWNER OF CURRENT TICKET
            User owner = ticketController.getAllTickets().get(i).getOwner();
            if(ticketController.getAllTickets().get(i).getSplitEven()){
                //LOOP THROUGH USERS CHECK IF USER IS NOT EQUAL TO OWNER
                for (int j =0;j<userController.getAllUsersSortedById().size();j++){
                    if(userController.getAllUsersSortedById().get(j) != owner){
                        // IF TICKET IS SPLIT EVEN GET TOTAL AMOUNT OF TICKET EN DEEL DOOR TOTAL AMOUNT OF USERS IN DB
                        Double AmountToPayOwner = ticketController.getAllTickets().get(i).getTotalAmount() / userController.getAllUsersSortedById().size();
                        System.out.println(userController.getAllUsersSortedById().get(j).getName() + " HAS TO PAY " + owner.getName() + "NEXT AMOUNT : " + AmountToPayOwner);







                    }
                }
            }
            else {
                for (Map.Entry<User, Double> entry : ticketController.getAllTickets().get(i).getUnevenSplitAmount().entrySet()){
                    int k = 0;
                    k++;
                    if(entry.getKey() != owner){
                        System.out.println(userController.getAllUsersSortedById().get(k).getName() + " HAS TO PAY " + owner.getName() + "NEXT AMOUNT : " + entry.getValue());
                    }
                }
            }
        }
    }


}