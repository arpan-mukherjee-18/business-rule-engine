package org.arpanm18.exercise.service;

import org.arpanm18.exercise.dto.Action;
import org.arpanm18.exercise.dto.Output;
import org.arpanm18.exercise.dto.Product;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class PaymentServiceTest {

    private final PaymentService paymentService = new PaymentService();

    @Test
    void shouldGenerateAPackingSlipForShippingWhenPaymentIsForAPhysicalProduct(){
        //given
        Product physicalProduct = new Product(Action.PURCHASE_PHYSICAL_PRODUCT);

        //when
        Set<Output> outputs = paymentService.purchase(physicalProduct);

        //then
        assertTrue(outputs.contains(new Output(Action.GENERATE_PACKING_SLIP)));
    }

    @Test
    void shouldGenerateAPackingSlipAndDuplicateSlipForShippingWhenPaymentIsForABook(){
        //given
        Product physicalProduct = new Product(Action.PURCHASE_BOOK);

        //when
        Set<Output>  outputs = paymentService.purchase(physicalProduct);

        //then
        assertTrue(outputs.contains(new Output(Action.GENERATE_PACKING_SLIP)));
        assertTrue(outputs.contains(new Output(Action.GENERATE_DUPLICATE_PACKING_SLIP)));
    }

}
