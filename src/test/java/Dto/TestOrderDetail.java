package Dto;

public class TestOrderDetail {
    String Status;
    int courierId;
    String customerName;
    String customerPhone;
    String comment;
    long id;


    public TestOrderDetail( String customerName, String customerPhone, String comment) {
        Status ="OPEN";
        this.courierId = 0;
        this.customerName = customerName;
        this.customerPhone = customerPhone;
        this.comment = comment;
        this.id = 0;
    }

    public TestOrderDetail() {
        Status ="OPEN";
        this.courierId = 0;
        this.id = 0;
    }

    //SETTER METHOD USED TO SEND VALUE

    public void setCourierId(int courierId) {
        this.courierId = courierId;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
