package caseModule.model;

public class Cart {
    int idProduct;
    int idCustomer;

    public Cart( int idProduct, int idCustomer) {
        this.idProduct = idProduct;
        this.idCustomer = idCustomer;
    }

    public Cart() {
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
