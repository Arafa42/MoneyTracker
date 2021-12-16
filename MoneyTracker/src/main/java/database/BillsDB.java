package database;

import model.Bill;
import model.User;
import register_entry.RegisterEntry;
import register_entry.RegisterEntryNull;

import java.util.*;

public class BillsDB extends DatabaseBills{

    private final HashMap<Bill, RegisterEntry> database;
    private static BillsDB singletonijn;

    public static BillsDB getInstance(){
        if(singletonijn == null){ singletonijn = new BillsDB(); }
        return singletonijn;
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
        for(int i =0;i<billList.size();i++) { database.put(billList.get(i), re); }
        setChanged();
        System.out.println("bill : " + database.keySet());
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
}