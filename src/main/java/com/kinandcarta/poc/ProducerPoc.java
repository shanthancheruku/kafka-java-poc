package com.kinandcarta.poc;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;
import java.util.logging.Logger;

import static com.kinandcarta.poc.PocConstants.TOPIC_NAME;

public class ProducerPoc {

    private static Logger logger = Logger.getLogger(ProducerPoc.class.getName());

    public void produce() {
        Properties config = ConfigurationLoader.getConfig();
        try{
        Producer<String, String> producer = new KafkaProducer<>(config);
        for (int i = 1; i < 11; i++) {
            Order value = OrderGenerator.generateRandomOrder(i);
            producer.send(new ProducerRecord<>(TOPIC_NAME, Integer.toString(i), value.toString()));
        }
        producer.close();
    } catch (Exception e) {
            logger.severe(e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
