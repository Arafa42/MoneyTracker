package helper;

import controller.BillController;
import controller.TicketController;
import controller.UserController;
import database.BillsDB;
import database.PersonsDB;
import database.TicketsDB;
import model.Bill;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BillCreate {

    BillsDB billsDB = BillsDB.getInstance();
    PersonsDB personsDB = PersonsDB.getInstance();
    BillController billController = new BillController(billsDB);
    UserController userController = new UserController(personsDB);

    //CREATE A BILL FOR EVERY USER AND ADD 0.0 BY DEFAULT TO EVERYBODY'S AMOUNT TO RECEIVE
    public void BillCreation(){
        List<HashMap<String,Double>> amountToReceive = new ArrayList<HashMap<String,Double>>();

        for (int i =0;i<userController.getAllUsersSortedById().size();i++){
            Bill bill = new Bill(amountToReceive,userController.getAllUsersSortedById().get(i).getName().toString());
            billController.addBill(bill);
        }

        for (int i =0;i<billController.getAllBills().size();i++) {

            List<HashMap<String,Double>> hshmpList = new ArrayList<HashMap<String,Double>>();

            for(int j=0;j<userController.getAllUsersSortedById().size();j++){

                String ownerNameBills = billController.getAllBills().get(i).getOwnerName();
                String userName = userController.getAllUsersSortedById().get(j).getName();

                if(!ownerNameBills.equals(userName)){
                    HashMap<String,Double> hshmp = new HashMap<String,Double>();
                    hshmp.put(userName,0.0);
                    hshmpList.add(hshmp);
                    billController.getAllBills().get(i).setAmountToReceive(hshmpList);
                }
            }
        }
    }
}
