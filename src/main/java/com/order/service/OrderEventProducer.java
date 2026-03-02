/*package com.example.ordertracking.service;

import com.example.ordertracking.dto.OrderEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderEventProducer {

        private final KafkaTemplate<String, OrderEvent> kafkaTemplate;

        public void publish(String topic, OrderEvent event) {
            kafkaTemplate.send(topic, event.getOrderId(), event);
        }
    }


*/