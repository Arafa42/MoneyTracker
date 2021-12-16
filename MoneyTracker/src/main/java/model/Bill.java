package model;

import java.util.HashMap;
import java.util.List;

public class Bill {

    private int id;
    private List<HashMap<String,Double>> amountToReceive;


    public Bill(List<HashMap<String,Double>> amountToReceive) {
        this.amountToReceive = amountToReceive;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }


    @Override
    public String toString() {
        return "Bill{" +
                "id=" + id +
                ", amountToReceive=" + amountToReceive +
                '}';
    }

}
