package com.order.dto;

import com.order.enums.OrderStatus;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
public class InitTrackingResponse {
    private UUID orderId;
    private OrderStatus currentStatus;
    private LocalDateTime estimatedDelivery;
}
