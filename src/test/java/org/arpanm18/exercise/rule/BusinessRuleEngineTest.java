package org.arpanm18.exercise.rule;

import org.arpanm18.exercise.constants.ProcessorConstants;
import org.arpanm18.exercise.mock.PackageSlipGeneratorMock;
import org.arpanm18.exercise.payment.BookPayment;
import org.arpanm18.exercise.payment.Payments;
import org.arpanm18.exercise.payment.PhysicalProductPayment;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BusinessRuleEngineTest {

    private final RuleEngine ruleEngine = new PaymentRuleEngine();

    @Test
    void shouldGenerateAPackingSlipForShippingWhenPaymentIsForAProduct() {
        //given
        PackageSlipGeneratorMock packageSlipGenerator = new PackageSlipGeneratorMock();
        Payments payments = new PhysicalProductPayment(packageSlipGenerator);

        //when
        payments.processPayment(ruleEngine);

        //then
        assertEquals(ProcessorConstants.PACKING_SLIP_OUTCOME, packageSlipGenerator.getOutcome());
    }

    @Test
    void shouldGenerateAPackingSlipCopyForShippingWhenPaymentIsForABook() {
        //given
        PackageSlipGeneratorMock packageSlipGenerator = new PackageSlipGeneratorMock();
        Payments payments = new BookPayment(packageSlipGenerator);

        //when
        payments.processPayment(ruleEngine);

        //then
        assertEquals(ProcessorConstants.DUPLICATE_PACKING_SLIP_OUTCOME, packageSlipGenerator.getOutcome());
    }

}
