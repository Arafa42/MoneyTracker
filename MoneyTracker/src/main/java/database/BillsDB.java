package database;
import model.Bill;
import register_entry.RegisterEntry;
import register_entry.RegisterEntryNull;
import java.util.*;

public class BillsDB extends DatabaseBills{

    private final HashMap<Bill, RegisterEntry> database;
    private static BillsDB singleton;

    public static BillsDB getInstance(){
        if(singleton == null){ singleton = new BillsDB(); }
        return singleton;
    }

    public BillsDB() {
        this.database = new HashMap<>();
    }

    @Override
    public void addEntry(Bill bill, RegisterEntry re) {
        this.database.put(bill,re);
        setChanged();
        notifyObservers(bill);
    }

    @Override
    public RegisterEntry getEntry(Bill bill) {
        return this.database.getOrDefault(bill,new RegisterEntryNull());
    }

    @Override
    public List<Bill> getAllBills() {
        ArrayList<Bill> userlist = new ArrayList<Bill>(database.keySet());
        return userlist;
    }

    @Override
    public void deleteBillById(int id,RegisterEntry re) {
        List<Bill> billList = sortJsonArr();
        billList.remove(id);
        database.clear();
        for (Bill bill : billList) {
            database.put(bill, re);
        }
        setChanged();
        System.out.println("bill : " + database.keySet());
    }

    @Override
    public Bill getBillByOwnerName(String name) {
        ArrayList<Bill> billsList = new ArrayList<>(database.keySet());
        for (Bill bill : billsList) {
            if (bill.getOwnerName().equals(name)) {
                return bill;
            }
        }
        return null;
    }

    @Override
    public List<Bill> sortJsonArr() {
        ArrayList<Bill> billList = new ArrayList<Bill>(database.keySet());
        Comparator<Bill> comparator = new Comparator<Bill>() {
            @Override
            public int compare(Bill o1, Bill o2) {
                return o1.getId() - o2.getId();
            }
        };
        Collections.sort(billList, comparator);
        return billList;
    }

    @Override
    public void clear() {
        database.clear();
    }
}