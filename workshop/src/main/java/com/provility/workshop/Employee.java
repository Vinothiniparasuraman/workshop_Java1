package com.provility.workshop;

import java.util.ArrayList;
import java.util.List;

public class Employee {


    public static void main(String[] args) {
        List<EmployeeDetails> employeeDetails = new ArrayList<>();
        EmployeeDetails employee1 = new EmployeeDetails(1001, "Ashish", "01/04/09",
                'e', "R&D", 20000, 8000, 3000);

        EmployeeDetails employee2 = new EmployeeDetails(1002, "Ashish", "01/04/09",
                'e', "R&D", 20000, 8000, 3000);



        for (int i = 0; i < employeeDetails.size(); i++) {
            System.out.println(employeeDetails.get(i).toString());

        }
            if (args.length != 1) {
                System.out.println("Usage: java EmployeeManagementSystem emp_id");
            } else {
                int emp_id = Integer.parseInt(args[0]);

//                if (employeeDetails.empExists(emp_id)) {
//                    System.out.println("Emp No.    Emp Name    Department    Designation    Salary");
//                    System.out.printf("%7d    ", emp_id);
//                    System.out.printf("%8s    ", employee1.getDept(emp_id));
//                    System.out.printf("%10s    ", employeeDetails.getDept(emp_id));
//                    System.out.printf("%11s    ", employeeDetails.getDesignation(emp_id));
//                    System.out.printf("%6d\n", employeeDetails.getSalary(emp_id));
//                } else {
//                    System.out.println("There is no employee with empid: " + emp_id);
//                }
            }
        }
    }

