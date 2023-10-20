package com.sda.auctionsservice.dto;

public class SellerReviewDTO {
    private int rate;
    private String comment;
    private int sellerId;
    private int reviewerId;

    public SellerReviewDTO(int rate, String comment, int sellerId, int reviewerId) {
        this.rate = rate;
        this.comment = comment;
        this.sellerId = sellerId;
        this.reviewerId = reviewerId;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getSellerId() {
        return sellerId;
    }

    public void setSellerId(int sellerId) {
        this.sellerId = sellerId;
    }

    public int getReviewerId() {
        return reviewerId;
    }

    public void setReviewerId(int reviewerId) {
        this.reviewerId = reviewerId;
    }
}
