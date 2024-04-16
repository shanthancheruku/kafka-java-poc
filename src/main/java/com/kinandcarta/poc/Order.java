package com.kinandcarta.poc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;

public class Order {

    private static final Logger log = LoggerFactory.getLogger(Order.class);

    private long orderTime;
    private int orderId;
    private String ItemId;
    private Address address;

    public Order(long orderTime, int orderId, String itemId, Address address) {
        this.orderTime = orderTime;
        this.orderId = orderId;
        ItemId = itemId;
        this.address = address;
    }

    public long getOrderTime() {
        return orderTime;
    }

    public int getOrderId() {
        return orderId;
    }

    public String getItemId() {
        return ItemId;
    }

    public Address getAddress() {
        return address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order order)) return false;
        return orderTime == order.orderTime && orderId == order.orderId && Objects.equals(ItemId, order.ItemId) &&
                Objects.equals(address, order.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderTime, orderId, ItemId, address);
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderTime=" + orderTime +
                ", orderId=" + orderId +
                ", ItemId='" + ItemId + '\'' +
                ", address=" + address +
                '}';
    }
}
