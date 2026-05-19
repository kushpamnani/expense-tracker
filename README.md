# Expense Tracker (Java CLI Application)

## 📌 Overview
This is a simple command-line **Expense Tracker** application built in Java.  
It allows users to record expenses, view totals, analyze spending by category, and see trends over time.  
All data is stored in a local text file (`data.txt`), so no database is required.

This project was created as part of an assignment requiring:
- A simple expense tracking application  
- File-based storage  
- Total expense calculations  
- Category-based summaries  
- Expense trend analysis  
- Highest and lowest spending categories  
- A short presentation explaining the design  

---

## 📁 Project Structure
ExpenseTracker/
│
├── src/
│   ├── Expense.java
│   ├── ExpenseManager.java
│   ├── Main.java
│
├── data.txt
├── README.md
└── presentation.pdf 

---

## 🚀 How to Run the Application

### 1. Navigate to the project folder
cd ExpenseTracker

### 2. Compile the Java files
javac src/*.java

### 3. Run the program
java -cp src Main

The program will automatically create or update `data.txt` in the project root.

---

## 🧠 Features

### ✔ Add Expense  
Users can enter:
- Category  
- Amount  
- Date (YYYY-MM-DD)

### ✔ View All Expenses  
Displays every stored expense in the format:
YYYY-MM-DD | Category | $Amount

### ✔ Total Expense  
Shows the sum of all expenses recorded.

### ✔ Expense by Category  
Displays total spending for each category.

### ✔ Expense Trend  
Shows spending grouped by date in chronological order.

### ✔ Highest & Lowest Spending Category  
Identifies:
- Category with the highest total spending  
- Category with the lowest total spending  

### ✔ File-Based Storage  
All expenses are saved to `data.txt` using the format:
category,amount,date

---

## 🛠 Design & Approach

### Expense.java
Represents a single expense with:
- Category  
- Amount  
- Date (`LocalDate`)  
Includes helper methods for file serialization/deserialization.

### ExpenseManager.java
Handles:
- Adding expenses  
- Saving to file  
- Loading from file  
- Calculating totals  
- Grouping by category  
- Trend analysis  
- Highest/lowest category logic  

### Main.java
Provides the command-line menu and user interaction.

---

## 🧪 Test Data
The application uses `data.txt` in the project root.  
Example entries:

Food,12.50,2024-01-10
Travel,50.00,2024-01-11
Shopping,100.00,2024-01-12

You may modify or delete this file to reset the app.

---

## 🎤 Presentation
A short presentation explaining:
- Approach  
- Design  
- Key files  
- How to run  
- Test data  

is included in this repository as:

presentation.pdf

---

## 📎 Notes
- No database is used; all data is stored in a simple text file.
- The application is intentionally kept simple and easy to explain.
- The code is fully self-contained and runs on any system with Java installed.

---

## ✅ Assignment Requirements Checklist

| Requirement | Status |
|------------|--------|
| Add expense | ✔ |
| Total expense | ✔ |
| Total by category | ✔ |
| Expense trend | ✔ |
| Highest & lowest category | ✔ |
| File-based storage | ✔ |
| Command-line interface | ✔ |
| Presentation included | ✔ |
| GitHub repo created | ✔ |

---

## 📬 Author
Kush Pamnani  
Java Expense Tracker Project