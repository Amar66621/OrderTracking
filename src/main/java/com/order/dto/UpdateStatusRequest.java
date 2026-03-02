package com.order.dto;

import com.order.enums.OrderStatus;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UpdateStatusRequest {
    private OrderStatus status;
    private String location;
    private String remarks;
    private LocalDateTime estimatedDelivery;
}
