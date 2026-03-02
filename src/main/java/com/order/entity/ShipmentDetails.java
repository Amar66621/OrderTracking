package com.order.entity;

import jakarta.persistence.*;
import lombok.Data;


import java.time.LocalDateTime;
import java.util.UUID;
@Data
@Entity
@Table(name = "shipment_details")
public class ShipmentDetails
{
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private UUID orderId;
        private String courierName;
        private String trackingNumber;
        private String trackingUrl;

        private LocalDateTime shippedAt;
        private LocalDateTime deliveredAt;


        public Long getId() {
                return id;
        }

        public void setId(Long id) {
                this.id = id;
        }

        public UUID getOrderId() {
                return orderId;
        }

        public void setOrderId(UUID orderId) {
                this.orderId = orderId;
        }

        public String getCourierName() {
                return courierName;
        }

        public void setCourierName(String courierName) {
                this.courierName = courierName;
        }

        public String getTrackingNumber() {
                return trackingNumber;
        }

        public void setTrackingNumber(String trackingNumber) {
                this.trackingNumber = trackingNumber;
        }

        public String getTrackingUrl() {
                return trackingUrl;
        }

        public void setTrackingUrl(String trackingUrl) {
                this.trackingUrl = trackingUrl;
        }

        public LocalDateTime getShippedAt() {
                return shippedAt;
        }

        public void setShippedAt(LocalDateTime shippedAt) {
                this.shippedAt = shippedAt;
        }

        public LocalDateTime getDeliveredAt() {
                return deliveredAt;
        }

        public void setDeliveredAt(LocalDateTime deliveredAt) {
                this.deliveredAt = deliveredAt;
        }

            }


