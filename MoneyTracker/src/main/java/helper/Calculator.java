package helper;
import controller.BillController;
import controller.TicketController;
import controller.UserController;
import database.BillsDB;
import database.PersonsDB;
import database.TicketsDB;
import model.Bill;
import model.User;
import java.util.List;
import java.util.Map;

public class Calculator {

    BillsDB billsDB = BillsDB.getInstance();
    PersonsDB personsDB = PersonsDB.getInstance();
    TicketsDB ticketsDB = TicketsDB.getInstance();
    TicketController ticketController = new TicketController(ticketsDB);
    BillController billController = new BillController(billsDB);
    UserController userController = new UserController(personsDB);
    BillCreate billCreate = new BillCreate();


    public void SplitEvenCalculation(User owner, Integer i){
        //LOOP THROUGH USERS CHECK IF USER IS NOT EQUAL TO OWNER
        for (int j =0;j<userController.getAllUsersSortedById().size();j++){
            if(userController.getAllUsersSortedById().get(j) != owner){

                // IF TICKET IS SPLIT EVEN GET TOTAL AMOUNT OF TICKET EN DEEL DOOR TOTAL AMOUNT OF USERS IN DB
                Double AmountToPayOwner = ticketController.getAllTickets().get(i).getTotalAmount() / userController.getAllUsersSortedById().size();

                for(int x = 0;x<billController.getAllBillsSortedById().size();x++){
                    if(owner.getName().equals(billController.getAllBillsSortedById().get(x).getOwnerName())){
                        for(int y=0;y<billController.getAllBillsSortedById().get(x).getAmountToReceive().size();y++){

                            String userNames = userController.getAllUsersSortedById().get(j).getName();
                            String billAmountToReceiveName = billController.getAllBillsSortedById().get(x).getAmountToReceive().get(y).keySet().toString();

                            if(("[" + userNames + "]").equals(billAmountToReceiveName)) {
                                billController.getAllBillsSortedById().get(x).getAmountToReceive().get(y).put(userNames,AmountToPayOwner);
                            }
                        }
                    }
                }
            }
        }
    }


    public void SplitUnEvenCalculation(User owner,Integer i){
        //LOOP THROUGH HASHMAP FOR UNEVENSPLIT AMOUNT IN TICKETS
        for (Map.Entry<User, Double> entry : ticketController.getAllTickets().get(i).getUnevenSplitAmount().entrySet()){
            if(entry.getKey() != owner){
                for(int x = 0;x<billController.getAllBillsSortedById().size();x++){
                    String billsOwnerName = billController.getAllBillsSortedById().get(x).getOwnerName();
                    if(owner.getName().equals(billsOwnerName)){
                        for(int y=0;y<billController.getAllBillsSortedById().get(x).getAmountToReceive().size();y++){
                            String userName =  userController.getUserByName(entry.getKey().getName()).getName();
                            if(("[" + userName + "]").equals(billController.getAllBillsSortedById().get(x).getAmountToReceive().get(y).keySet().toString()))
                            {
                                Double previousValue = Double.parseDouble(billController.getAllBillsSortedById().get(x).getAmountToReceive().get(y).values().toArray()[0].toString());
                                billController.getAllBillsSortedById().get(x).getAmountToReceive().get(y).put(userName,previousValue + entry.getValue());
                            }
                        }
                    }
                }
            }
        }
    }


    public void BillAmountToReceiveLoopCheck(String nameOfAmountToReceive, String currOwner, List<Bill> billList, Integer i, Integer j){
        for (int x = 0; x < billController.getBillByOwnerName(nameOfAmountToReceive).getAmountToReceive().size(); x++) {
            if (billController.getBillByOwnerName(nameOfAmountToReceive).getAmountToReceive().get(x).keySet().toString().equals('[' + currOwner + ']')) {

                Double toReceiveFirstOwner = Double.parseDouble(removeFirstandLastLetter(billList.get(i).getAmountToReceive().get(j).values().toString()));
                String amountsToReceiveBills = billController.getBillByOwnerName(nameOfAmountToReceive).getAmountToReceive().get(x).values().toString();
                Double toReceiveSecondOwner = Double.parseDouble(removeFirstandLastLetter(amountsToReceiveBills));
                String billOwnerName = billController.getBillByOwnerName(nameOfAmountToReceive).getOwnerName();

                if(toReceiveFirstOwner > toReceiveSecondOwner){
                    billController.getBillByOwnerName(currOwner).getAmountToReceive().get(x).replace(nameOfAmountToReceive,toReceiveFirstOwner-toReceiveSecondOwner);
                    billController.getBillByOwnerName(billOwnerName).getAmountToReceive().get(x).replace(currOwner,0.0);
                }

                else if(toReceiveFirstOwner < toReceiveSecondOwner){
                    billController.getBillByOwnerName(currOwner).getAmountToReceive().get(x).replace(nameOfAmountToReceive,0.0);
                    billController.getBillByOwnerName(billOwnerName).getAmountToReceive().get(x).replace(currOwner,toReceiveSecondOwner-toReceiveFirstOwner);
                }

                else{
                    billController.getBillByOwnerName(currOwner).getAmountToReceive().get(x).replace(nameOfAmountToReceive,0.0);
                    billController.getBillByOwnerName(billOwnerName).getAmountToReceive().get(x).replace(currOwner,0.0);
                }
            }
        }
    }

    public void MergeBills() {
        List<Bill> billList = billController.getAllBillsSortedById();
        String currOwner = "";

        for (int i = 0; i < billController.getAllBillsSortedById().size(); i++) {
            currOwner = billList.get(i).getOwnerName();
            for (int j = 0; j < billList.get(i).getAmountToReceive().size(); j++) {
                String billsAmountToReceiveName = billList.get(i).getAmountToReceive().get(j).keySet().toString();
                String nameOfAmountToReceive = removeFirstandLastLetter(billsAmountToReceiveName);
                // IF 2 PEOPLE HAVE TO PAY EACHOTHER SUBSTRACT THEIR TICKETS FROM EACHOTHER
                BillAmountToReceiveLoopCheck(nameOfAmountToReceive,currOwner,billList,i,j);
            }
        }
    }


    public String removeFirstandLastLetter(String str)
    { str = str.substring(1, str.length() - 1); return str; }


    public void BillCalculation(){
        //CREATE THE BILLS FOR EVERY USER
        billCreate.BillCreation();
        //CALCULATE THE BILLS FOR USERS EVEN OR UNEVEN SPLIT
        for (int i=0;i<ticketController.getAllTickets().size();i++){
            User owner = ticketController.getAllTickets().get(i).getOwner();
            if(ticketController.getAllTickets().get(i).getSplitEven()){ SplitEvenCalculation(owner,i); }
            else { SplitUnEvenCalculation(owner,i); }
        }
        //MERGE BILLS BY SUBSTRACTION IF 2 PERSONS HAVE TO PAY EACH OTHER SO THAT ONLY 1 HAS TO PAY THE OTHER...
        MergeBills();
    }

}
