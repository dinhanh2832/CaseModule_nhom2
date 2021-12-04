package caseModule.model;

public class Customer {
private int id;
private String name;
private int age;
private int numberPhone;
private String email;
private String userNameAcc;
private String pass;
private int role;

    public Customer() {
    }

    public Customer(int id, String name, int age, int nuberPhone, String email, String userNameAcc, String pass, int role) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.numberPhone = nuberPhone;
        this.email = email;
        this.userNameAcc = userNameAcc;
        this.pass = pass;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(int numberPhone) {
        this.numberPhone = numberPhone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserNameAcc() {
        return userNameAcc;
    }

    public void setUserNameAcc(String userNameAcc) {
        this.userNameAcc = userNameAcc;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }
}
