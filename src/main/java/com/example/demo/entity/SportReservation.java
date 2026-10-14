package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Data;
@Data
@Entity
@Table(name = "sports_reservation")
@Getter
@NoArgsConstructor
public class SportReservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "service_type")
    private String serviceType;

    @Column(name = "service_id")
    private String serviceId;

    private String category;

    @Column(name = "sub_category")
    private String subCategory;

    @Column(name = "service_status")
    private String serviceStatus;

    @Column(name = "target_audience")
    private String targetAudience;

    @Column(name = "service_url")
    private String serviceUrl;

    @Column(name = "service_name")
    private String serviceName;

    @Column(name = "place_name")
    private String placeName;
    @Column(name="longitude")
    private Double longitude;
    @Column(name="latitude")
    private Double latitude;
    @Column(name="region")
    private String region;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "detail_info", columnDefinition = "Text")
    private String detailInfo;
    @Column(name="phone")
    private String phone;

}
