package org.arpanm18.exercise.rule;

import org.arpanm18.exercise.payment.PhysicalProductPayment;

public class PaymentRuleEngine implements RuleEngine {
    @Override
    public void executeRule(PhysicalProductPayment physicalProductPayment) {
        physicalProductPayment.generatePackingSlip();
    }
}
