package org.arpanm18.exercise.rule;

import org.arpanm18.exercise.dto.Action;
import org.arpanm18.exercise.dto.Output;
import org.arpanm18.exercise.dto.Product;

import java.util.Set;

public class FirstAidVideoAdditionRule implements PaymentRule{
    private final Set<Action> validActions;

    public FirstAidVideoAdditionRule() {
        validActions = Set.of(Action.LEARN_TO_SKI_VIDEO);
    }

    @Override
    public boolean canProcess(Product product) {
        return validActions.contains(product.action());
    }

    @Override
    public Set<Output> doProcess(Product product) {
        return Set.of(new Output(Action.LEARN_TO_SKI_VIDEO), new Output(Action.FIRST_AID_VIDEO));
    }
}
