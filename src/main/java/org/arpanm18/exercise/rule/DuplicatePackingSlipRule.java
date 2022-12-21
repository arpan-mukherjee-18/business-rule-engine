package org.arpanm18.exercise.rule;

import org.arpanm18.exercise.dto.Action;
import org.arpanm18.exercise.dto.Output;
import org.arpanm18.exercise.dto.Product;

import java.util.Set;

public class DuplicatePackingSlipRule implements PaymentRule {
    private final Set<Action> validActions;

    public DuplicatePackingSlipRule() {
        validActions = Set.of(Action.PURCHASE_BOOK);
    }

    @Override
    public boolean canProcess(Product product) {
        return validActions.contains(product.action());
    }

    @Override
    public Set<Output> doProcess(Product product) {
        return Set.of(new Output(Action.GENERATE_DUPLICATE_PACKING_SLIP));
    }
}
