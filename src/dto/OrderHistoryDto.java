package dto;

import java.time.LocalDateTime;

public class OrderHistoryDto {
    private int id;
    private int userId;
    private int productId;
    private int amount;
    private String orderedAt;

    public OrderHistoryDto() {

    }

    public OrderHistoryDto(int id, int userId, int productId, int amount, String orderedAt) {
        this.id = id;
        this.userId = userId;
        this.productId = productId;
        this.amount = amount;
        this.orderedAt = orderedAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getOrderedAt() {
        return orderedAt;
    }

    public void setOrderedAt(String orderedAt) {
        this.orderedAt = orderedAt;
    }
}
