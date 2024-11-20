package com.onlineshop.comonlineshop.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "items")
@Data
public class Item {
    @Id
    @GeneratedValue
    private int id;

    @Column(nullable = false)
    private String title;

    @Column(columnDefinition = "text",nullable = false) // descrierea va avea mai multe caractere decat varchar(255)
    private String description;

    @Column(nullable = false)
    private double price;
    @Column(columnDefinition = "text",nullable = false)
    private String image1;
    @Column(columnDefinition = "text",nullable = false)
    private String image2;
    @Column(columnDefinition = "text",nullable = false)
    private String image3;
    @Column(columnDefinition = "text",nullable = false)
    private String image4;
    @Enumerated(value = EnumType.STRING)
    private ItemType itemType;
    @ManyToMany(mappedBy = "itemsList")
    @JsonIgnoreProperties("itemsList")
    private List<Command> commandList;

}
