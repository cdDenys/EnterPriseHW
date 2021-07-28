package com.hw6.entity;


import lombok.Data;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "person")
@Data
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "person_id")
    private Long id;

    @Column(name = "person_name", unique = true)
    private String personName;

    @OneToMany(fetch = FetchType.LAZY)
    @Column(name = "carts")
    private List<Cart> carts;

}
