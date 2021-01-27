package com.example.demo.entity;

import lombok.Data;
import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.ToString;

@Data
@Entity
@Table(name = "shopcar")
@ToString
@JsonIgnoreProperties({"handler","hibernateLazyInitializer"})
public class Shopcar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    private String name;
    private String date;
    private String seller;
    private int price;
    private String note;
    private String picture;
}
