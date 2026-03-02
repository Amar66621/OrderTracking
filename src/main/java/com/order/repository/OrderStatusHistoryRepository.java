package com.order.repository;

import com.order.entity.OrderStatusHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface OrderStatusHistoryRepository extends JpaRepository<OrderStatusHistory, Long>
{
   List <OrderStatusHistory>findByOrderIdOrderByUpdatedAtAsc(UUID orderId);

}
