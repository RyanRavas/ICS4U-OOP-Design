import java.text.DecimalFormat;

public class Employee {
//  constructor
    public Employee(String firstName, String lastName, int employeeNumber, String password) {
        // uppercase only first letter of name
        this.firstName = firstName.substring(0, 1).toUpperCase() + firstName.substring(1).toLowerCase();
        this.lastName = lastName.substring(0, 1).toUpperCase() + lastName.substring(1).toLowerCase();
        this.employeeNumber = employeeNumber;
        this.password = password;
    }

    private String firstName;
    private String lastName;
    private int employeeNumber;
    private String password;
    private double totalHoursWorked;
    private double totalSalary;
    private double minimumWage = 15.50;
    private double overtimeRate = 31;
//  getters and setters
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(int employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getTotalHoursWorked() {
        return totalHoursWorked;
    }

    public void setTotalHoursWorked(double totalHoursWorked) {
        this.totalHoursWorked = totalHoursWorked;
    }

    public double getTotalSalary() {
        return totalSalary;
    }

    public void setTotalSalary(double totalSalary) {
        this.totalSalary = totalSalary;
    }

    public double getMinimumWage() {
        return minimumWage;
    }

    public void setMinimumWage(double minimumWage) {
        this.minimumWage = minimumWage;
    }

    public double getOvertimeRate() {
        return overtimeRate;
    }

    public void setOvertimeRate(double overtimeRate) {
        this.overtimeRate = overtimeRate;
    }

    public boolean checkPassword(String password) {
        return this.password.equals(password);
    }

    public double calculateSalary() {
        double overtimeHoursWorked;
        double normalWorkHours = 40;
        if (totalHoursWorked > normalWorkHours) { // if worked more than 40 hours, overtime pay calculated
            overtimeHoursWorked = totalHoursWorked - normalWorkHours;
            totalSalary = (normalWorkHours * minimumWage) + (overtimeHoursWorked * overtimeRate);
        } else { // no overtime pay
            totalSalary = totalHoursWorked * minimumWage;
        }
        return totalSalary;
    }
    private String numberFormat(double num) {
        DecimalFormat df = new DecimalFormat("#.00"); // format number to two decimal places
        return df.format(num);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", employeeNumber=" + employeeNumber +
                ", password='" + password + '\'' +
                ", totalHoursWorked=" + totalHoursWorked +
                ", totalSalary=" + totalSalary +
                ", minimumWage=" + minimumWage +
                ", overtimeRate=" + overtimeRate +
                '}';
    }
}
