package org.arpanm18.exercise.rule;

import org.arpanm18.exercise.dto.Action;
import org.arpanm18.exercise.dto.Output;
import org.arpanm18.exercise.dto.Product;

import java.util.Set;

public class MembershipActivationRule implements PaymentRule {
    private final Set<Action> validActions;

    public MembershipActivationRule() {
        validActions = Set.of(Action.ACTIVATE_MEMBERSHIP);
    }

    @Override
    public boolean canProcess(Product product) {
        return validActions.contains(product.action());
    }

    @Override
    public Set<Output> doProcess(Product product) {
        return Set.of(new Output(Action.ACTIVATE_MEMBERSHIP), new Output(Action.SEND_EMAIL_NOTIFICATIONS));
    }
}
