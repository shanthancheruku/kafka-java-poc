package com.kinandcarta.poc;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.util.Arrays;
import java.util.Properties;
import java.util.logging.Logger;

import static com.kinandcarta.poc.PocConstants.TOPIC_NAME;

public class ConsumerPoc {

    private static Logger logger = Logger.getLogger(ConsumerPoc.class.getName());

    public void consumer() {
        Properties config = ConfigurationLoader.getConfig();
        config.put(ConsumerConfig.GROUP_ID_CONFIG, "orders-group-1");
        config.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");

        try (KafkaConsumer<String, String> consumer = new KafkaConsumer<>(config)) {

            consumer.subscribe(Arrays.asList(TOPIC_NAME));
            while (true) {
                ConsumerRecords<String, String> records = consumer.poll(100);
                for (ConsumerRecord<String, String> record : records) {
                    System.out.printf("Consumed message from topic %s: key = %s value = %s", TOPIC_NAME,
                            record.key(), record.value());
                    System.out.println();
                }
            }
        } catch (Exception ex) {
            logger.severe(ex.getMessage());
            throw new RuntimeException(ex);
        }

    }
}
