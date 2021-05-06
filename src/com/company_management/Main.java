package com.company_management;

import java.text.SimpleDateFormat;
import java.util.*;

public class Main {

    private static final List<Employee> empList = new ArrayList<>();
    private static final List<Company> companyInfo = new ArrayList<>();

    public static void main(String[] args) {

        empList.add(new Employee("test", 900, "test country", "test city", "test street", 5, "male", 20, 2));
        empList.add(new Employee("test name1", 2000, "test country1", "test city1", "test street1", 6, "female", 21, 30));
        empList.add(new Employee("test name2", 3000, "test country2", "Kiev", "test street2", 7, "male", 22, 10));
        empList.add(new Employee("test name3", 4000, "test country3", "Kiev", "test street3", 8, "female", 23, 50));
        empList.add(new Employee("test name4", 5000, "test country4", "test city4", "test street4", 9, "male", 24, 8));

        companyInfo.add(new Company("Something Inc", "Ukraine", "Kiev", "Shevchenka street", 123));

        int choice;
        do {
            MainMenu();
            Scanner input = new Scanner(System.in);
            choice = input.nextInt();

            switch (choice) {
                case 1:
                    GetCompanyInfo();
                    PressEnterToContinue();
                    break;
                case 2:
                    GetEmployeeList();
                    PressEnterToContinue();
                    break;
                case 3:
                    GetExperiencedEmployee();
                    PressEnterToContinue();
                    break;
                case 4:
                    GetKievGirlsEmployee();
                    PressEnterToContinue();
                    break;
                case 5:
                    AddEmployee();
                    PressEnterToContinue();
                    break;
                case 6:
                    FireEmployee();
                    PressEnterToContinue();
                    break;
                case 7:
                    FireLoserEmployee();
                    PressEnterToContinue();
                    break;
                case 8:
                    ChangeEmployeeInfo();
                    PressEnterToContinue();
                    break;
                case 9:
                    WomenCameFirst();
                    PressEnterToContinue();
                case 10:
                    WorkingBetween();
                    PressEnterToContinue();
                    break;
                case 11:
                    System.out.print("Bye bye");
                    break;
                default:
                    System.out.println("Wrong input!!!");
            }

        } while (choice != 11);


    }

    private static void GetCompanyInfo() {
        String companyTableFormat = "| %-20s | %-10s | %-10s | %-15s | %-8d |";

        System.out.format("+----------------------+------------+------------+-------------------+----------+%n");
        System.out.format("| Company Name         | Country    | City       | Street            | Building |%n");
        System.out.format("+----------------------+------------+------------+-------------------+----------+%n");
        for (Company info : Main.companyInfo) {
            System.out.format(companyTableFormat, info.getCompanyName(), info.getCountry(), info.getCity(), info.getStreet(), info.getBuilding(), empList.size());
            System.out.format("\n+----------------------+------------+------------+-------------------+----------+%n");
        }
        String employeeTableFormat = "| %-50s |";
        System.out.format("+----------------------------------------------------+%n");
        System.out.format("| Employee`s of our company                          |%n");
        System.out.format("+----------------------------------------------------+%n");

        for (Employee fullList : empList) {
            System.out.format(employeeTableFormat, fullList.getName());
            System.out.format("\n+----------------------------------------------------+%n");
        }
    }

    private static void GetEmployeeList(){
        String employeeTableFormat = "| %-50s | %-45s | %-7s | %-5d | %-20d |";
        System.out.format("+----------------------------------------------------+-----------------------------------------------+---------+-------+----------------------+%n");
        System.out.format("| Employee`s name                                    | Address                                       | Sex     | Age   | Experience(in month) |%n");
        System.out.format("+----------------------------------------------------+-----------------------------------------------+---------+-------+----------------------+%n");
        for (Employee fullList : Main.empList) {
            System.out.format(employeeTableFormat, fullList.name, fullList.country + ", " + fullList.city + ", " + fullList.street + ", " + fullList.building, fullList.sex, fullList.age, fullList.workingExperience);
            System.out.format("\n-----------------------------------------------------+-----------------------------------------------+---------+-------+----------------------+%n");
        }
    }

    private static void GetExperiencedEmployee(){
        String employeeTableFormat = "| %-50s | %-45s | %-7s | %-5d | %-20d |";
        System.out.format("+----------------------------------------------------+-----------------------------------------------+---------+-------+----------------------+%n");
        System.out.format("| Employee`s name                                    | Address                                       | Sex     | Age   | Experience(in month) |%n");
        System.out.format("+----------------------------------------------------+-----------------------------------------------+---------+-------+----------------------+%n");
        for (Employee fullList : Main.empList) {
            if (fullList.getWorkingExperience() > 12) {
                System.out.format(employeeTableFormat, fullList.name, fullList.country + ", " + fullList.city + ", " + fullList.street + ", " + fullList.building, fullList.sex, fullList.age, fullList.workingExperience);
                System.out.format("\n-----------------------------------------------------+-----------------------------------------------+---------+-------+----------------------+%n");

            }
        }
    }

    private static void GetKievGirlsEmployee(){
        String employeeTableFormat = "| %-50s | %-45s | %-7s | %-5d | %-20d |";
        System.out.format("+----------------------------------------------------+-----------------------------------------------+---------+-------+----------------------+%n");
        System.out.format("| Employee`s name                                    | Address                                       | Sex     | Age   | Experience(in month) |%n");
        System.out.format("+----------------------------------------------------+-----------------------------------------------+---------+-------+----------------------+%n");
        for (Employee fullList : Main.empList) {
            if (fullList.getSex().equals("female") && fullList.getCity().equals("Kiev")) {
                System.out.format(employeeTableFormat, fullList.name, fullList.country + ", " + fullList.city + ", " + fullList.street + ", " + fullList.building, fullList.sex, fullList.age, fullList.workingExperience);
                System.out.format("\n-----------------------------------------------------+-----------------------------------------------+---------+-------+----------------------+%n");
            }
        }
    }

    private static void AddEmployee(){
        Scanner input = new Scanner(System.in);
        System.out.print("Employee name: ");
        String name="";
        name+=input.nextLine();
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
        Main.empList.add(new Employee(name, salary, country, city, street, building, sex, age, experience));
        System.out.println("\nEmployee: " + name + " was added");
    }

    private static void FireEmployee(){
        Scanner input = new Scanner(System.in);
        System.out.print("Who should be fired(enter name): ");
        String name = input.nextLine();
        boolean result = Main.empList.removeIf(emp -> name.equals(emp.name));
        if (result){
            System.out.println("Employee " + name + " was fired");
        }else {
            System.out.println("Something went wrong. Please check name and try again!");
        }
    }

    private static void FireLoserEmployee(){
        boolean result = Main.empList.removeIf(emp -> emp.getSalary()< 1000 && emp.getWorkingExperience() < 12);
        if (result){
            System.out.println("Done!");
        }else {
            System.out.println("No one was fired!");
        }
        }

    private static void ChangeEmployeeInfo(){

        int choice;

        do {
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

            choice = input.nextInt();

                switch (choice) {
                    case 1:
                        input.nextLine();
                        System.out.print("Enter new employee name: ");
                        String newName="";
                        newName+=input.nextLine();
                        for (Employee emp: Main.empList) {
                            if (emp.name.equals(name)){
                                int index = Main.empList.indexOf(emp);
                                emp.name = newName;
                                Main.empList.set(index, emp);
                                System.out.println("Done!");
                            }
                        }
                        break;
                    case 2:
                        input.nextLine();
                        System.out.print("Enter new employee salary: ");
                        int newSalary = input.nextInt();
                        for (Employee emp: Main.empList) {
                            if (emp.name.equals(name)){
                                int index = Main.empList.indexOf(emp);
                                emp.salary = newSalary;
                                Main.empList.set(index, emp);
                                System.out.println("Done!");
                            }
                        }
                        break;
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
                        for (Employee emp: Main.empList) {
                            if (emp.name.equals(name)){
                                int index = Main.empList.indexOf(emp);
                                emp.country = country;
                                emp.city = city;
                                emp.street = street;
                                emp.building = building;
                                Main.empList.set(index, emp);
                                System.out.println("Done!");
                            }
                        }
                        break;
                    case 4:
                        input.nextLine();
                        System.out.print("Enter new employee sex: ");
                        String newSex = input.nextLine();
                        for (Employee emp: Main.empList) {
                            if (emp.name.equals(name)){
                                int index = Main.empList.indexOf(emp);
                                emp.sex = newSex;
                                Main.empList.set(index, emp);
                                System.out.println("Done!");
                            }
                        }
                        break;
                    case 5:
                        input.nextLine();
                        System.out.print("Enter new employee age: ");
                        int newAge = input.nextInt();
                        for (Employee emp: Main.empList) {
                            if (emp.name.equals(name)){
                                int index = Main.empList.indexOf(emp);
                                emp.age = newAge;
                                Main.empList.set(index, emp);
                                System.out.println("Done!");
                            }
                        }
                        break;
                    case 6:
                        input.nextLine();
                        System.out.print("Enter new employee experience(in month): ");
                        int newExperience = input.nextInt();
                        for (Employee emp: Main.empList) {
                            if (emp.name.equals(name)){
                                int index = Main.empList.indexOf(emp);
                                emp.workingExperience = newExperience;
                                Main.empList.set(index, emp);
                                System.out.println("Done!");
                            }
                        }
                        break;
                    case 7:
                        break;
                    default:
                        System.out.println("Wrong option!!!");
                }
        }while (choice == 7);
    }

    private  static void WomenCameFirst(){
        String employeeTableFormat = "| %-50s | %-45s | %-7s | %-5d | %-20d |";
        System.out.format("+----------------------------------------------------+-----------------------------------------------+---------+-------+----------------------+%n");
        System.out.format("| Employee`s name                                    | Address                                       | Sex     | Age   | Experience(in month) |%n");
        System.out.format("+----------------------------------------------------+-----------------------------------------------+---------+-------+----------------------+%n");
        Main.empList.sort(Comparator.comparing(Employee::getSex));
        for (Employee emp: Main.empList){
            System.out.format(employeeTableFormat, emp.name, emp.country + ", " + emp.city + ", " + emp.street + ", " + emp.building, emp.sex, emp.age, emp.workingExperience);
            System.out.format("\n-----------------------------------------------------+-----------------------------------------------+---------+-------+----------------------+%n");
        }
    }

    private static void WorkingBetween() {
        String employeeTableFormat = "| %-50s | %-45s | %-7s | %-5d | %-20d |";
        System.out.format("+----------------------------------------------------+-----------------------------------------------+---------+-------+----------------------+%n");
        System.out.format("| Employee`s name                                    | Address                                       | Sex     | Age   | Experience(in month) |%n");
        System.out.format("+----------------------------------------------------+-----------------------------------------------+---------+-------+----------------------+%n");
        for (Employee emp: Main.empList) {
            SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH);
            Date startDate = new Date();
            Calendar c = Calendar.getInstance();
            c.setTime(startDate);
            c.add(Calendar.MONTH,emp.workingExperience );
            Date exp = c.getTime();
            long diff = exp.getTime() - startDate.getTime();
            long hours = (diff / (1000 * 60 * 60));
            if (1000 < hours && hours < 2000 ){
                System.out.format(employeeTableFormat, emp.name, emp.country + ", " + emp.city + ", " + emp.street + ", " + emp.building, emp.sex, emp.age, emp.workingExperience);
                System.out.format("\n-----------------------------------------------------+-----------------------------------------------+---------+-------+----------------------+%n");
            }
        }
    }

    private static void MainMenu(){
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
    }

    public static void PressEnterToContinue(){
        System.out.println("\nPress \"ENTER\" to go back to the main menu..");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }

}