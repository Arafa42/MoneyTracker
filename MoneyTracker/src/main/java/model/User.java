package model;

public class User {

    private String name;
    private String surname;
    private String birthday;
    private String sex;
    private String address;
    private Integer id;
    private Double amountToPay;

    public User(String name, String surname, String birthday, String sex, String address, Double amountToPay){
        this.name = name;
        this.surname = surname;
        this.birthday = birthday;
        this.sex = sex;
        this.address = address;
        this.amountToPay = amountToPay;
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getSurname() { return surname; }
    public void setSurname(String surname) { this.surname = surname; }
    public String getBirthday() { return birthday; }
    public void setBirthday(String birthday) { this.birthday = birthday; }
    public String getSex() { return sex; }
    public void setSex(String sex) { this.sex = sex; }
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
    public Double getAmountToPay() { return amountToPay; }
    public void setAmountToPay(Double amountToPay) { this.amountToPay = amountToPay; }


    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", birthday='" + birthday + '\'' +
                ", sex='" + sex + '\'' +
                ", address='" + address + '\'' +
                ", id=" + id +
                ", amountToPay=" + amountToPay +
                '}';
    }
}