//FA2024_SalaryOfEmployee

import java.util.Scanner;

public class FA2024_SalaryOfEmployee_Nguyen {
    private FA2024_Employee_Nguyen employee;
    private FA2024_Employee_Nguyen.PayType payType;
    private boolean isEmployeeInitialized = false;

    public FA2024_SalaryOfEmployee_Nguyen() {
        this.employee = new FA2024_Employee_Nguyen(); // Create new object
    }
    // Method to display monthly income
    public void DisplayMonthlyIncome(FA2024_Employee_Nguyen employee) {
        Scanner scanner = new Scanner(System.in);
        String stringFormat = "%-15s%25s%n";
        String decimalFormat = "%-15s%25.2f%n";
        System.out.println("EMPLOYEE INFORMATION - " + employee.getEmpID());
        System.out.println("---------------------------------------");
        System.out.printf(stringFormat, "Employee ID", employee.getEmpID());
        System.out.printf(stringFormat, "Employee Name: ", employee.getName());
        switch(payType) {
            case HOURLY:
                System.out.printf(decimalFormat, "Hourly Pay Rate: ", employee.getEmpPayRateHourly());
                break;
            case YEARLY:
                System.out.printf(decimalFormat, "Yearly Pay Rate: ", employee.getEmpPayRateYearly());
                break;
        }
        System.out.println("---------------------------------------");
        System.out.printf(decimalFormat, "Income in Month:", employee.getEmpMonthlyIncome());
    }

    public void EnterEmpInfo(FA2024_Employee_Nguyen employee) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter employee ID: ");
        employee.setID(scanner.nextDouble());
        scanner.nextLine();
        System.out.print("Enter employee name: ");
        employee.setName(scanner.nextLine());
        System.out.print("Are you paid hourly or yearly? Enter HOURLY or YEARLY: ");
        String payTypeInput = scanner.nextLine();
        this.payType = FA2024_Employee_Nguyen.PayType.valueOf(payTypeInput);

// Switch statements gets input based on payment method
        switch(payType) {
            case HOURLY:
                System.out.print("Enter hourly rate: ");  // Added prompt
                employee.setEmpPayRateHourly(scanner.nextDouble());
                break;
            case YEARLY:
                System.out.print("Enter yearly salary: ");  // Added prompt
                employee.setEmpPayRateYearly(scanner.nextDouble());
                break;
        }
        employee.setEmpMonthlyIncome(payType);
        employee.setEmpGrossPay(payType);
    }
    // Display info
    public void DisplayPayStub(FA2024_Employee_Nguyen employee) {
        String stringFormat = "%-15s%25s%n";
        String decimalFormat = "%-15s%25.2f%n";
        System.out.println("EMPLOYEE INFORMATION - " + employee.getEmpID());
        System.out.println("---------------------------------------");
        System.out.printf(stringFormat, "Employee ID:", employee.getEmpID());
        System.out.printf(stringFormat, "Employee Name: ", employee.getName());
        switch(payType) {
            case HOURLY:
                System.out.printf(decimalFormat, "Hourly Pay Rate:", employee.getEmpPayRateHourly());
                System.out.println("---------------------------------------");
                System.out.println("          WEEKLY PAYCHECK STUB");
                break;
            case YEARLY:
                System.out.printf(decimalFormat, "Yearly Pay Rate: ", employee.getEmpPayRateYearly());
                System.out.println("---------------------------------------");
                System.out.println("          MONTHLY PAYCHECK STUB");
                break;
        }
        employee.setEmpGrossPay(payType);
        employee.setEmpFedIncomeTax(payType);
        employee.setEmpSocialSecurityTax(payType);
        employee.setEmpMedicareTax(payType);

        System.out.println("---------------------------------------");
        System.out.printf(decimalFormat, "Gross Pay: ", employee.getEmpGrossPay());
        System.out.printf("%-15s%21.2f%n", "Federal Income Tax:", employee.getEmpFedIncomeTax());
        System.out.printf("%-15s%20.2f%n", "Social Security Tax:", employee.getEmpSocialSecurityTax());
        System.out.printf(decimalFormat, "Medicare Tax: ", employee.getEmpMedicareTax());
        System.out.println("---------------------------------------");
        System.out.printf(decimalFormat, "Net Pay: ", employee.getEmpGrossPay() -
                (employee.empFedIncomeTax + employee.empSocialSecurityTax + employee.empMedicareTax));
    }
    // Output main menu
    public void MainMenu() {
        while (true) {
            System.out.println("MAIN MENU - DUSTIN NGUYEN");
            System.out.println("---------------------------------------");
            System.out.println("Type a number to select a task to continue:");
            System.out.println("1. Read and Display Information of Employee.");
            System.out.println("2. Month Income");
            System.out.println("3. Print a Salary Pay Stub");
            System.out.println("0. Exit.");
            Scanner scanner = new Scanner(System.in);
            String choice = scanner.nextLine();
// Switch statement to determine if info has been input first before outputting
            switch (choice) {
                case "1":
                    EnterEmpInfo(employee); // Runs method to get employee info
                    isEmployeeInitialized = true;
                    break;
                case "2":
                    if (isEmployeeInitialized) { // Runs method to print inputted info
                        DisplayMonthlyIncome(employee);
                    } else {
                        System.out.println("Enter Employee Info First");
                    }
                    break;
                case "3":
                    if (isEmployeeInitialized) { // Runs method to print paystub based on inputs
                        DisplayPayStub(employee);
                    } else {
                        System.out.println("Enter Employee Info First");
                    }
                    break;
                case "0":
                    System.exit(0);
                default:
                    System.out.println("Invalid choice.");
                    break;
            }
        }
    }

    public static void main(String[] args) {
        FA2024_SalaryOfEmployee_Nguyen salaryCalculator = new FA2024_SalaryOfEmployee_Nguyen();
        salaryCalculator.MainMenu();
    }
}