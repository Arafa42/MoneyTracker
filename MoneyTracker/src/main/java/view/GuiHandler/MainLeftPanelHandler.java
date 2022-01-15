package view.GuiHandler;

import controller.TicketController;
import controller.UserController;
import model.Ticket;
import model.User;
import view.ViewFrame;
import view.frames.MainPanel;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;

public class MainLeftPanelHandler {

    public void addTicketListener(JTextField tAmnt, UserController userController, JRadioButton even, JComboBox ticketTypes, TicketController ticketController, ArrayList<JTextField> textFields){
        Double totalAmnt = Double.parseDouble(tAmnt.getText());
        String name = ticketTypes.getSelectedItem().toString();
        User owner = userController.getAllUsersSortedById().get(MainPanel.mainRightPanel.userList.getSelectedIndex());
        boolean isEven = true;
        HashMap<User,Double> hashmap = new HashMap<User,Double>();
        Ticket ticket = null;

        if(even.isSelected()){
            isEven = true; ticket = new Ticket(totalAmnt,name,owner,isEven);
            ticketController.addTicket(ticket);
            ViewFrame.disableTab(0);
        }
        else{

            Double sum = 0.0;
            for (JTextField textField : textFields) { sum += Double.parseDouble(textField.getText()); }

            if(sum.equals(totalAmnt)) {
                isEven = false;
                for (int i = 0; i < userController.getAllUsersSortedById().size(); i++) {
                    hashmap.put(userController.getAllUsersSortedById().get(i), Double.parseDouble(textFields.get(i).getText()));
                }
                ticket = new Ticket(totalAmnt, name, owner, isEven, hashmap);
                ticketController.addTicket(ticket);
            }

            else{ JOptionPane.showMessageDialog(null,"CHECK IF SUM OF FIELDS IS EQUAL TO TOTAL AMOUNT !"); }
        }

        MainPanel.mainRightPanel.clearTicketList();
        for(int i =0;i<ticketController.getAllTickets().size();i++){
            MainPanel.mainRightPanel.addElementToTicketList(ticketController.getAllTickets().get(i).getOwner().toString());
        }
    }

}
