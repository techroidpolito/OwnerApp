package com.gratus.ownerapp.model;

import java.io.Serializable;

public class PromoCodeModel implements Serializable {
    private String promoName;
    private String discount;
    private String condition;
    private String description;
    private String fromDate;
    private String fromTime;
    private String toDate;
    private String toTime;

    public PromoCodeModel(String promoName, String discount, String condition, String description, String fromDate, String fromTime, String toDate, String toTime) {
        this.promoName = promoName;
        this.discount = discount;
        this.condition = condition;
        this.description = description;
        this.fromDate = fromDate;
        this.fromTime = fromTime;
        this.toDate = toDate;
        this.toTime = toTime;
    }

    public PromoCodeModel(String promoName, String discount, String condition, String description) {
        this.promoName = promoName;
        this.discount = discount;
        this.condition = condition;
        this.description = description;
    }

    public String getPromoName() {
        return promoName;
    }

    public void setPromoName(String promoName) {
        this.promoName = promoName;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFromDate() {
        return fromDate;
    }

    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }

    public String getFromTime() {
        return fromTime;
    }

    public void setFromTime(String fromTime) {
        this.fromTime = fromTime;
    }

    public String getToDate() {
        return toDate;
    }

    public void setToDate(String toDate) {
        this.toDate = toDate;
    }

    public String getToTime() {
        return toTime;
    }

    public void setToTime(String toTime) {
        this.toTime = toTime;
    }
}
