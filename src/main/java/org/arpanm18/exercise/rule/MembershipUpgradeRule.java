package org.arpanm18.exercise.rule;

import org.arpanm18.exercise.dto.Action;
import org.arpanm18.exercise.dto.Output;
import org.arpanm18.exercise.dto.Product;

import java.util.Set;

public class MembershipUpgradeRule implements PaymentRule{
    private final Set<Action> validActions;

    public MembershipUpgradeRule() {
        validActions = Set.of(Action.UPGRADE_MEMBERSHIP);
    }

    @Override
    public boolean canProcess(Product product) {
        return validActions.contains(product.action());
    }

    @Override
    public Output doProcess(Product product) {
        return new Output(Action.UPGRADE_MEMBERSHIP);
    }
}
