package com.kinandcarta.poc;

public class Main {
    public static void main(String[] args) {
        ProducerPoc producerPoc = new ProducerPoc();
        producerPoc.produce();

        ConsumerPoc consumerPoc = new ConsumerPoc();
        consumerPoc.consumer();
    }
}