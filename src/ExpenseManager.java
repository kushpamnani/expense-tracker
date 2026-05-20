import java.io.*;
import java.time.LocalDate;
import java.util.*;

public class ExpenseManager {
    private List<Expense> expenses = new ArrayList<>();
    private final String FILE_NAME = "data.txt";

    public ExpenseManager() {
        loadFromFile();
    }

    public void addExpense(String category, double amount, LocalDate date) {
        Expense expense = new Expense(category, amount, date);
        expenses.add(expense);
        saveToFile(expense);
    }

    private void saveToFile(Expense expense) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            bw.write(expense.toFileString());
            bw.newLine();
        } catch (IOException e) {
            System.out.println("Error saving data.");
        }
    }

    private void loadFromFile() {
        File file = new File(FILE_NAME);
        if (!file.exists()) return;

        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = br.readLine()) != null) {
                expenses.add(Expense.fromFileString(line));
            }
        } catch (IOException e) {
            System.out.println("Error loading data.");
        }
    }

    private void saveAllExpenses() {
    try (BufferedWriter writer = new BufferedWriter(new FileWriter("data.txt"))) {
        for (Expense e : expenses) {
            writer.write(e.getCategory() + "," + e.getAmount() + "," + e.getDate());
            writer.newLine();
        }
    } catch (IOException e) {
        System.out.println("Error saving file.");
    }
}


    public double getTotalExpense() {
        double total = 0;
        for (Expense e : expenses) {
            total += e.getAmount();
        }
        return total;
    }

    public Map<String, Double> getExpenseByCategory() {
        Map<String, Double> map = new HashMap<>();

        for (Expense e : expenses) {
            map.put(
                e.getCategory(),
                map.getOrDefault(e.getCategory(), 0.0) + e.getAmount()
            );
        }

        return map;
    }

    public void showTrend() {
        Map<LocalDate, Double> trend = new TreeMap<>();

        for (Expense e : expenses) {
            trend.put(
                e.getDate(),
                trend.getOrDefault(e.getDate(), 0.0) + e.getAmount()
            );
        }

        for (LocalDate date : trend.keySet()) {
            System.out.println(date + " : " + trend.get(date));
        }
    }

    public void showHighestAndLowestCategory() {
        Map<String, Double> map = getExpenseByCategory();

        if (map.isEmpty()) {
            System.out.println("No data.");
            return;
        }

        String maxCat = null, minCat = null;
        double max = Double.MIN_VALUE, min = Double.MAX_VALUE;

        for (String cat : map.keySet()) {
            double val = map.get(cat);

            if (val > max) {
                max = val;
                maxCat = cat;
            }

            if (val < min) {
                min = val;
                minCat = cat;
            }
        }

        System.out.println("Highest: " + maxCat + " = " + max);
        System.out.println("Lowest: " + minCat + " = " + min);
    }

    public void listAllExpenses() {
        for (Expense e : expenses) {
            System.out.println(e.getDate() + " | " + e.getCategory() + " | $" + e.getAmount());
        }
    }
}
