package caseModule.model;

public class Cart {
    int id;
    int idProduct;
    int idCustomer;

    public Cart(int id, int idProduct, int idCustomer) {
        this.id = id;
        this.idProduct = idProduct;
        this.idCustomer = idCustomer;
    }

    public Cart() {
    }

    public Cart(int idProduct, int idCustomer) {
        this.idProduct = idProduct;
        this.idCustomer = idCustomer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public int getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
    }
}
