package com.onlineshop.comonlineshop.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "commands")
@Data
public class Command {
    @Id
    @GeneratedValue
    private int id;
    @JsonFormat(pattern = "yyyy-MM-dd")// putem avea orice format
    private LocalDate date;

    @Column(nullable = false)
    private double total;
    @Column(columnDefinition = "text", nullable = false)
    private String details;

    @ManyToOne//mai multe comenzi poate avea un User => Command primeste @ManyToOne de User = customer
    @JoinColumn(name = "user_id", referencedColumnName = "id") // face referinta la coloana id din tablea user
    @JsonIgnoreProperties("commandsList")//nu mai trebuie sa ne dea atunci cand citim comenzi din baza de date si proprietatea cu commandsList
    private User customer;

    @ManyToMany
    @JoinTable(name = "commands_items", joinColumns = @JoinColumn(name = "command_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "item_id", referencedColumnName = "id"))
    @JsonIgnoreProperties("commandList")
    private List<Item> itemsList = new ArrayList<>();

    @Enumerated(value = EnumType.STRING)
    private PaymentStatus paymentStatus;

}
