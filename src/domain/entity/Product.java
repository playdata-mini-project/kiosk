package domain.entity;

public class Product {

    int id;
    String name;
    int makeTime;
    int categoryId;
    int price;
    int quantity;

    public Product(int id, String name, int makeTime, int categoryId, int price, int quantity) {
        this.id = id;
        this.name = name;
        this.makeTime = makeTime;
        this.categoryId = categoryId;
        this.price = price;
        this.quantity = quantity;
    }

    public void plusQuantity(int amount){
        this.quantity += amount;
    }
    public void minusQuantity(int amount){
        this.quantity -= amount;
    }
}
