package com.onlineshop.comonlineshop.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "users")
@Data // constructori getteri setteri
public class User {
    @Id
    @GeneratedValue
    private int id;
    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String phone;
    @Enumerated(EnumType.STRING)
    private UserRole role;
    @OneToMany(mappedBy = "customer") // userul nostru va avea cheie straina in tabela commands care va face referire la proprietatea obiectului de tipul User din clasa Command
    @JsonIgnoreProperties("customer")
    private List<Command> commandList;


}
