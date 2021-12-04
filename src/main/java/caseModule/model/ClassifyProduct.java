package caseModule.model;

public class ClassifyProduct {
    private int id;
    private String category;

    public ClassifyProduct() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public ClassifyProduct(int id, String category) {
        this.id = id;
        this.category = category;
    }
}
