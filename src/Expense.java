import java.time.LocalDate;

public class Expense {
    private String category;
    private double amount;
    private LocalDate date;

    public Expense(String category, double amount, LocalDate date) {
        this.category = category;
        this.amount = amount;
        this.date = date;
    }

    public String getCategory() {
        return category;
    }

    public double getAmount() {
        return amount;
    }

    public LocalDate getDate() {
        return date;
    }

    // Convert to string for file storage
    public String toFileString() {
        return category + "," + amount + "," + date;
    }

    // Convert from file string
    public static Expense fromFileString(String line) {
        String[] parts = line.split(",");
        return new Expense(
                parts[0],
                Double.parseDouble(parts[1]),
                LocalDate.parse(parts[2])
        );
    }
}