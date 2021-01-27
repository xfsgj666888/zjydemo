package com.example.demo.entity;

import lombok.Data;
import lombok.ToString;
import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Data
@Entity
@Table(name = "commodity")
@ToString
@JsonIgnoreProperties({"handler","hibernateLazyInitializer"})
public class Commodity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    private String picture;
    private String name;
    private String date;
    private String seller;
    private int price;
    private String note;
    @ManyToOne
    @JoinColumn(name="cid")
    private Category category;
}
