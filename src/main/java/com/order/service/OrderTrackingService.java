package com.order.service;



import com.order.dto.*;
import com.order.entity.OrderStatusHistory;
import com.order.entity.OrdersTracking;
import com.order.enums.OrderStatus;
import com.order.exceptionhandler.OrderNotFoundException;
import com.order.repository.OrderStatusHistoryRepository;
import com.order.repository.OrderTrackingRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
@Service
public class OrderTrackingService {

    //@Autowired
   // private OrderTrackingRepository orderTrackingRepository;
   // @Autowired
    //private OrderStatusHistoryRepository orderStatusHistoryRepository;
    //private final ModelMapper modelMapper;
    private  final OrderTrackingRepository orderTrackingRepository;
    private final OrderStatusHistoryRepository orderStatusHistoryRepository;
    private final ModelMapper modelMapper;


    @Transactional
    public InitTrackingResponse initTracking(InitTrackingRequest request) {

        OrdersTracking tracking = new OrdersTracking();
        tracking.setOrderId(request.getOrderId());
        tracking.setCurrentStatus(OrderStatus.PLACED);
        tracking.setEstimatedDelivery(LocalDateTime.now().plusDays(5));

        orderTrackingRepository.save(tracking);

        OrderStatusHistory history = new OrderStatusHistory();
        history.setOrderId(request.getOrderId());
        history.setStatus(OrderStatus.PLACED);
        history.setLocation("Order Created");
        history.setRemarks("Order placed");
        history.setUpdatedBy("SYSTEM");

        orderStatusHistoryRepository.save(history);

        return InitTrackingResponse.builder()
                .orderId(tracking.getOrderId())
                .currentStatus(tracking.getCurrentStatus())
                .estimatedDelivery(tracking.getEstimatedDelivery())
                .build();
    }


    @Transactional
    public void updateStatus(UUID orderId, UpdateStatusRequest request) {

        OrdersTracking tracking = orderTrackingRepository.findByOrderId(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found"));

        tracking.setCurrentStatus(request.getStatus());

        if (request.getEstimatedDelivery() != null) {
            tracking.setEstimatedDelivery(request.getEstimatedDelivery());
        }

        if (request.getStatus() == OrderStatus.DELIVERED) {
            tracking.setDeliveredAt(LocalDateTime.now());
        }

        orderTrackingRepository.save(tracking);

        OrderStatusHistory history = new OrderStatusHistory();
        history.setOrderId(orderId);
        history.setStatus(request.getStatus());
        history.setLocation(request.getLocation());
        history.setRemarks(request.getRemarks());
        history.setUpdatedBy("ADMIN");

        orderStatusHistoryRepository.save(history);
    }


    public TrackingDetailsResponse getTracking(UUID orderId) {

        OrdersTracking tracking = orderTrackingRepository.findByOrderId(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found"));

        List<TrackingTimelineItem> timeline =
                orderStatusHistoryRepository.findByOrderIdOrderByUpdatedAtAsc(orderId)
                        .stream()
                        .map(h -> TrackingTimelineItem.builder()
                                .status(h.getStatus())
                                .location(h.getLocation())
                                .remarks(h.getRemarks())
                                .time(h.getUpdatedAt())
                                .build())
                        .toList();

        return TrackingDetailsResponse.builder()
                .orderId(tracking.getOrderId())
                .currentStatus(tracking.getCurrentStatus())
                .estimatedDelivery(tracking.getEstimatedDelivery())
                .deliveredAt(tracking.getDeliveredAt())
                .timeline(timeline)
                .build();
    }
    public OrderTrackingService(OrderTrackingRepository orderTrackingRepository, OrderStatusHistoryRepository orderStatusHistoryRepository, ModelMapper modelMapper) {
        this.orderTrackingRepository = orderTrackingRepository;
        this.orderStatusHistoryRepository = orderStatusHistoryRepository;
        this.modelMapper = modelMapper;
    }


    public OrdersTracking getCurrentOrderStatus(UUID orderId) {

        return orderTrackingRepository.findByOrderId(orderId).orElseThrow(() -> new OrderNotFoundException(orderId));

    }

    public List<OrderStatusHistory> getTimeline(UUID orderId) {
        OrdersTracking tracking = orderTrackingRepository
                .findByOrderId(orderId)
                .orElseThrow(() ->
                        new OrderNotFoundException( orderId));


        return orderStatusHistoryRepository.findByOrderIdOrderByUpdatedAtAsc(orderId);
    }
   /* @Transactional
    public void updateStatus(OrderStatusRequest request) {
        orderTrackingRepository.findByOrderId(request.getOrderId());
            OrdersTracking tracking = orderTrackingRepository.findByOrderId(request.getOrderId())
                    .orElseThrow(() ->
                            new RuntimeException(
                                    "Order not found for this orderId: " + request.getOrderId()));


            if (request.getStatus().equals(tracking.getCurrentStatus())) {
                return;
            }

            tracking.setCurrentStatus(request.getStatus());
            tracking.setLastUpdatedAt(LocalDateTime.now());
            orderTrackingRepository.save(tracking);


            OrderStatusHistory history = new OrderStatusHistory();
            history.setOrderId(request.getOrderId());
            history.setStatus(request.getStatus());
            history.setRemarks(request.getRemarks());
            history.setUpdatedBy(request.getUpdatedBy());
            history.setUpdatedAt(LocalDateTime.now());

            orderStatusHistoryRepository.save(history);
        }

*/
//   @Transactional
//   public void updateStatus(OrderStatusRequest request) {
//
//       OrdersTracking tracking = orderTrackingRepository.findByOrderId(request.getOrderId())
//               .orElseThrow(() -> new OrderNotFoundException(
//                        request.getOrderId()));
//
//       if (request.getStatus().equals(tracking.getCurrentStatus())) {
//           return;
//       }
//       tracking.setCurrentStatus(request.getStatus());
//       tracking.setLastUpdatedAt(LocalDateTime.now());
//       orderTrackingRepository.save(tracking);
//       OrderStatusHistory history = modelMapper.map(request, OrderStatusHistory.class);
//       history.setUpdatedAt(LocalDateTime.now());
//
//
//       orderStatusHistoryRepository.save(history);
//   }

}




