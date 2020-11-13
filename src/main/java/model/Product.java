package model;

public class Product {
    private int id;
    private String name;
    private int amount;
    private String size;
    private double price;
    Categori categori;

    public Product() {
    }

    public Product(int id, Categori categori, String name, int amount, String size, double price) {
        this.id = id;
        this.categori = categori;
        this.name = name;
        this.amount = amount;
        this.size = size;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Categori getCategori() {
        return categori;
    }

    public void setCategori(Categori categori) {
        this.categori = categori;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
