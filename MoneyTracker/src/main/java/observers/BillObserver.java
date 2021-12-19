package observers;

import database.BillsDB;
import database.PersonsDB;
import model.Bill;
import model.User;
import register_entry.RegisterEntry;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Observable;
import java.util.Observer;
// Jens heeft gekeken en vondt het in orde omdit tegebruiken!
    // propertychangelistener
public class BillObserver implements PropertyChangeListener {
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        Bill bill = (Bill) evt.getNewValue();
        String owner =  bill.getOwnerName();

        RegisterEntry registerEntry = BillsDB.getInstance().getEntry((Bill) evt.getNewValue());

        System.out.println("Name: "+ owner +", and entry: "+ registerEntry);

    }


}
