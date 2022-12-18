package org.arpanm18.exercise.rule;

import org.arpanm18.exercise.dto.Action;
import org.arpanm18.exercise.dto.Output;
import org.arpanm18.exercise.dto.Product;

public class GeneratePackingSlipRule implements PaymentRule {
    @Override
    public boolean canProcess(Product product) {
        return Action.PURCHASE_PHYSICAL_PRODUCT.equals(product.action());
    }

    @Override
    public Output doProcess(Product product) {
        return new Output(Action.GENERATE_PACKING_SLIP);
    }
}
