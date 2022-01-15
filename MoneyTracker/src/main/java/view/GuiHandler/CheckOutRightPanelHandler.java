package view.GuiHandler;

import controller.BillController;
import view.frames.CheckOutPanel;
import javax.swing.*;

public class CheckOutRightPanelHandler {
    public void userListSelectionOnChange(BillController billController, JList userList ) {
        if (userList.getSelectedIndex() != -1) {
            String owner = billController.getAllBillsSortedById().get(userList.getSelectedIndex()).getOwnerName();
            CheckOutPanel.checkOutLeftPanel.setName(owner);
            CheckOutPanel.checkOutLeftPanel.clearOverviewList();
            for (int i = 0; i < billController.getAllBillsSortedById().get(userList.getSelectedIndex()).getAmountToReceive().size(); i++) {
                String name = removeFirstandLast(billController.getAllBillsSortedById().get(userList.getSelectedIndex()).getAmountToReceive().get(i).keySet().toString());
                String val = removeFirstandLast(billController.getAllBillsSortedById().get(userList.getSelectedIndex()).getAmountToReceive().get(i).values().toString());
                CheckOutPanel.checkOutLeftPanel.addElementToOverview("user " + name + " an amount of " + val);
            }
        }
    }
    public String removeFirstandLast(String str)
    {
        str = str.substring(1, str.length() - 1);
        return str;
    }

}
