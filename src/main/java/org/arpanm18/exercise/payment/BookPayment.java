package org.arpanm18.exercise.payment;

import org.arpanm18.exercise.processor.PackageSlipGenerator;
import org.arpanm18.exercise.rule.RuleEngine;

public class BookPayment extends PhysicalProductPayment implements Payments {

    private final PackageSlipGenerator packageSlipGenerator;

    public BookPayment(PackageSlipGenerator packageSlipGenerator) {
        super(packageSlipGenerator);
        this.packageSlipGenerator = packageSlipGenerator;
    }

    @Override
    public void processPayment(RuleEngine ruleEngine) {
        ruleEngine.executeRule(this);
    }

    @Override
    public void generatePackingSlip(){
        super.generatePackingSlip();
        packageSlipGenerator.generateDuplicateSlip();
    }
}
