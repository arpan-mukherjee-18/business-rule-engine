package org.arpanm18.exercise.rule;

import org.arpanm18.exercise.payment.PhysicalProductPayment;

public interface RuleEngine {
    void executeRule(PhysicalProductPayment physicalProductPayment);
}
