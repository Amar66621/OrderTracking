package com.order.entity;

import com.order.enums.OrderStatus;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
@Table(
        name = "order_status_history",
        indexes = {
                @Index(name = "idx_status_history_order_id", columnList = "order_id")
        }
)
public class OrderStatusHistory {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        // Same orderId received from Order Service
        @Column(name = "order_id", nullable = false)
        private UUID orderId;

        @Enumerated(EnumType.STRING)
        @Column(name = "status", nullable = false)
        private OrderStatus status;

        // Optional but useful for tracking UI
        @Column(name = "location")
        private String location;

        @Column(name = "remarks")
        private String remarks;

        // ADMIN / SYSTEM
        @Column(name = "updated_by", nullable = false)
        private String updatedBy;

        @Column(name = "updated_at", updatable = false)
        private LocalDateTime updatedAt;

        @PrePersist
        public void onCreate() {
                this.updatedAt = LocalDateTime.now();
        }
}