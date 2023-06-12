package domain.dto;

import java.time.LocalDateTime;

public class OrderHistoryDto {
    private int id;
    private int userId;
    private String name;
    private int amount;
    private String orderedAt;

    public OrderHistoryDto() {

    }

    public OrderHistoryDto(int id, int userId, String name, int amount, String orderedAt) {
        this.id = id;
        this.userId = userId;
        this.name = name;
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

    public String getOrderedAt() {
        return orderedAt;
    }

    public void setOrderedAt(String orderedAt) {
        this.orderedAt = orderedAt;
    }
}
