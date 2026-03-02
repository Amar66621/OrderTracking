//package com.example.ordertracking.service;
//
//import com.example.ordertracking.dto.ShipmentDetailsRequest;
//import com.example.ordertracking.entity.OrderStatusHistory;
//import com.example.ordertracking.entity.OrdersTracking;
//import com.example.ordertracking.entity.ShipmentDetails;
//import com.example.ordertracking.enums.OrderStatus;
//import com.example.ordertracking.exceptionhandler.OrderNotFoundException;
//import com.example.ordertracking.repository.OrderStatusHistoryRepository;
//import com.example.ordertracking.repository.OrderTrackingRepository;
//import com.example.ordertracking.repository.ShipmentDetailsRepository;
//import jakarta.persistence.EntityNotFoundException;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.time.LocalDateTime;
//@Service
//public class ShipmentDetailsService {
//    @Autowired
//    private OrderTrackingRepository orderTrackingRepository;
//    @Autowired
//    private ShipmentDetailsRepository shipmentDetailsRepository;
//    @Autowired
//    private OrderStatusHistoryRepository orderStatusHistoryRepository;
//
//    public void attachShipmentInfo(ShipmentDetailsRequest request) {
//
//    OrdersTracking tracking = orderTrackingRepository
//            .findByOrderId(request.getOrderId())
//            .orElseThrow(() ->
//                    new OrderNotFoundException(
//                            request.getOrderId()));
//
//    ShipmentDetails shipment = new ShipmentDetails();
//        shipment.setOrderId(request.getOrderId());
//        shipment.setCourierName(request.getCourierName());
//        shipment.setTrackingNumber(request.getTrackingNumber());
//        shipment.setTrackingUrl(request.getTrackingUrl());
//        shipment.setShippedAt(LocalDateTime.now());
//        shipment.setDeliveredAt(LocalDateTime.now());
//        OrderStatus status = OrderStatus.SHIPPED;
//
//        shipmentDetailsRepository.save(shipment);
//
//        tracking.setCurrentStatus(status);
//        tracking.setLastUpdatedAt(LocalDateTime.now());
//        orderTrackingRepository.save(tracking);
//
//
//    OrderStatusHistory history = new OrderStatusHistory();
//
//        history.setOrderId(request.getOrderId());
//        history.setStatus(status);
//        history.setRemarks("Shipment attached");
//        history.setUpdatedBy("SHIPPING_SERVICE");
//        history.setUpdatedAt(LocalDateTime.now());
//
//        orderStatusHistoryRepository.save(history);
//
//
//}
//}
