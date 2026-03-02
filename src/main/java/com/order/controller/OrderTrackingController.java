package com.order.controller;

import com.order.dto.*;
import com.order.entity.OrderStatusHistory;
import com.order.service.OrderTrackingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/order-tracking")

public class OrderTrackingController {

  //@Autowired
  //private OrderTrackingService orderTrackingService;
  //@Autowired
  //private ShipmentDetailsService shipmentDetailsService;

  private final com.order.service.OrderTrackingService orderTrackingService;
//  private final ShipmentDetailsService shipmentDetailsService;

  public OrderTrackingController(OrderTrackingService orderTrackingService) {
    this.orderTrackingService = orderTrackingService;
//    this.shipmentDetailsService = shipmentDetailsService;
  }


    @PostMapping("/init")
    public ResponseEntity<InitTrackingResponse> init(@RequestBody InitTrackingRequest request) {
        return ResponseEntity.ok(orderTrackingService.initTracking(request));
    }

    /* UPDATE STATUS */
    @PostMapping("/{orderId}/status")
    public ResponseEntity<String> updateStatus(
            @PathVariable UUID orderId,
            @RequestBody UpdateStatusRequest request) {
        orderTrackingService.updateStatus(orderId,request);
        return ResponseEntity.ok("Update Successfully");
    }

    /* GET TRACKING */
    @GetMapping("/{orderId}")
    public ResponseEntity<TrackingDetailsResponse> track(@PathVariable UUID orderId) {
        return  ResponseEntity.ok(orderTrackingService.getTracking(orderId));
    }
//  @GetMapping("/{orderId}")
//  public ResponseEntity<OrdersTracking> getCurrentOrderStatus(@PathVariable UUID orderId){
//    OrdersTracking orderStatusById=orderTrackingService .getCurrentOrderStatus(orderId);
//    return new ResponseEntity<>(orderStatusById, HttpStatus.OK);
//  }

//  @GetMapping("/{orderId}/history")
//  public ResponseEntity<List<OrderStatusHistory>> orderHistory(@PathVariable UUID orderId){
//      List<OrderStatusHistory>history = orderTrackingService.getTimeline(orderId);
//      return new ResponseEntity<>(history,HttpStatus.OK);
//  }

//  @PostMapping("/status")
//  public ResponseEntity<String> updateOrderStatus(
//           @RequestBody OrderStatusRequest request) {
//
//    orderTrackingService.updateStatus( request);
//
//    return ResponseEntity.ok("Order status updated successfully");
//  }


//  @PostMapping("/shipment")
//  public ResponseEntity<String> attachShipment(
//           @RequestBody ShipmentDetailsRequest request) {
//
//    shipmentDetailsService.attachShipmentInfo(request);
//
//    return ResponseEntity.ok("Shipment information attached successfully");
//  }
}




