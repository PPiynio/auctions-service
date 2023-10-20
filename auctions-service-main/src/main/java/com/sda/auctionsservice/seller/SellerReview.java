package com.sda.auctionsservice.seller;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


@Entity
public class SellerReview {
    @Id // Every entity requires unique id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // defining way of generating public key - IDENTITY works well with MySQL
    private Integer id;

    @NotNull
    @Min(1)
    @Max(5)
    private Integer rate;

    @Size(min =5, max = 150)
    private String comment;

    @ManyToOne()
    @JoinColumn(name = "seller_id")
    private Seller seller;

    @NotNull
    private Integer reviewerId;

    public SellerReview(Integer rate, String comment, Seller seller, Integer reviewerId) {
        this.rate = rate;
        this.comment = comment;
        this.seller = seller;
        this.reviewerId = reviewerId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRate() {
        return rate;
    }

    public void setRate(Integer rate) {
        this.rate = rate;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    public Integer getReviewerId() {
        return reviewerId;
    }

    public void setReviewerId(Integer reviewerId) {
        this.reviewerId = reviewerId;
    }
}
