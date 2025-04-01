import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<BankAccount> accounts = new ArrayList<>();
        ArrayList<Employee> employees = new ArrayList<>();

        while (true) {
            System.out.println("\nBank Management System:");
            System.out.println("1. Select a bank account");
            System.out.println("2. Create a new bank account");
            System.out.println("3. Select an employee");
            System.out.println("4. Create a new employee");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1: // select an account
//                  user selects an account
                    System.out.print("Enter account number: ");
                    int accountNumber = scanner.nextInt();
//                  search for account number in arrayList
                    BankAccount selectedAccount = null;
                    for (BankAccount acc : accounts) {
                        if (acc.getAccountNumber() == accountNumber) {
                            selectedAccount = acc;
                            break;
                        }
                    }

                    if (selectedAccount == null) {
                        System.out.println("Account not found.");
                        break;
                    }
//                    verify password
                    System.out.print("Enter password: ");
                    String enteredPassword = scanner.next();
//                    if password is incorrect, restart
                    if (!selectedAccount.checkPassword(enteredPassword)) {
                        System.out.println("Incorrect password. Access denied.");
                        break;
                    }

                    while (true) {
//                        display menu
                        System.out.println("\nBank Account Menu:");
                        System.out.println("1. Deposit");
                        System.out.println("2. Withdraw");
                        System.out.println("3. Check Balance");
                        System.out.println("4. Calculate Interest Earned");
                        System.out.println("5. Back to Main Menu");
                        System.out.print("Choose an option: ");

                        int accountChoice = scanner.nextInt();

                        switch (accountChoice) {
                            case 1: // user enters amount to deposit to their account
                                System.out.print("Enter deposit amount: ");
                                double depositAmount = scanner.nextDouble();
                                selectedAccount.deposit(depositAmount);
                                System.out.printf("Deposited: $%.2f%n",depositAmount);
                                break;
                            case 2: // user enters amount to withdraw from their account
                                System.out.print("Enter withdrawal amount: ");
                                double withdrawalAmount = scanner.nextDouble();

                                if (withdrawalAmount > selectedAccount.getBalance()) {
                                    if (selectedAccount.getOverdraftCount() < 3) {
                                        selectedAccount.withdraw(withdrawalAmount + selectedAccount.getOverdraftFee());
                                        selectedAccount.incrementOverdraftCount();
                                        System.out.printf("%sOverdraft applied. Fee: $%.2f%s%n","\u001B[31m",selectedAccount.getOverdraftFee(),"\u001B[0m");
                                        System.out.printf("Withdrawn: $%.2f%n",withdrawalAmount);
                                        System.out.printf("New Balance: $%.2f%n",selectedAccount.getBalance());
                                    } else {
                                        System.out.println("Insufficient funds. Overdraft limit reached.");
                                    }
                                } else {
                                    selectedAccount.withdraw(withdrawalAmount);
                                    System.out.printf("Withdrawn: $%.2f%n", withdrawalAmount);
                                    System.out.printf("New Balance: $%.2f%n",selectedAccount.getBalance());
                                }
                                break;
                            case 3:
                                System.out.printf("Current Balance: $%.2f%n",selectedAccount.getBalance());
                                break;
                            case 4:
                                double interestEarned = selectedAccount.getBalance() * (selectedAccount.getInterest() / 100);
                                System.out.printf("Interest Earned: $%.2f%n", interestEarned);
                                break;
                            case 5:
                                break;
                            default:
                                System.out.println("Invalid option, please try again.");
                        }
                        if (accountChoice == 5) break;
                    }
                    break;
                case 2: // create new account
                    System.out.print("Enter first name: ");
                    String bankFirstName = scanner.next();
                    System.out.print("Enter last name: ");
                    String bankLastName = scanner.next();
                    System.out.print("Enter a new account number: ");
                    int newAccountNumber = scanner.nextInt();
                    System.out.print("Set a password: ");
                    String bankPassword = scanner.next();
                    System.out.print("Enter initial deposit: ");
                    double initialBalance = scanner.nextDouble();

                    BankAccount newAccount = new BankAccount(bankFirstName, bankLastName, newAccountNumber,initialBalance, bankPassword);
                    accounts.add(newAccount);

                    System.out.println("New account created successfully.");
                    break;
                case 3: // select an employee
//                  user selects an employee
                    System.out.print("Enter employee number: ");
                    int employeeNumber = scanner.nextInt();
//                  search for account number in arrayList
                    Employee selectedEmployee = null;
                    for (Employee emp : employees) {
                        if (emp.getEmployeeNumber() == employeeNumber) {
                            selectedEmployee = emp;
                            break;
                        }
                    }

                    if (selectedEmployee == null) {
                        System.out.println("Account not found.");
                        break;
                    }
//                  verify password
                    System.out.print("Enter password: ");
                    String passwordEntered = scanner.next();
//                  if password is incorrect, restart
                    if (!selectedEmployee.checkPassword(passwordEntered)) {
                        System.out.println("Incorrect password. Access denied.");
                        break;
                    }

                    while (true) {
                        System.out.println("\nEmployee Menu:");
                        System.out.println("1. Calculate Salary");
                        System.out.println("2. Get minimum wage");
                        System.out.println("3. Get overtime rate");
                        System.out.println("4. Get hours worked");
                        System.out.println("5. Set hours worked");
                        System.out.println("6. Back to Main Menu");
                        System.out.print("Choose an option: ");

                        int employeeChoice = scanner.nextInt();

                        switch (employeeChoice) {
                            case 1: // Calculate Salary
                                if (selectedEmployee.getTotalHoursWorked() <= 0) {
                                    System.out.println("No hours worked. You have not earned anything. Please enter your hours worked");
                                }
                                System.out.printf("%s %s you have earned $%.2f%n", selectedEmployee.getFirstName(), selectedEmployee.getLastName(), selectedEmployee.calculateSalary());
                                break;
                            case 2: // print minimum wage
                                System.out.printf("Your minimum wage: $%.2f%n", selectedEmployee.getMinimumWage());
                                break;
                            case 3: // print overtime rate
                                System.out.printf("Your overtime rate: %.2f%n", selectedEmployee.getOvertimeRate());
                                break;
                            case 4: // print total hours worked
                                System.out.printf("Your total hours worked is %.2f%n", selectedEmployee.getTotalHoursWorked());
                                break;
                            case 5:
                                System.out.println("How many hours have you worked?");
                                double hoursWorked = scanner.nextDouble();
                                selectedEmployee.setTotalHoursWorked(hoursWorked);
                                System.out.println("Hours logged.");
                                break;
                            case 6:
                                break;
                            default:
                                System.out.println("Invalid option, please try again.");
                        }
                        if (employeeChoice == 6) break;
                    }
                    break;
                case 4: // create new employee
                    System.out.print("Enter first name: ");
                    String employeeFirstName = scanner.next();
                    System.out.print("Enter last name: ");
                    String employeeLastName = scanner.next();
                    System.out.print("Enter your employee number: ");
                    int newEmployeeNumber = scanner.nextInt();
                    System.out.print("Set a password: ");
                    String employeePassword = scanner.next();

                    Employee newEmployee = new Employee(employeeFirstName, employeeLastName, newEmployeeNumber, employeePassword);
                    employees.add(newEmployee);

                    System.out.println("New employee created successfully.");
                    break;
                case 5: // exit
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option, please try again.");
            }
        }
    }
}