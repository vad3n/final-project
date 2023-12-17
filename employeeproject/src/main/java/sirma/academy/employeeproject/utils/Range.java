package sirma.academy.employeeproject.utils;

import java.time.LocalDate;

public class Range {
    private LocalDate startDate;
    private LocalDate endDate;

    public Range(LocalDate starDate, LocalDate endDate) {
        this.startDate = starDate;
        this.endDate  = endDate;
    }

    public LocalDate getStartDate() {
        return this.startDate;
    }

    public LocalDate getEndDate() {
        return this.endDate;
    }
}
