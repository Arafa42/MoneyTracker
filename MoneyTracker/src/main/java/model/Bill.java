package model;

public class Bill {

    private int id;
    private String name;
    private Double amountToPay;

    public Bill(String name, Double amountToPay) {
        this.name = name;
        this.amountToPay = amountToPay;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public Double getAmountToPay() { return amountToPay; }
    public void setAmountToPay(Double amountToPay) { this.amountToPay = amountToPay; }

    @Override
    public String toString() {
        return "Bill{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", amountToPay=" + amountToPay +
                '}';
    }

}
