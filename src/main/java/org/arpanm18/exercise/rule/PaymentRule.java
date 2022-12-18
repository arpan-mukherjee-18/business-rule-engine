package org.arpanm18.exercise.rule;

import org.arpanm18.exercise.dto.Output;
import org.arpanm18.exercise.dto.Product;

public interface PaymentRule {
    boolean canProcess(Product product);
    Output doProcess(Product product);
}
