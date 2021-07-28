package com.hw6.entity;

import lombok.Data;
import javax.persistence.*;

@Entity
@Table(name = "product")
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long id;

    @Column(name = "product_name", unique = true)
    private String productName;

    @Column(name = "product_price")
    private Double productPrice;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "products", referencedColumnName = "cart_id")
    private Cart cart;

}
