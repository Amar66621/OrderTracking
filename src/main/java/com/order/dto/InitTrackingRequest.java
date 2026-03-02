package com.order.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class InitTrackingRequest {
    private UUID orderId;

    public UUID getOrderId() {
        return orderId;
    }

    public void setOrderId(UUID orderId) {
        this.orderId = orderId;
    }
}