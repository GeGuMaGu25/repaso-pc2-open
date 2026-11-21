package app.linear.platform.u202216448.shared.infrastructure.persistence.jpa.embeddables;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.math.BigDecimal;

/**
 * Persistence representation for a capacity budget.
 *
 * @author Gustavo Alonso Olivares Lao
 */
@Embeddable
public class CapacityBudgetPersistenceEmbeddable {

    @Column(name = "capacity_budget_amount")
    private BigDecimal amount;

    @Column(name = "capacity_budget_unit")
    private String unit;

    public CapacityBudgetPersistenceEmbeddable() {
    }

    public CapacityBudgetPersistenceEmbeddable(BigDecimal amount, String unit) {
        this.amount = amount;
        this.unit = unit;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }
}
