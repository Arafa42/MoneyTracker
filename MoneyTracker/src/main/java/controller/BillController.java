package controller;
import database.DatabaseBills;
import model.Bill;
import register_entry.RegisterEntry;
import java.util.List;

public class BillController implements IBill{

    private DatabaseBills database;
    public static Integer id = 0;

    public BillController(DatabaseBills database){ this.database = database; }

    @Override
    public void addBill(Bill b) {
        b.setId(id++);
        RegisterEntry registerEntry = new RegisterEntry(true);
        database.addEntry(b,registerEntry);
    }

    @Override
    public void removeBill(Bill b) {
        RegisterEntry registerEntry = new RegisterEntry(false);
        database.addEntry(b, registerEntry);
    }

    @Override
    public List<Bill> getAllBills() {
        return database.getAllBills();
    }

    @Override
    public List<Bill> getAllBillsSortedById() {
        return database.sortJsonArr();
    }

    @Override
    public Bill getBillByOwnerName(String name) {
        return database.getBillByOwnerName(name);
    }

    @Override
    public void deleteBillById(int id) {
        RegisterEntry registerEntry = new RegisterEntry(false);
        database.deleteBillById(id,registerEntry);
    }
}
