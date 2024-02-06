package Assignment;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Project1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int empNo = sc.nextInt() ;
//        if (args.length == 0) {
//            System.out.println("Usage: java Project1 <EmpNo>");
//            return;
//        }
//        int empNo = Integer.parseInt(args[0]);
        Employee[] employees = new Employee[7];

        try {
            employees[0] = new Employee(1001, "Ashish", "01/04/2009", 'e', "R&D", 20000, 8000, 3000);
            employees[1] = new Employee(1002, "Shashi", "23/08/2012", 'c', "PM", 30000, 12000, 9000);
            employees[2] = new Employee(1003, "Rahul", "12/11/2008", 'k', "Acct", 10000, 8000, 1000);
            employees[3] = new Employee(1004, "Chahat", "29/01/2013", 'r', "Front Desk", 12000, 6000, 2000);
            employees[4] = new Employee(1005, "Ranjan", "16/07/2005", 'm', "Engg", 50000, 20000, 20000);
            employees[5] = new Employee(1006, "Suman", "01/01/2000", 'e', "Manufacturing", 23000, 9000, 4400);
            employees[6] = new Employee(1007, "Tanmay", "12/06/2006", 'c', "PM", 29000, 12000, 10000);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        boolean found = false;
        for (Employee employee : employees) {
            if (employee != null && employee.empNo == empNo) {
                found = true;
                System.out.println("Emp No.\tEmp Name\tDepartment\tDesignation\tSalary");
                System.out.println(employee.empNo + "\t" + employee.empName + "\t" + employee.department + "\t" + employee.getDesignation() + "\t" + employee.calculateSalary());
                break;
            }
        }

        if (!found) {
            System.out.println("There is no employee with empid : " + empNo);
        }
    }






}