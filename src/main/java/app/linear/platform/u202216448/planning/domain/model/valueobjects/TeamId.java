package app.linear.platform.u202216448.planning.domain.model.valueobjects;

import java.util.UUID;

/**
 * TeamId Value Object.
 *
 * <p>
 * This value object represents the identifier of a team managed in another bounded context.
 * It throws an IllegalArgumentException if the value is null.
 * </p>
 *
 * @param value The team identifier. Cannot be null.
 * @author Gustavo Alonso Olivares Lao
 */
public record TeamId(UUID value) {

    /**
     * Compact constructor for TeamId.
     * Validates that the value is not null.
     * @throws IllegalArgumentException if the value is null.
     */
    public TeamId {
        if (value == null) {
            throw new IllegalArgumentException("Team id cannot be null");
        }
    }
}
