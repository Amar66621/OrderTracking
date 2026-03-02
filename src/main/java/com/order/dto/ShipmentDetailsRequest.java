package com.order.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShipmentDetailsRequest {



        private  Long id;
        private UUID orderId;


        private String courierName;


        private String trackingNumber;

        private String trackingUrl;
    }


