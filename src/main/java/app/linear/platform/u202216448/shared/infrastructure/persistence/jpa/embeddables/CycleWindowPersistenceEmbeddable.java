package app.linear.platform.u202216448.shared.infrastructure.persistence.jpa.embeddables;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.time.LocalDate;

/**
 * Persistence representation for a cycle window.
 *
 * @author Gustavo Alonso Olivares Lao
 */
@Embeddable
public class CycleWindowPersistenceEmbeddable {

    @Column(name = "cycle_window_start_date")
    private LocalDate startDate;

    @Column(name = "cycle_window_end_date")
    private LocalDate endDate;

    public CycleWindowPersistenceEmbeddable() {
    }

    public CycleWindowPersistenceEmbeddable(LocalDate startDate, LocalDate endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
}
