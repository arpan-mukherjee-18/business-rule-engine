package org.arpanm18.exercise.service;

import org.arpanm18.exercise.dto.Action;
import org.arpanm18.exercise.dto.Output;
import org.arpanm18.exercise.dto.Product;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PaymentServiceTest {

    private final PaymentService paymentService = new PaymentService();

    @Test
    void shouldGenerateAPackingSlipForShippingWhenPaymentIsForAPhysicalProduct(){
        //given
        Product physicalProduct = new Product(Action.PURCHASE_PHYSICAL_PRODUCT);

        //when
        Output output = paymentService.purchase(physicalProduct);

        //then
        assertEquals(Action.GENERATE_PACKING_SLIP, output.action());
    }

    @Test
    void shouldGenerateAOperationUnsupportedWhenPaymentIsForOperationUnsupported(){
        //given
        Product physicalProduct = new Product(Action.OPERATION_UNSUPPORTED);

        //when
        Output output = paymentService.purchase(physicalProduct);

        //then
        assertEquals(Action.OPERATION_UNSUPPORTED, output.action());
    }

}
