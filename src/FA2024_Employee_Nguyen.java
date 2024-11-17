//FA2024_Employee_Nguyen

public class FA2024_Employee_Nguyen{ // Variables to be input and displayed
    private double empID;
    private String empName;
    private double empPayRateHourly;
    private double empPayRateYearly;
    private double empMonthlyIncome;
    public double empFedIncomeTax;
    public double empSocialSecurityTax;
    public double empMedicareTax;
    private double empGrossPay;
    private PayType payType;

// Enumeration to determine pay type
public enum PayType{
    HOURLY,
    YEARLY
}

// Constructor
public FA2024_Employee_Nguyen(){
    this.empID = 0.0;
    this.empName = "";
    this.empPayRateHourly = 0.0;
    this.empPayRateYearly = 0.0;
    this.empMonthlyIncome = 0.0;
    this.empFedIncomeTax = 0.0;
    this.empSocialSecurityTax = 0.0;
    this.empMedicareTax = 0.0;
    this.empGrossPay = 0.0;
} // Setters and getters
    public void setPayType(PayType payType) {
        this.payType = payType;
    }

    public PayType getPayType() {
        return payType;
    }

public void setName(String empName){
    this.empName = empName;
    }

    public String getName(){
    return empName;
    }

public void setID(double empID){
    this.empID = empID;
}

public double getEmpID(){
    return empID;
}

public void setEmpPayRateHourly(double empPayRateHourly){
    this.empPayRateHourly = empPayRateHourly;
}

public double getEmpPayRateHourly(){
    return empPayRateHourly;
}

public void setEmpPayRateYearly(double empPayRateYearly){
    this.empPayRateYearly = empPayRateYearly;
}

public double getEmpPayRateYearly(){
    return empPayRateYearly;
}
// Method to calculate monthly income
public double MonthlyIncomeCalculator(double empPayRateHourly, double empPayRateYearly, PayType payType){
    switch (payType){
        case HOURLY:
            return (empPayRateHourly * 8 * 5 * 52) / 12;
        case YEARLY:
            return empPayRateYearly / 12;
        default:
            return 0.0;
    }
}
// Monthly income setter and getters
public void setEmpMonthlyIncome(PayType payType){
    this.empMonthlyIncome = MonthlyIncomeCalculator(empPayRateHourly,empPayRateYearly,payType);
}

public double getEmpMonthlyIncome(){
    return empMonthlyIncome;
}
// Method to calculate gross pay
public double EmpGrossPayCalculator(PayType payType){
    switch (payType){
        case HOURLY:
            return empPayRateHourly * 40;
        case YEARLY:
            return empPayRateYearly / 12;
            default: return 0;
    }
    }
// Gross pay setter and getter
    public void setEmpGrossPay(PayType payType){
    this.empGrossPay = EmpGrossPayCalculator(payType);
    }

    public double getEmpGrossPay(){
    return empGrossPay;
    }

    public void setEmpFedIncomeTax(PayType payType){
    this.empFedIncomeTax = empGrossPay * .0874;
    }

    public double getEmpFedIncomeTax(){
    return empFedIncomeTax;
    }

    public void setEmpSocialSecurityTax(PayType payType){
    this.empSocialSecurityTax = empGrossPay * .062;
    }

    public double getEmpSocialSecurityTax(){
    return empSocialSecurityTax;
    }

    public void setEmpMedicareTax(PayType payType){
    this.empMedicareTax = empGrossPay * .0145;
    }

    public double getEmpMedicareTax(){
    return empMedicareTax;
    }
}