package database;
import model.Bill;
import register_entry.RegisterEntry;
import java.util.List;
import java.util.Observable;

public abstract class DatabaseBills extends Observable {

    public DatabaseBills(){}
    public abstract void addEntry(Bill bill, RegisterEntry re);
    public abstract RegisterEntry getEntry(Bill bill);
    public abstract List<Bill> getAllBills();
    public abstract void deleteBillById(int id, RegisterEntry re);
    public abstract List<Bill> sortJsonArr();

}
