package org.arpanm18.exercise.service;

import org.arpanm18.exercise.dto.Action;
import org.arpanm18.exercise.dto.Output;
import org.arpanm18.exercise.dto.Product;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertTrue;

class PaymentServiceTest {

    private final PaymentService paymentService = new PaymentService();

    @Test
    void shouldGenerateAPackingSlipForShippingWhenPaymentIsForAPhysicalProduct() {
        //given
        Product physicalProduct = new Product(Action.PURCHASE_PHYSICAL_PRODUCT);

        //when
        Set<Output> outputs = paymentService.purchase(physicalProduct);

        //then
        assertTrue(outputs.contains(new Output(Action.GENERATE_PACKING_SLIP)));
    }

    @Test
    void shouldGenerateAPackingSlipAndDuplicateSlipForShippingWhenPaymentIsForABook() {
        //given
        Product book = new Product(Action.PURCHASE_BOOK);

        //when
        Set<Output> outputs = paymentService.purchase(book);

        //then
        assertTrue(outputs.contains(new Output(Action.GENERATE_PACKING_SLIP)));
        assertTrue(outputs.contains(new Output(Action.GENERATE_DUPLICATE_PACKING_SLIP)));
    }

    @Test
    void shouldActivateMembershipForMembersWhenPaymentIsForMembershipActivation() {
        //given
        Product membershipActivation = new Product(Action.ACTIVATE_MEMBERSHIP);

        //when
        Set<Output> outputs = paymentService.purchase(membershipActivation);

        //then
        assertTrue(outputs.contains(new Output(Action.ACTIVATE_MEMBERSHIP)));
    }

    @Test
    void shouldUpgradeMembershipForMembersWhenPaymentIsForMembershipUpgrade() {
        //given
        Product membershipUpgrade = new Product(Action.UPGRADE_MEMBERSHIP);

        //when
        Set<Output> outputs = paymentService.purchase(membershipUpgrade);

        //then
        assertTrue(outputs.contains(new Output(Action.UPGRADE_MEMBERSHIP)));
    }


    @Test
    void shouldSendEmailForMembersWhenPaymentIsForMembershipActivationOrUpgrade() {
        //given
        Product membershipActivation = new Product(Action.ACTIVATE_MEMBERSHIP);
        Product membershipUpgrade = new Product(Action.UPGRADE_MEMBERSHIP);


        //when
        Set<Output> activationOutputs = paymentService.purchase(membershipActivation);
        Set<Output> upgradeOutputs = paymentService.purchase(membershipUpgrade);

        //then
        assertTrue(activationOutputs.contains(new Output(Action.SEND_EMAIL_NOTIFICATIONS)));
        assertTrue(upgradeOutputs.contains(new Output(Action.SEND_EMAIL_NOTIFICATIONS)));
    }


}
