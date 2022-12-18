package org.arpanm18.exercise.mock;

import org.arpanm18.exercise.constants.ProcessorConstants;
import org.arpanm18.exercise.processor.PackageSlipGenerator;

public class PackageSlipGeneratorMock implements PackageSlipGenerator {

    private String outcome;

    @Override
    public void generatePackageSlip() {
        this.outcome = ProcessorConstants.PACKING_SLIP_OUTCOME;
    }

    public String getOutcome() {
        return outcome;
    }
}
