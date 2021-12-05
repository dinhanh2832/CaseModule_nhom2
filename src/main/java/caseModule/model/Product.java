package caseModule.model;

public class Product {
    private int id;
    private int price;
    private int classifyId;
    private String description;
    private String userProduct;
    private String pass;
    private int status = 1;
    private int serverId;

    public Product() {
    }

    public Product(int id, int price, int classifyId, String description, String userProduct, String pass, int status, int serverId) {
        this.id = id;
        this.price = price;
        this.classifyId = classifyId;
        this.description = description;
        this.userProduct = userProduct;
        this.pass = pass;
        this.status = status;
        this.serverId = serverId;
    }

    public Product(int price, int classifyId, String description, String userProduct, String pass, int status, int serverId) {
        this.price = price;
        this.classifyId = classifyId;
        this.description = description;
        this.userProduct = userProduct;
        this.pass = pass;
        this.status = status;
        this.serverId = serverId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getClassifyId() {
        return classifyId;
    }

    public void setClassifyId(int classifyId) {
        this.classifyId = classifyId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUserProduct() {
        return userProduct;
    }

    public void setUserProduct(String userProduct) {
        this.userProduct = userProduct;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getServerId() {
        return serverId;
    }

    public void setServerId(int serverId) {
        this.serverId = serverId;
    }
}
