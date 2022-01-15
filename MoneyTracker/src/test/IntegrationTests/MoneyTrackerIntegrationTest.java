package IntegrationTests;
import controller.BillController;
import controller.TicketController;
import controller.UserController;
import database.BillsDB;
import database.PersonsDB;
import database.TicketsDB;
import helper.Calculator;
import model.Ticket;
import model.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.util.HashMap;

public class MoneyTrackerIntegrationTest {

    public MoneyTrackerIntegrationTest(){}

    @Before
    public void initialize(){}

    @Mock
    private final PersonsDB personsDB = PersonsDB.getInstance();
    @Mock
    private final UserController userController = new UserController(personsDB);
    @Mock
    private final TicketsDB ticketsDB = TicketsDB.getInstance();
    @Mock
    private final TicketController ticketController = new TicketController(ticketsDB);
    @Mock
    private final BillsDB billsDB = BillsDB.getInstance();
    @Mock
    private final BillController billController = new BillController(billsDB);
    @Mock
    private final Calculator calculator = new Calculator();


    @Test
    public void CreateUser()
    {
        //CREATE USERS
        User ayoub = new User("Ayoub","","","","",0.0);
        User arafa = new User("Arafa","","","","",0.0);
        userController.addUser(ayoub);
        userController.addUser(arafa);

        HashMap hashMap = new HashMap<User,Double>();
        hashMap.put(ayoub,150.0);
        hashMap.put(arafa,50.0);

        //CREATE TICKETS FOR USERS
        Ticket ticket1 = new Ticket(100.0,"resto",ayoub,true);
        Ticket ticket2 = new Ticket(200.0,"concert",arafa,false,hashMap);

        ticketController.addTicket(ticket1);
        ticketController.addTicket(ticket2);

        //CALCULATE BILLS
        calculator.BillCalculation();

        //TEST VALUE
        Double testValueAyoubHasToReceiveFromArafa = Double.parseDouble(removeFirstandLastLetter(billController.getAllBillsSortedById().get(0).getAmountToReceive().get(0).values().toString()));
        Double testValueArafaHasToReceiveFromAyoub = Double.parseDouble(removeFirstandLastLetter(billController.getAllBillsSortedById().get(1).getAmountToReceive().get(0).values().toString()));

        //EXPECTED VALUE
        Double ExpectedValueAyoubHasToReceiveFromArafa = 0.0;
        Double ExpectedValueArafaHasToReceiveFromAyoub = 100.0;

        //CHECK IF TEST PASSES
        Assert.assertEquals(ExpectedValueArafaHasToReceiveFromAyoub,testValueArafaHasToReceiveFromAyoub);
        Assert.assertEquals(ExpectedValueAyoubHasToReceiveFromArafa,testValueAyoubHasToReceiveFromArafa);

    }

    public String removeFirstandLastLetter(String str)
    { str = str.substring(1, str.length() - 1); return str; }



}
