package com.ust.cravio.orderhistory.entity;

import javax.persistence.*;

@Entity
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cartid")
    private Long cartid;

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
}
