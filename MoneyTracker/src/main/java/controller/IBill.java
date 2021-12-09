package controller;
import model.Bill;
import model.Ticket;
import java.util.List;

public interface IBill {
    void addBill(Bill b);
    void removeBill(Bill b);
    List<Bill> getAllBills();
    List<Bill> getAllBillsSortedById();
    void deleteBillById(int id);
}
