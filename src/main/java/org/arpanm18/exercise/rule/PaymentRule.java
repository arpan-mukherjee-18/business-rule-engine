package org.arpanm18.exercise.rule;

import org.arpanm18.exercise.dto.Output;
import org.arpanm18.exercise.dto.Product;

import java.util.Set;

public interface PaymentRule {
    boolean canProcess(Product product);
    Set<Output> doProcess(Product product);
}
