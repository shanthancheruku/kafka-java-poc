package com.kinandcarta.poc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;
import java.util.ArrayList;
import java.util.List;

public class OrderGenerator {

    private static final Logger log = LoggerFactory.getLogger(OrderGenerator.class);

    private static final String[] cities = {"New York", "Chicago", "San Francisco", "Los Angeles", "Miami"};
    private static final String[] states = {"NY", "IL", "CA", "CA", "FL"};
    private static final int[] zipcodes = {10001, 60007, 94101, 90001, 33101};
    private static final Random random = new Random();

    private static Address generateRandomAddress() {
        int index = random.nextInt(cities.length);
        return new Address(cities[index], states[index], zipcodes[index]);
    }

    public static Order generateRandomOrder(int orderId) {
        long orderTime = System.currentTimeMillis() + random.nextInt(1000000);
        String itemId = "Item" + random.nextInt(100);
        Address address = generateRandomAddress();
        return new Order(orderTime, orderId, itemId, address);
    }

    public static void main(String[] args) {
        List<Order> orders = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            orders.add(generateRandomOrder(i + 1));
        }

        orders.forEach(System.out::println);
    }
}

