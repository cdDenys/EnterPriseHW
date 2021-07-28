package com.hw6.entity;

import lombok.Data;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "cart")
@Data
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_id")
    private Long id;

    @OneToMany(fetch = FetchType.LAZY)
    @Column(name = "products")
    private List<Product> products;

    @Column(name = "cart_price", nullable = false)
    private Double cartPrice;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "carts", referencedColumnName = "person_id")
    private Person person;

}
