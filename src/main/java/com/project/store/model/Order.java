package com.project.store.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.project.store.enums.OrderStatus;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;

import java.time.Instant;

@EqualsAndHashCode
@Entity
@Table(name = "tb_order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Instant moment;

    private Integer orderStatus;

    @JsonIgnore // Ignora o campo na construção do Json
    @ManyToOne
    @JoinColumn(name = "client_id") // nomeia a chave estrangeira
    private User user;

    public Order () {
    }

    public Order(Long id, Instant moment, User user, OrderStatus orderStatus) {
        this.id = id;
        this.moment = moment;
        setOrderStatus(orderStatus);
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getMoment() {
        return moment;
    }

    public void setMoment(Instant moment) {
        this.moment = moment;
    }

    public OrderStatus getOrderStatus() {
        return OrderStatus.valueOf(orderStatus);
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        if (orderStatus != null)
            this.orderStatus = orderStatus.getCode();
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
