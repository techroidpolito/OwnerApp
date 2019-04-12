package com.gratus.ownerapp.model;

import java.io.Serializable;

public class NoofOrderAdapterModel implements Serializable {
    private Integer LayoutType;
    private String userName;
    private String timeOrder;
    private String noItems;
    private String totalAmt;
    private String paymentType;
    private Boolean accept;
    private Boolean reject;
    private String orderNo;
    private String Address;
    private String itemName;
    private String header;
    private String Note;
    public NoofOrderAdapterModel(String userName, String timeOrder, String noItems, String totalAmt, String paymentType, Boolean accept, Boolean reject, String orderNo) {
        this.userName = userName;
        this.timeOrder = timeOrder;
        this.noItems = noItems;
        this.totalAmt = totalAmt;
        this.paymentType = paymentType;
        this.accept = accept;
        this.reject = reject;
        this.orderNo = orderNo;
    }
    public NoofOrderAdapterModel(Integer layoutType, String userName, String timeOrder, String noItems, String totalAmt, String paymentType, Boolean accept, Boolean reject, String orderNo) {
        LayoutType = layoutType;
        this.userName = userName;
        this.timeOrder = timeOrder;
        this.noItems = noItems;
        this.totalAmt = totalAmt;
        this.paymentType = paymentType;
        this.accept = accept;
        this.reject = reject;
        this.orderNo = orderNo;
    }

    public NoofOrderAdapterModel(Integer layoutType,  String header,String address) {
        LayoutType = layoutType;
        Address = address;
        this.header = header;
    }

    public NoofOrderAdapterModel(Integer layoutType, String noItems, String itemName, String note) {
        LayoutType = layoutType;
        this.noItems = noItems;
        this.itemName = itemName;
        Note = note;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getTimeOrder() {
        return timeOrder;
    }

    public void setTimeOrder(String timeOrder) {
        this.timeOrder = timeOrder;
    }

    public String getNoItems() {
        return noItems;
    }

    public void setNoItems(String noItems) {
        this.noItems = noItems;
    }

    public String getTotalAmt() {
        return totalAmt;
    }

    public void setTotalAmt(String totalAmt) {
        this.totalAmt = totalAmt;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public Boolean getAccept() {
        return accept;
    }

    public void setAccept(Boolean accept) {
        this.accept = accept;
    }

    public Boolean getReject() {
        return reject;
    }

    public void setReject(Boolean reject) {
        this.reject = reject;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public Integer getLayoutType() {
        return LayoutType;
    }

    public void setLayoutType(Integer layoutType) {
        LayoutType = layoutType;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getNote() {
        return Note;
    }

    public void setNote(String note) {
        Note = note;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }
}
