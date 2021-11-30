package model;
import java.util.HashMap;

public class Ticket {

    private Double totalAmount;
    private String name;
    private User owner;
    private Boolean splitEven;
    private HashMap<User,Double> unevenSplitAmount;

    public Ticket(Double totalAmount, String name, User owner, Boolean splitEven, HashMap<User,Double> unevenSplitAmount){
        this.totalAmount = totalAmount;
        this.name = name;
        this.owner = owner;
        this.splitEven = splitEven;
        this.unevenSplitAmount = unevenSplitAmount;
    }

    public Ticket() {

    }

    public Ticket(String name) {
        this.name = name;
    }

    public Double getTotalAmount() { return totalAmount; }
    public void setTotalAmount(Double totalAmount) { this.totalAmount = totalAmount; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public User getOwner() { return owner; }
    public void setOwner(User owner) { this.owner = owner; }
    public Boolean getSplitEven() { return splitEven; }
    public void setSplitEven(Boolean splitEven) { this.splitEven = splitEven; }
    public HashMap<User,Double> getUnevenSplitAmount() { return unevenSplitAmount; }
    public void setUnevenSplitAmount(HashMap<User,Double> unevenSplitAmount) { this.unevenSplitAmount = unevenSplitAmount; }

    @Override
    public String toString() {
        return "Ticket{" +
                "totalAmount=" + totalAmount +
                ", name='" + name + '\'' +
                ", owner=" + owner +
                ", splitEven=" + splitEven +
                ", unevenSplitAmount=" + unevenSplitAmount +
                '}';
    }

}
