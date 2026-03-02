package com.order.dto;

import com.order.enums.OrderStatus;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class TrackingTimelineItem {
    private OrderStatus status;
    private String location;
    private String remarks;
    private LocalDateTime time;
}
