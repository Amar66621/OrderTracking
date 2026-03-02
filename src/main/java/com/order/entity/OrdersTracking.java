package com.order.entity;


import com.order.enums.OrderStatus;
import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;
import java.util.UUID;
@Data
@Entity
@Table(
        name = "orders_tracking",
        indexes = {
                @Index(name = "idx_order_tracking_order_id", columnList = "order_id")
        }
)
public class OrdersTracking {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        // Comes from Order Service
        @Column(name = "order_id", nullable = false, unique = true)
        private UUID orderId;

        @Enumerated(EnumType.STRING)
        @Column(name = "current_status", nullable = false)
        private OrderStatus currentStatus;

        // Courier details (available after SHIPPED)
        @Column(name = "shipping_partner")
        private String shippingPartner;

        @Column(name = "tracking_number")
        private String trackingNumber;

        // Expected delivery date (can change)
        @Column(name = "estimated_delivery")
        private LocalDateTime estimatedDelivery;

        // Actual delivery time
        @Column(name = "delivered_at")
        private LocalDateTime deliveredAt;

        @Column(name = "created_at", updatable = false)
        private LocalDateTime createdAt;

        @Column(name = "last_updated_at")
        private LocalDateTime lastUpdatedAt;

        @PrePersist
        public void onCreate() {
                this.createdAt = LocalDateTime.now();
                this.lastUpdatedAt = LocalDateTime.now();
        }

        @PreUpdate
        public void onUpdate() {
                this.lastUpdatedAt = LocalDateTime.now();
        }

    }





