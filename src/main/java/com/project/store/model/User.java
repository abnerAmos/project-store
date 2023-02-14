package com.project.store.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@EqualsAndHashCode
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "tb_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private Integer phone;
    private Integer password;

    @OneToMany(mappedBy = "user") // informa por qual variavel esta mapeado
    private List<Order> orders;

    public User(Long id, String name, String email, Integer phone, Integer password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.password = password;
    }
}
