package com.example.demo.dto;

import java.math.BigDecimal;
import lombok.Data;
import lombok.ToString;
import java.io.Serializable;

public record CartItem(
        String serviceId,
        String serviceName,
        String placeName,
        String subCategory,
        String serviceStatus,
        String serviceUrl) implements Serializable {
}