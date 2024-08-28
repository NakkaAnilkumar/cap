package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.entity.Investment;
import com.service.InvestmentService;

@RestController
@RequestMapping("/api/investments")
public class InvestmentController {

    @Autowired
    private InvestmentService investmentService;

    @PostMapping
    public ResponseEntity<Investment> createInvestment(@RequestBody Investment investment) {
        Investment createdInvestment = investmentService.createInvestment(investment);
        return new ResponseEntity<>(createdInvestment, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Investment> getInvestmentById(@PathVariable Long id) {
        Investment investment = investmentService.getInvestmentById(id);
        if (investment != null) {
            return new ResponseEntity<>(investment, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Investment> updateInvestment(@PathVariable Long id, @RequestBody Investment investment) {
        investment.setId(id);
        Investment updatedInvestment = investmentService.updateInvestment(investment);
        if (updatedInvestment != null) {
            return new ResponseEntity<>(updatedInvestment, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInvestment(@PathVariable Long id) {
        investmentService.deleteInvestment(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
    @GetMapping("/allinvests")
    public ResponseEntity<List<Investment>> getAllInvestments() {
        List<Investment> investments = investmentService.getAllInvestments();
        if (!investments.isEmpty()) {
            return new ResponseEntity<>(investments, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
