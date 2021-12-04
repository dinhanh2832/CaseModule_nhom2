package caseModule.model;

public class Order {
    private int id;
    private String time;
    private int customerId;
    private int productId;

    public Order() {
    }

    public Order(int id, String time, int customerId, int productId) {
        this.id = id;
        this.time = time;
        this.customerId = customerId;
        this.productId = productId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }
}
