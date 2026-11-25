import java.util.Scanner;

public class EmployeeSalaryAnalyzer {

    static Scanner sc = new Scanner(System.in);

    static int[] id = new int[100];
    static String[] name = new String[100];
    static double[] salary = new double[100];
    static int count = 0;

    static void addEmployee() {
        System.out.print("Enter Employee ID: ");
        id[count] = sc.nextInt();

        System.out.print("Enter Employee Name: ");
        name[count] = sc.next();

        System.out.print("Enter Salary: ");
        salary[count] = sc.nextDouble();

        count++;
        System.out.println("Employee Added Successfully!");
    }

    static void displayEmployees() {
        if (count == 0) {
            System.out.println("No Employees Found!");
            return;
        }

        System.out.println("\nID\tName\tSalary");

        for (int i = 0; i < count; i++) {
            System.out.println(id[i] + "\t" + name[i] + "\t" + salary[i]);
        }
    }

    static void searchEmployee() {
        System.out.print("Enter Employee ID to Search: ");
        int key = sc.nextInt();

        for (int i = 0; i < count; i++) {
            if (id[i] == key) {
                System.out.println("Employee Found!");
                System.out.println("Name: " + name[i]);
                System.out.println("Salary: " + salary[i]);
                return;
            }
        }

        System.out.println("Employee Not Found!");
    }

    static void sortSalary() {
        for (int i = 0; i < count - 1; i++) {
            for (int j = 0; j < count - i - 1; j++) {
                if (salary[j] < salary[j + 1]) {

                    double temp = salary[j];
                    salary[j] = salary[j + 1];
                    salary[j + 1] = temp;

                    int tempId = id[j];
                    id[j] = id[j + 1];
                    id[j + 1] = tempId;

                    String tempName = name[j];
                    name[j] = name[j + 1];
                    name[j + 1] = tempName;
                }
            }
        }

        System.out.println("Employees Sorted by Highest Salary!");
        displayEmployees();
    }

    static void salaryAnalysis() {
        if (count == 0) {
            System.out.println("No Employees Found!");
            return;
        }

        double total = 0;
        double highest = salary[0];
        double lowest = salary[0];

        for (int i = 0; i < count; i++) {
            total += salary[i];

            if (salary[i] > highest)
                highest = salary[i];

            if (salary[i] < lowest)
                lowest = salary[i];
        }

        System.out.println("Highest Salary: " + highest);
        System.out.println("Lowest Salary: " + lowest);
        System.out.println("Average Salary: " + total / count);
    }

    public static void main(String[] args) {

        int choice;

        do {
            System.out.println("\n===== EMPLOYEE SALARY ANALYZER =====");
            System.out.println("1. Add Employee");
            System.out.println("2. Display Employees");
            System.out.println("3. Search Employee");
            System.out.println("4. Sort by Salary");
            System.out.println("5. Salary Analysis");
            System.out.println("6. Exit");

            System.out.print("Enter Choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    if (count < 100)
                        addEmployee();
                    else
                        System.out.println("Employee Limit Reached!");
                    break;

                case 2:
                    displayEmployees();
                    break;

                case 3:
                    searchEmployee();
                    break;

                case 4:
                    sortSalary();
                    break;

                case 5:
                    salaryAnalysis();
                    break;

                case 6:
                    System.out.println("Thank You!");
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }

        } while (choice != 6);
    }
}