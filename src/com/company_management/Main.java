package com.company_management;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class Main {

    private static List<Employee> empList = new ArrayList<Employee>();
    private static List<Company> companyInfo = new ArrayList<Company>();

    public static void main(String[] args) throws Exception {

        empList.add(new Employee("test", 900, "test country", "test city", "test street", 5, "male", 20, 2));
        empList.add(new Employee("test name1", 2000, "test country1", "test city1", "test street1", 6, "female", 21, 30));
        empList.add(new Employee("test name2", 3000, "test country2", "Kiev", "test street2", 7, "male", 22, 10));
        empList.add(new Employee("test name3", 4000, "test country3", "Kiev", "test street3", 8, "female", 23, 50));
        empList.add(new Employee("test name4", 5000, "test country4", "test city4", "test street4", 9, "male", 24, 8));

        companyInfo.add(new Company("Test Company name", "test company country", "test company city", "test company street", 123));

        int choice;
        do {
            System.out.print("\nList of possible commands:\n" +
                    "\t1. Read about company\n" +
                    "\t2. View list of employees\n" +
                    "\t3. View employees, which work more than year.\n" +
                    "\t4. View employees, which are girls and live in Kiev\n" +
                    "\t5. Add an employee\n" +
                    "\t6. Fire an employee\n" +
                    "\t7*. Fire an employee, with salary less then 1000 and which works less then year\n" +
                    "\t8*. Change an employee information\n" +
                    "\t9*. View list of employees: first women and then men\n" +
                    "\t10*. View employees, which works between 100 and 200 hours (use Date)\n"+
                    "\t11*. Exit\n");

            Scanner input = new Scanner(System.in);
            choice = input.nextInt();

            switch (choice) {
                case 1:
                    GetCompanyInfo(companyInfo);
                    break;
                case 2:
                    GetEmployeeList(empList);
                    break;
                case 3:
                    GetExperiencedEmployee(empList);
                    break;
                case 4:
                    GetKievGirlsEmployee(empList);
                    break;
                case 5:
                    AddEmployee(empList);
                    break;
                case 6:
                    FireEmployee(empList);
                    break;
                case 7:
                    FireLoserEmployee(empList);
                    break;
                case 8:
                    ChangeEmployeeInfo(empList);
                    break;
                case 9:
                    WomenCameFirst(empList);
                case 10:
                    WorkingBetween(empList);
                    break;
                case 11:
                    System.out.print("Bye bye");
                    break;
                default:
                    System.out.println("Wrong input!!!");
            }

        } while (choice != 11);


    }

    private static void GetCompanyInfo(List<Company> companyList) {
        for (Company info : companyInfo) {
            System.out.println(info.getCompanyName() + " (" + info.getCountry() + ", " + info.getCity() + ", " + info.getStreet() + " " + info.getBuilding() + ") " + "\n Employee`s amount: " + empList.size());
            System.out.println("Employee`s: ");
            for (Employee fullList : empList) {
                System.out.println(fullList.getName());
            }
        }
    }

    private static void GetEmployeeList(List<Employee> empList){
        for (Employee fullList : empList) {
            System.out.println("Name: " + fullList.getName() + "\n" + "Salary: " + fullList.getSalary() + "\nAddress: " + fullList.getCountry() + ", " + fullList.getCity() + ", " + fullList.getStreet() + " " + fullList.getBuilding() + "\n" + "Sex: " + fullList.getSex() + "\n" + "Age: " + fullList.getAge() + "\n" + "Exprerience: " + fullList.getWorkingExperience() + " months \n");
        }
    }

    private static void GetExperiencedEmployee(List<Employee> empList){
        for (Employee fullList : empList) {
            if (fullList.getWorkingExperience() > 12) {
                System.out.println("Name: " + fullList.getName() + "\n" + "Salary: " + fullList.getSalary() + "\n" + fullList.getCountry() + ", " + fullList.getCity() + ", " + fullList.getStreet() + " " + fullList.getBuilding() + "\n" + "Sex: " + fullList.getSex() + "\n" + "Age: " + fullList.getAge() + "\n" + "Exprerience: " + fullList.getWorkingExperience() + " months \n");
            }
        }
    }

    private static void GetKievGirlsEmployee(List<Employee> empList){
        for (Employee fullList : empList) {
            if (fullList.getSex().equals("female") && fullList.getCity().equals("Kiev")) {
                System.out.println("Name: " + fullList.getName() + "\n" + "Salary: " + fullList.getSalary() + "\n" + fullList.getCountry() + ", " + fullList.getCity() + ", " + fullList.getStreet() + " " + fullList.getBuilding() + "\n" + "Sex: " + fullList.getSex() + "\n" + "Age: " + fullList.getAge() + "\n" + "Exprerience: " + fullList.getWorkingExperience() + " months \n");
            }
        }
    }

    private static void AddEmployee(List<Employee> empList){
        Scanner input = new Scanner(System.in);
        System.out.print("Employee name: ");
        String name = input.next();
        System.out.print("Employee salary: ");
        int salary = input.nextInt();
        System.out.print("Employee country: ");
        String country = input.next();
        System.out.print("Employee city: ");
        String city = input.next();
        System.out.print("Employee street: ");
        String street = input.next();
        System.out.print("Employee building: ");
        int building = input.nextInt();
        System.out.print("Employee sex: ");
        String sex = input.next();
        System.out.print("Employee age: ");
        int age = input.nextInt();
        System.out.print("Employee experience in month: ");
        int experience = input.nextInt();
        empList.add(new Employee(name, salary, country, city, street, building, sex, age, experience));

    }

    private static void FireEmployee(List<Employee> empList){
        Scanner input = new Scanner(System.in);
        System.out.print("Who should be fired(enter name): ");
        String name = input.nextLine();
        for (Employee emp : empList) {
            if (name.equals(emp.name)) {
                empList.remove(emp);
                System.out.println(name + " was fired");
            } else {
                System.out.println("Wrong name or there is no such employee in your company!!!");
            }
        }
    }

    private static void FireLoserEmployee(List<Employee> empList){
        for (Employee emp : empList) {
            if (emp.salary < 1000 && emp.workingExperience < 12) {
                System.out.println(emp.name + " was fired");
                empList.remove(emp);
            }
        }
    }

    private static void ChangeEmployeeInfo(List<Employee> empList){
        Scanner input = new Scanner(System.in);
        System.out.print("Which employee info should be changed(name): ");
        String name = input.next();
        System.out.println("What should be changed?:\n" +
                "1. Name\n" +
                "2. Salary\n" +
                "3. Address\n" +
                "4. Sex\n" +
                "5. Age\n" +
                "6. Experience");
        int choice = input.nextInt();
        switch (choice) {
            case 1:
                input.nextLine();
                System.out.print("Enter new employee name: ");
                String newName = input.nextLine();
                for (Employee emp: empList) {
                    if (emp.name.equals(name)){
                       int index = empList.indexOf(emp);
                       emp.name = newName;
                       empList.set(index, emp);
                    }
                }
            case 2:
                input.nextLine();
                System.out.print("Enter new employee salary: ");
                int newSalary = input.nextInt();
                for (Employee emp: empList) {
                    if (emp.name.equals(name)){
                        int index = empList.indexOf(emp);
                        emp.salary = newSalary;
                        empList.set(index, emp);
                    }
                }
            case 3:
                input.nextLine();
                System.out.print("Employee country: ");
                String country = input.next();
                System.out.print("Employee city: ");
                String city = input.next();
                System.out.print("Employee street: ");
                String street = input.next();
                System.out.print("Employee building: ");
                input.nextLine();
                int building = input.nextInt();
                for (Employee emp: empList) {
                    if (emp.name.equals(name)){
                        int index = empList.indexOf(emp);
                        emp.country = country;
                        emp.city = city;
                        emp.street = street;
                        emp.building = building;
                        empList.set(index, emp);
                    }
                }
            case 4:
                input.nextLine();
                System.out.print("Enter new employee sex: ");
                String newSex = input.nextLine();
                for (Employee emp: empList) {
                    if (emp.name.equals(name)){
                        int index = empList.indexOf(emp);
                        emp.sex = newSex;
                        empList.set(index, emp);
                    }
                }
            case 5:
                input.nextLine();
                System.out.print("Enter new employee age: ");
                int newAge = input.nextInt();
                for (Employee emp: empList) {
                    if (emp.name.equals(name)){
                        int index = empList.indexOf(emp);
                        emp.age = newAge;
                        empList.set(index, emp);
                    }
                }
            case 6:
                input.nextLine();
                System.out.print("Enter new employee experience(in month): ");
                int newExperiance = input.nextInt();
                for (Employee emp: empList) {
                    if (emp.name.equals(name)){
                        int index = empList.indexOf(emp);
                        emp.workingExperience = newExperiance;
                        empList.set(index, emp);
                    }
                }
            default:
                System.out.println("Wrong option!!!");
        }
    }

    private  static void WomenCameFirst(List<Employee> empList){
        empList.sort(Comparator.comparing(Employee::getSex));
        for (Employee emp: empList){
            System.out.println("Name: " + emp.getName() + "\n" + "Salary: " + emp.getSalary() + "\nAddress: " + emp.getCountry() + ", " + emp.getCity() + ", " + emp.getStreet() + " " + emp.getBuilding() + "\n" + "Sex: " + emp.getSex() + "\n" + "Age: " + emp.getAge() + "\n" + "Experience: " + emp.getWorkingExperience() + " months \n");
        }
    }

    private static void WorkingBetween(List<Employee> empList) {
        for (Employee emp: empList) {
            SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH);
            Date startDate = new Date();
            Calendar c = Calendar.getInstance();
            c.setTime(startDate);
            c.add(Calendar.MONTH,emp.workingExperience );
            Date exp = c.getTime();
            long diff = exp.getTime() - startDate.getTime();
            long hours = (diff / (1000 * 60 * 60));
            if (1000 < hours && hours < 2000 ){
                System.out.println("Name: " + emp.getName() + "\n" + "Salary: " + emp.getSalary() + "\nAddress: " + emp.getCountry() + ", " + emp.getCity() + ", " + emp.getStreet() + " " + emp.getBuilding() + "\n" + "Sex: " + emp.getSex() + "\n" + "Age: " + emp.getAge() + "\n" + "Experience: " + emp.getWorkingExperience() + " months \n");
            }
        }
    }
}