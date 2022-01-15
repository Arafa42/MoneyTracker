package observers;
import database.BillsDB;
import model.Bill;
import register_entry.RegisterEntry;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

// Jens heeft gekeken en vond het in orde om dit te gebruiken!
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