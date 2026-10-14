package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.example.demo.entity.SportReservation;

public interface SportReservationRepository extends JpaRepository<SportReservation, Long> {
    List<SportReservation> findBySubCategory(String subCategory,Pageable pageable);
    Page<SportReservation> findBySubCategoryContaining(String keyword, Pageable pageable);
    @Query("SELECT DISTINCT s.subCategory FROM SportReservation s WHERE s.subCategory IS NOT NULL")
    List<String> findDistinctSubCategory();
}
