package com.order.dto;

import com.order.enums.OrderStatus;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@Builder
public class TrackingDetailsResponse {
    private UUID orderId;
    private OrderStatus currentStatus;
    private LocalDateTime estimatedDelivery;
    private LocalDateTime deliveredAt;
    private List<TrackingTimelineItem> timeline;
}
