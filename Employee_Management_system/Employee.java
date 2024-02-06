package Assignment;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Employee {
    int empNo;
    String empName;
    Date joinDate;
    char desigCode;
    String department;
    double basic;
    double hra;
    double it;

    public Employee(int empNo, String empName, String joinDate, char desigCode, String department, double basic, double hra, double it) throws ParseException, ParseException {
        this.empNo = empNo;
        this.empName = empName;
        this.joinDate = new SimpleDateFormat("dd/MM/yyyy").parse(joinDate);
        this.desigCode = desigCode;
        this.department = department;
        this.basic = basic;
        this.hra = hra;
        this.it = it;
    }

    public double calculateSalary() {
        double da = getDA();
        return basic + hra + da - it;
    }

    public String getDesignation() {
        switch (desigCode) {
            case 'e':
                return "Engineer";
            case 'c':
                return "Consultant";
            case 'k':
                return "Clerk";
            case 'r':
                return "Receptionist";
            case 'm':
                return "Manager";
            default:
                return "Unknown";
        }
    }

    private double getDA() {
        switch (desigCode) {
            case 'e':
                return 20000;
            case 'c':
                return 32000;
            case 'k':
                return 12000;
            case 'r':
                return 15000;
            case 'm':
                return 40000;
            default:
                return 0;
        }
    }


}