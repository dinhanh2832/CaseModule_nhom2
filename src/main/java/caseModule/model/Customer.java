package caseModule.model;

public class Customer {
private int id;
private String name;
private int age;
private String numberPhone;
private String email;
private double money;
private String userNameAcc;
private String pass;
private int role;
private int status;

    public Customer() {
    }

    public Customer(int id, String name, int age, String numberPhone, String email,double money, String userNameAcc, String pass, int role,int status) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.numberPhone = numberPhone;
        this.email = email;
        this.money = money;
        this.userNameAcc = userNameAcc;
        this.pass = pass;
        this.role = role;
        this.status = status;
    }

    public Customer(String name, int age, String numberPhone, String email, double money, String userNameAcc, String pass) {
        this.name = name;
        this.age = age;
        this.numberPhone = numberPhone;
        this.email = email;
        this.money = money;
        this.userNameAcc = userNameAcc;
        this.pass = pass;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
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

    public String getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(String numberPhone) {
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

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }
}
