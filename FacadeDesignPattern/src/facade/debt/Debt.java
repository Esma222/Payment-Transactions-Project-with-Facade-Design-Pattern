package facade.debt;

import java.math.BigDecimal;
import java.util.Date;

public class Debt {

    private long id;
    private EnumDebtType enumDebtType;
    private BigDecimal amountOfDebt;
    private Date fallDueDate;

    public Debt() {
    }

    public Debt(long id, EnumDebtType enumDebtType, BigDecimal amountOfDebt, Date fallDueDate) {
        this.id = id;
        this.enumDebtType = enumDebtType;
        this.amountOfDebt = amountOfDebt;
        this.fallDueDate = fallDueDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public EnumDebtType getEnumDebtType() {
        return enumDebtType;
    }

    public void setEnumDebtType(EnumDebtType enumDebtType) {
        this.enumDebtType = enumDebtType;
    }

    public BigDecimal getAmountOfDebt() {
        return amountOfDebt;
    }

    public void setAmountOfDebt(BigDecimal amountOfDebt) {
        this.amountOfDebt = amountOfDebt;
    }

    public Date getFallDueDate() {
        return fallDueDate;
    }

    public void setFallDueDate(Date fallDueDate) {
        this.fallDueDate = fallDueDate;
    }
}
