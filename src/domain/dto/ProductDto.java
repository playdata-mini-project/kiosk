package domain.dto;
    private int id;
    private String name;
    private int makeTime;
    private int categoryId;
    private int price;
    private int quantity;

    public ProductDto() {
    }

    public ProductDto(int id, String name, int makeTime, int categoryId, int price, int quantity) {
        this.id = id;
        this.name = name;
        this.makeTime = makeTime;
        this.categoryId = categoryId;
        this.price = price;
        this.quantity = quantity;
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

    public int getQuantity() { return quantity;
    }

    public void setQuantity(int quantity) { this.quantity = quantity;}

    public int getMakeTime() { return makeTime; }

    public void setMakeTime(int makeTime) {
        this.makeTime = makeTime;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
