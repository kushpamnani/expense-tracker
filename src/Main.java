import java.time.LocalDate;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ExpenseManager manager = new ExpenseManager();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n==== Expense Tracker ====");
            System.out.println("1. Add Expense");
            System.out.println("2. View All Expenses");
            System.out.println("3. Total Expense");
            System.out.println("4. Expense by Category");
            System.out.println("5. Expense Trend");
            System.out.println("6. Highest & Lowest Category");
            System.out.println("7. Exit");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Category: ");
                    String category = sc.nextLine();

                    System.out.print("Amount: ");
                    double amount = sc.nextDouble();
                    sc.nextLine();

                    System.out.print("Date (YYYY-MM-DD): ");
                    LocalDate date = LocalDate.parse(sc.nextLine());

                    manager.addExpense(category, amount, date);
                    System.out.println("Expense added!");
                    break;

                case 2:
                    manager.listAllExpenses();
                    break;

                case 3:
                    System.out.println("Total: $" + manager.getTotalExpense());
                    break;

                case 4:
                    Map<String, Double> map = manager.getExpenseByCategory();
                    for (String cat : map.keySet()) {
                        System.out.println(cat + " : $" + map.get(cat));
                    }
                    break;

                case 5:
                    manager.showTrend();
                    break;

                case 6:
                    manager.showHighestAndLowestCategory();
                    break;

                case 7:
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}