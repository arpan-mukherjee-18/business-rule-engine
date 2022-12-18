package org.arpanm18.exercise.service;

import org.arpanm18.exercise.dto.Action;
import org.arpanm18.exercise.dto.Output;
import org.arpanm18.exercise.dto.Product;
import org.arpanm18.exercise.rule.GeneratePackingSlipRule;
import org.arpanm18.exercise.rule.PaymentRule;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

public class PaymentService {

    private final Set<PaymentRule> paymentRules;

    public PaymentService() {
        Set<PaymentRule> rules = new LinkedHashSet<>();
        rules.add(new GeneratePackingSlipRule());
        paymentRules = Collections.unmodifiableSet(rules);
    }


    public Output purchase(Product product) {
        return this.paymentRules.stream().filter(paymentRule -> paymentRule.canProcess(product))
                .map(paymentRule -> paymentRule.doProcess(product)).findFirst().orElse(new Output(Action.OPERATION_UNSUPPORTED));
    }
}
