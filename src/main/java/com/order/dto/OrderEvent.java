package com.order.dto;

import lombok.Data;

import java.time.LocalDateTime;
@Data
public class OrderEvent {

        private String orderId;
        private String eventType;
        private LocalDateTime timestamp;
    }


