package app.linear.platform.u202216448.planning.domain.model.valueobjects;

/**
 * CycleCode Value Object.
 *
 * <p>
 * This value object represents the unique code of a roadmap cycle.
 * It throws an IllegalArgumentException if the code is null or blank.
 * </p>
 *
 * @param code The cycle code. Cannot be null or blank.
 * @author Gustavo Alonso Olivares Lao
 */
public record CycleCode(String code) {

    /**
     * Compact constructor for CycleCode.
     * Validates that the code is not null or blank.
     * @throws IllegalArgumentException if the code is null or blank.
     */
    public CycleCode {
        if (code == null || code.isBlank()) {
            throw new IllegalArgumentException("Cycle code cannot be null or blank");
        }
    }
}
