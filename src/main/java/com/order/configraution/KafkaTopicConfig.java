/*package com.example.ordertracking.configraution;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {
    @Bean
        public NewTopic orderCreatedTopic() {
            return TopicBuilder.name("order.created")
                    .partitions(3)
                    .replicas(1)
                    .build();
        }

        @Bean
        public NewTopic orderConfirmedTopic() {
            return TopicBuilder.name("order.confirmed")
                    .partitions(3)
                    .replicas(1)
                    .build();
        }

        @Bean
        public NewTopic shipmentShippedTopic() {
            return TopicBuilder.name("shipment.shipped")
                    .partitions(3)
                    .replicas(1)
                    .build();
        }

        @Bean
        public NewTopic paymentFailedTopic() {
            return TopicBuilder.name("payment.failed")
                    .partitions(3)
                    .replicas(1)
                    .build();
        }
    }*/



