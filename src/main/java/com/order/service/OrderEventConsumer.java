/*package com.example.ordertracking.service;

import com.example.ordertracking.dto.OrderEvent;
import com.example.ordertracking.dto.OrderStatusRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor

public class OrderEventConsumer {

        private final OrderTrackingService orderTrackingService;

        @KafkaListener(
                topics = {
                        "order.created",
                        "order.confirmed",
                        "shipment.shipped",
                        "payment.failed"
                },
                groupId = "order-tracking-group"
        )
        public void consume(OrderEvent event) {

            OrderStatusRequest request = new OrderStatusRequest();
            request.setOrderId(UUID.fromString(event.getOrderId()));
            request.setUpdatedBy("KAFKA_EVENT");

            switch (event.getEventType()) {
                case "ORDER_CREATED" -> request.setStatus("CREATED");
                case "ORDER_CONFIRMED" -> request.setStatus("CONFIRMED");
                case "ORDER_SHIPPED" -> request.setStatus("SHIPPED");
                case "PAYMENT_FAILED" -> request.setStatus("CANCELLED");
                default -> {
                    return;
                }
            }

            orderTrackingService.updateStatus(request);
        }
    }


*/