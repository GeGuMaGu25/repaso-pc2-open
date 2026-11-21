package app.linear.platform.u202216448.shared.domain.model.valueobjects;

import java.time.LocalDate;

/**
 * CycleWindow Value Object.
 *
 * <p>
 * This value object is a common type that can be used by this or other bounded contexts
 * to represent a bounded period of time, such as the dates of a roadmap cycle.
 * It throws an IllegalArgumentException if a date is null or if the end date is not after the start date.
 * </p>
 *
 * @param startDate The start date of the window. Cannot be null.
 * @param endDate The end date of the window. Cannot be null and must be after the start date.
 * @author Gustavo Alonso Olivares Lao
 */
public record CycleWindow(LocalDate startDate, LocalDate endDate) {

    /**
     * Compact constructor for CycleWindow.
     * Validates that both dates are not null and that the end date is after the start date.
     * @throws IllegalArgumentException if a date is null or if the end date is before or equal to the start date.
     */
    public CycleWindow {
        if (startDate == null) {
            throw new IllegalArgumentException("Cycle window start date cannot be null");
        }
        if (endDate == null) {
            throw new IllegalArgumentException("Cycle window end date cannot be null");
        }
        if (!endDate.isAfter(startDate)) {
            throw new IllegalArgumentException("Cycle window end date must be after the start date");
        }
    }

    /**
     * Checks whether the cycle window is active on a given date.
     * @param targetDate The date to check.
     * @return true if the target date is not before the start date and not after the end date, false otherwise.
     */
    public boolean isActiveOn(LocalDate targetDate) {
        if (targetDate == null) return false;
        return !targetDate.isBefore(startDate) && !targetDate.isAfter(endDate);
    }
}
