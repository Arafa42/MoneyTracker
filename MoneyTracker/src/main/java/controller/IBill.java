package controller;
import model.Bill;

import java.util.List;

public interface IBill {
    void addBill(Bill b);
    void removeBill(Bill b);
    List<Bill> getAllBills();
    List<Bill> getAllBillsSortedById();
    Bill getBillByOwnerName(String name);
    void deleteBillById(int id);
}
