package com.provility.workshop;

public class EmployeeDetails {

    int emp_id;
    String emp_name;
    String joining_date;
    char desig_code;
    String dept;
    int basic;
    int hra;
    int it;


    public EmployeeDetails(int emp_id, String emp_name, String joining_date, char desig_code, String dept,
                           int basic, int hra, int it) {
        this.emp_id = emp_id;
        this.emp_name = emp_name;
        this.joining_date = joining_date;
        this.desig_code = desig_code;
        this.dept = dept;
        this.basic = basic;
        this.hra = hra;
        this.it = it;
    }

    @Override
    public String toString() {
        return "EmployeeDetails{" +
                "emp_id=" + emp_id +
                ", emp_name='" + emp_name + '\'' +
                ", joining_date='" + joining_date + '\'' +
                ", desig_code=" + desig_code +
                ", dept='" + dept + '\'' +
                ", basic=" + basic +
                ", hra=" + hra +
                ", it=" + it +
                '}';
    }

    private int calcDA(int i) {
        char designation = desig_code;
        switch(designation) {
            case 'e': return 20000;
            case 'c': return 32000;
            case 'k': return 12000;
            case 'r': return 15000;
            case 'm': return 40000;
        }
        return 0;
    }

    private char getDesigCode(int id) {
        return desig_code;
    }
    private int getIndex(int id) {
        int index = -1;
            if(id == emp_id) {
                index = id;
            }

        return index;
    }
    public String getName(int id) {
        return emp_name;
    }

    public boolean empExists(int id) {
        if(getIndex(id) != -1)
            return true;
        else
            return false;
    }

    public String getDept(int id) {
        return dept;
    }

    public String getDesignation(int id) {
        char d = getDesigCode(id);
        switch(d) {
            case 'e': return "Engineer";
            case 'c': return "Consultant";
            case 'k': return "Clerk";
            case 'r': return "Receptionist";
            case 'm': return "Manager";
        }
        return null;
    }
}
