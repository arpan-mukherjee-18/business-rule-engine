package org.arpanm18.exercise.service;

import org.arpanm18.exercise.dto.Output;
import org.arpanm18.exercise.dto.Product;
import org.arpanm18.exercise.rule.*;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

public class PaymentService {

    private final Set<PaymentRule> paymentRules;

    public PaymentService() {
        paymentRules = Set.of(new GeneratePackingSlipRule(), new DuplicatePackingSlipRule(), new MembershipActivationRule(), new MembershipUpgradeRule());
    }

    public Set<Output> purchase(Product product) {
        return this.paymentRules.stream().filter(paymentRule -> paymentRule.canProcess(product))
                .map(paymentRule -> paymentRule.doProcess(product)).flatMap(Collection::stream).collect(Collectors.toSet());
    }
}
