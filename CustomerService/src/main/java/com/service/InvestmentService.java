package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.entity.Investment;
import com.repository.InvestmentRepository;

@Service
public class InvestmentService {

    @Autowired
    private InvestmentRepository investmentRepository;

    @Transactional
    public Investment createInvestment(Investment investment) {
        return investmentRepository.save(investment);
    }

    public Investment getInvestmentById(Long id) {
        return investmentRepository.findById(id).orElse(null);
    }

    @Transactional
    public Investment updateInvestment(Investment investment) {
        if (investmentRepository.existsById(investment.getId())) {
            return investmentRepository.save(investment);
        }
        return null;
    }

    @Transactional
    public void deleteInvestment(Long id) {
        investmentRepository.deleteById(id);
    }
    public List<Investment> getAllInvestments() {
        return investmentRepository.findAll();
    }
}

