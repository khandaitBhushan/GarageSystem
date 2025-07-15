package Entity;

public class Customer {
    private int cusId;
    private String name;
    private String cusPhone;

    public Customer(int cusId, String name, String cusPhone) {
        this.cusId = cusId;
        this.name = name;
        this.cusPhone = cusPhone;
    }

    public int getCusId() {
        return cusId;
    }

    public String getName() {
        return name;
    }

    public String getCusPhone() {
        return cusPhone;
    }

    public void setCusId(int cusId) {
        this.cusId = cusId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCusPhone(String cusPhone) {
        this.cusPhone = cusPhone;
    }

    @Override
    public String toString() {
        return "[ " +
                "cusId=" + cusId +
                ", name='" + name + '\'' +
                ", cusPhone='" + cusPhone + '\'' +
                " ]";
    }
}
