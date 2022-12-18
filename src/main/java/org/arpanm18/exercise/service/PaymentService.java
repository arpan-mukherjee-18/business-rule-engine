package org.arpanm18.exercise.service;

import org.arpanm18.exercise.dto.Output;
import org.arpanm18.exercise.dto.Product;
import org.arpanm18.exercise.rule.DuplicatePackingSlipRule;
import org.arpanm18.exercise.rule.GeneratePackingSlipRule;
import org.arpanm18.exercise.rule.PaymentRule;

import java.util.Set;
import java.util.stream.Collectors;

public class PaymentService {

    private final Set<PaymentRule> paymentRules;

    public PaymentService() {
        paymentRules = Set.of(new GeneratePackingSlipRule(), new DuplicatePackingSlipRule());
    }

    public Set<Output> purchase(Product product) {
        return this.paymentRules.stream().filter(paymentRule -> paymentRule.canProcess(product))
                .map(paymentRule -> paymentRule.doProcess(product)).collect(Collectors.toSet());
    }
}
