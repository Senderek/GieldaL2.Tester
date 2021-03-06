package pl.senderek.gieldal2.tester.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;
/**
 * Przedstawia informacje o ofercie sprzedaży, zwrócone z API
 */
public class SellOfferDTO {
    private Long id;
    private Long sellerId;
    private Long shareId;
    private Integer amount;
    private Double price;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    private LocalDateTime date;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSellerId() {
        return sellerId;
    }

    public void setSellerId(Long sellerId) {
        this.sellerId = sellerId;
    }

    public Long getShareId() {
        return shareId;
    }

    public void setShareId(Long shareId) {
        this.shareId = shareId;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Double getPrice() { return price; }

    public void setPrice(Double price) { this.price = price; }

    public LocalDateTime getDate() { return date; }

    public void setDate(LocalDateTime date) { this.date = date; }
}
