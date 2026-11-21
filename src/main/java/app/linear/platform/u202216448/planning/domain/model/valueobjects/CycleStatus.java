package app.linear.platform.u202216448.planning.domain.model.valueobjects;

/**
 * Enumeration representing the roadmap cycle status.
 *
 * <p>
 * This enumeration is used to track the lifecycle of a roadmap cycle.
 * </p>
 *
 * @author Gustavo Alonso Olivares Lao
 */
public enum CycleStatus {
    /**
     * The roadmap cycle has been planned but not yet started. It is the default status.
     */
    PLANNED,
    /**
     * The roadmap cycle is in progress.
     */
    ACTIVE,
    /**
     * The roadmap cycle has been completed.
     */
    COMPLETED,
    /**
     * The roadmap cycle has been cancelled.
     */
    CANCELLED
}
