package com.capstone.cart.model;

import javax.persistence.*;

@Entity
@Table
public class Orders {

    @Id

    private Long orderid;

    @Column(name = "username")
    private String username;

    @Column(name = "restName")
    private String restName;

    @Column(name = "prodid")
    private Long prodid;

    @Column(name = "prodname")
    private String prodname;

    @Column(name = "price")
    private Long price;

    private String status;
    private Long quantity;
    private Long total;
    public Orders() {

    }

    public Orders(Long cartid, String username, String restName, Long prodid, String prodname, Long price, String status, Long quantity, Long total) {
        this.orderid = cartid;
        this.username = username;
        this.restName = restName;
        this.prodid = prodid;
        this.prodname = prodname;
        this.price = price;
        this.status = status;
        this.quantity = quantity;
        this.total = total;
    }

    public Orders(Cart cNew) {
        this.orderid = cNew.getCartid();
        this.username = cNew.getUsername();
        this.restName = cNew.getRestName();
        this.prodid = cNew.getProdid();
        this.prodname = cNew.getProdname();
        this.price = cNew.getPrice();
        this.status = cNew.getStatus();
        this.quantity = cNew.getQuantity();
        this.total = cNew.getTotal();
    }

    public Long getOrderid() {
        return orderid;
    }

    public void setOrderid(Long cartid) {
        this.orderid = cartid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRestName() {
        return restName;
    }

    public void setRestName(String restName) {
        this.restName = restName;
    }

    public Long getProdid() {
        return prodid;
    }

    public void setProdid(Long prodid) {
        this.prodid = prodid;
    }

    public String getProdname() {
        return prodname;
    }

    public void setProdname(String prodname) {
        this.prodname = prodname;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }
}
