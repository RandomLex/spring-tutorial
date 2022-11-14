package com.barzykin.controllers;

import com.barzykin.model.Payment;
import com.barzykin.repositories.PaymentsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class PaymentController {

    private final PaymentsRepository repository;

    @GetMapping(value = "/payments")
    public List<Payment> getPaymentHistory() {
        return repository.getAll();
    }

    @GetMapping(value = "/payments/{id}")
    public ResponseEntity<Payment> getPayment(@PathVariable int id) {
        return ResponseEntity.of(repository.getById(id));
    }

    @PostMapping("/payments")
    public ResponseEntity<Payment> createPayment(@RequestBody Payment payment) {
        return ResponseEntity.of(repository.createPayment(payment));
    }

    @PutMapping("/payments/{id}")
    public ResponseEntity<Payment> updatePayment(@RequestBody Payment payment, @PathVariable int id) {
        return ResponseEntity.of(repository.updatePayment(payment, id));
    }

    @DeleteMapping("/payments/{id}")
    public ResponseEntity<Payment> deletePayment(@PathVariable int id) {
        return ResponseEntity.of(repository.deletePayment(id));
    }
}
