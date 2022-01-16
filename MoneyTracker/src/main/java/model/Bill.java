package model;
import java.util.HashMap;
import java.util.List;
public class Bill {

    private int id;
    private String ownerName;
    private List<HashMap<String,Double>> amountToReceive;


    public Bill(List<HashMap<String,Double>> amountToReceive,String ownerName) {
        this.amountToReceive = amountToReceive;
        this.ownerName = ownerName;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getOwnerName() { return ownerName; }
    public void setOwnerName(String ownerName) { this.ownerName = ownerName; }
    public List<HashMap<String, Double>> getAmountToReceive() { return amountToReceive; }
    public void setAmountToReceive(List<HashMap<String, Double>> amountToReceive) { this.amountToReceive = amountToReceive; }


    @Override
    public String toString() {
        return "Bill{" +
                "id=" + id +
                ", ownerName='" + ownerName + '\'' +
                ", amountToReceive=" + amountToReceive +
                '}';
    }
}
