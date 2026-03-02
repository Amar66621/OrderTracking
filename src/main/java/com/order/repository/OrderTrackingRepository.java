package com.order.repository;

import com.order.entity.OrdersTracking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface OrderTrackingRepository extends JpaRepository<OrdersTracking, Long> {

    Optional<OrdersTracking> findByOrderId(UUID orderId);



}
