package com.github.vvzhuchkov.carpool.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class Order extends Entity implements Serializable {
    private String from;
    private String to;
    private String cargo;
    private String weight;
    private Date date;
    private String comment;
    private OrderState orderState;

    public Order(int id, String from, String to, String cargo, String weight, Date date, String comment, OrderState orderState) {
        super(id);
        this.from = from;
        this.to = to;
        this.cargo = cargo;
        this.weight = weight;
        this.date = date;
        this.comment = comment;
        this.orderState = orderState;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "Order {" +
                ", from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", cargo='" + cargo + '\'' +
                ", weight='" + weight + '\'' +
                ", date=" + date +
                ", comment='" + comment + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return from.equals(order.from) && to.equals(order.to) && cargo.equals(order.cargo) &&
                weight.equals(order.weight) && date.equals(order.date) && Objects.equals(comment, order.comment);
    }

    @Override
    public int hashCode() {
        return 31 * Objects.hash(from, to, cargo, weight, date, comment);
    }
}
