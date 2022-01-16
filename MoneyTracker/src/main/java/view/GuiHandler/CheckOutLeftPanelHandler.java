package view.GuiHandler;

import com.sun.tools.javac.Main;
import database.BillsDB;
import database.PersonsDB;
import database.TicketsDB;
import view.ViewFrame;
import view.frames.*;

public class CheckOutLeftPanelHandler {

    PersonsDB personsDB = PersonsDB.getInstance();
    TicketsDB ticketsDB = TicketsDB.getInstance();
    BillsDB billsDB = BillsDB.getInstance();

    public void PayButtonListener(){
        personsDB.clear();
        ticketsDB.clear();
        billsDB.clear();
        MainPanel.mainRightPanel.clearTicketList();
        MainPanel.mainRightPanel.clearUserList();
        MainPanel.mainLeftPanel.resetFrm();
        RegistrationPanel.registrationRightPanel.clearUserList();
        CheckOutPanel.checkOutLeftPanel.clearOverviewList();
        CheckOutPanel.checkOutLeftPanel.clearName();
        ViewFrame.enableTab(0);
        ViewFrame.enableTab(1);
        ViewFrame.enableTab(2);
        ViewFrame.switchFromTab(0);
        CheckOutPanel.checkOutRightPanel.clearUserList();
    }

}
