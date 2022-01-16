package model;
import java.util.ArrayList;
import java.util.HashMap;

public class Ticket {

    private Double totalAmount;
    private String name;
    private User owner;
    private User paidByUser;
    private ArrayList<User> users;
    private Boolean splitEven;
    private HashMap<User,Double> unevenSplitAmount;
    private Integer id;

    public Ticket(Double totalAmount, String name, User owner, Boolean splitEven, HashMap<User,Double> unevenSplitAmount){
        this.totalAmount = totalAmount;
        this.name = name;
        this.owner = owner;
        this.splitEven = splitEven;
        this.unevenSplitAmount = unevenSplitAmount;
        this.paidByUser = getPaidBy();
    }

    public Ticket(Double totalAmount, String name, User owner, Boolean splitEven){
        this.totalAmount = totalAmount;
        this.name = name;
        this.owner = owner;
        this.splitEven = splitEven;
    }



    public Ticket() {

    }

    public Ticket(String name) {
        this.name = name;
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
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
    public User getPaidBy() {return paidByUser;}
    public ArrayList getPaidFor() {return getPaidFor();}
    @Override
    public String toString() {
        return "Ticket{" +
                "totalAmount=" + totalAmount +
                ", name='" + name + '\'' +
                ", owner=" + owner +
                ", splitEven=" + splitEven +
                ", unevenSplitAmount=" + unevenSplitAmount +
                ", id=" + id +
                '}';
    }
}
