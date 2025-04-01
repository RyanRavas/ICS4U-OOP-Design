import java.text.DecimalFormat;

public class BankAccount {
//  constructor
    public BankAccount(String firstName, String lastName, int accountNumber, double balance, String password) {
        // uppercase only first letter of name
        this.firstName = firstName.substring(0, 1).toUpperCase() + lastName.substring(1).toLowerCase();;
        this.lastName = lastName.substring(0, 1).toUpperCase() + lastName.substring(1).toLowerCase();;
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.password = password;
    }

    private String firstName;
    private String lastName;
    private int accountNumber;
    private double balance;
    private String password;
    private double interest = 2.8;
    private final double overdraftFee = 30;
    private int overdraftCount = 0;
//  getters and setters
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getInterest() {
        return interest;
    }

    public void setInterest(double interest) {
        this.interest = interest;
    }

    public double getOverdraftFee() {
        return overdraftFee;
    }

    public int getOverdraftCount() {
        return overdraftCount;
    }

    public void incrementOverdraftCount() {
        this.overdraftCount++;
    }

    public boolean checkPassword(String password) {
        return password.equals(this.password);
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        balance -= amount;
    }

    private void changeInterest(double interest) {
        this.interest += interest;
    }

    private String numberFormat(double num) {
        DecimalFormat df = new DecimalFormat("#.00"); // format number to two decimal places
        return df.format(num);
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", accountNumber=" + accountNumber +
                ", balance=" + balance +
                ", password='" + password + '\'' +
                ", interest=" + interest +
                ", overdraftFee=" + overdraftFee +
                ", overdraftCount=" + overdraftCount +
                '}';
    }
}