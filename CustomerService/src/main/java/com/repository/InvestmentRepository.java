package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entity.Investment;

@Repository
public interface InvestmentRepository extends JpaRepository<Investment, Long> {
    // You can add custom queries here if needed
}
