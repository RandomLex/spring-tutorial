package com.barzykin.repositories;

import com.barzykin.model.Payment;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Component
public class PaymentsRepository {

    private final Map<Integer, Payment> paymentMap = new HashMap<>();
    private int lastId;

    @PostConstruct
    private void init() {
        Payment payment1 = Payment.builder()
                .id(1)
                .cardNumber("11111")
                .amount(100)
                .build();
        Payment payment2 = Payment.builder()
                .id(2)
                .cardNumber("22222")
                .amount(200)
                .build();
        paymentMap.put(1, payment1);
        paymentMap.put(2, payment2);

        lastId = 2;
    }

    public List<Payment> getAll() {
        return new ArrayList<>(paymentMap.values());
    }

    public Optional<Payment> getById(int id) {
        return Optional.ofNullable(paymentMap.get(id));
    }

    public Optional<Payment> createPayment(Payment newPayment) {
        newPayment.setId(++lastId);
        paymentMap.put(lastId, newPayment);
        return Optional.of(newPayment);
    }

    public Optional<Payment> updatePayment(Payment payment, int id) {
        if (!paymentMap.containsKey(id)) {
            return Optional.empty();
        }
        payment.setId(id);
        paymentMap.put(id, payment);
        return Optional.of(payment);
    }

    public Optional<Payment> deletePayment(int id) {
        Optional<Payment> foundPayment = getById(id);
        if (foundPayment.isPresent()) {
            paymentMap.remove(id);
        }
        return foundPayment;
    }

}
