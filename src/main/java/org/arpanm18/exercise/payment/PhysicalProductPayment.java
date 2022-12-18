package org.arpanm18.exercise.payment;

import org.arpanm18.exercise.processor.PackageSlipGenerator;
import org.arpanm18.exercise.rule.RuleEngine;

public class PhysicalProductPayment implements Payments {
    private final PackageSlipGenerator packageSlipGenerator;

    public PhysicalProductPayment(PackageSlipGenerator packageSlipGenerator) {
        this.packageSlipGenerator = packageSlipGenerator;
    }

    @Override
    public void processPayment(RuleEngine ruleEngine) {
        ruleEngine.executeRule(this);
    }

    public void generatePackingSlip() {
        packageSlipGenerator.generatePackageSlip();
    }
}
