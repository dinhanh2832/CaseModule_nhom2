package caseModule.model;

public class Order {
    private int id;
    private int time;
    private int customerId;
    private int productId;

    public Order() {
    }

    public Order(int id, int time, int customerId, int productId) {
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

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
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
