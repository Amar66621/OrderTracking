package com.order.dto;

import com.order.enums.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
public class OrderStatusRequest {

    private Long id;
    private UUID orderId;

    private OrderStatus status;

    private String remarks;
    private String updatedBy;


}


