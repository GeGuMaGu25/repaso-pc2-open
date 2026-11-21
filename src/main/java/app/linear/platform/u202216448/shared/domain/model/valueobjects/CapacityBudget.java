package app.linear.platform.u202216448.shared.domain.model.valueobjects;

import java.math.BigDecimal;

/**
 * CapacityBudget Value Object.
 *
 * <p>
 * This value object is a common type that can be used by this or other bounded contexts
 * to represent a measurable capacity budget, such as the capacity planned for a roadmap cycle.
 * It throws an IllegalArgumentException if the amount is not greater than zero or if the unit is null or blank.
 * </p>
 *
 * @param amount The amount of the budget. It must be greater than zero.
 * @param unit The unit of the budget, such as story points or hours. Cannot be null or blank.
 * @author Gustavo Alonso Olivares Lao
 */
public record CapacityBudget(BigDecimal amount, String unit) {

    /**
     * Compact constructor for CapacityBudget.
     * Validates that the amount is greater than zero and that the unit is not null or blank.
     * @throws IllegalArgumentException if the amount is null, less than or equal to zero, or if the unit is null or blank.
     */
    public CapacityBudget {
        if (amount == null || amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Capacity budget amount must be greater than zero");
        }
        if (unit == null || unit.isBlank()) {
            throw new IllegalArgumentException("Capacity budget unit cannot be null or blank");
        }
    }

    /**
     * Scales the capacity budget by a given factor, keeping the same unit.
     * @param factor The factor to multiply the amount by. It must be greater than zero.
     * @return A new {@link CapacityBudget} with the scaled amount and the same unit.
     * @throws IllegalArgumentException if the factor is null or less than or equal to zero.
     */
    public CapacityBudget scaleBy(BigDecimal factor) {
        if (factor == null || factor.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Scale factor must be greater than zero");
        }
        return new CapacityBudget(amount.multiply(factor), unit);
    }
}
