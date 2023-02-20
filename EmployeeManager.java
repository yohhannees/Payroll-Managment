import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.*;



public class EmployeeManager {

    private static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    // Map to store admin login credentials
    private static final Map<String, String> adminLoginCredentials = new HashMap<>();

    // Map to store receptionist login credentials
    private static final Map<String, String> EmployeeLoginCredentials = new HashMap<>();

    // private static final String[] hotelCheckInData = null;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<EmpDetail> listt = new ArrayList<EmpDetail>();
        Scanner sc = new Scanner(System.in);

        clearScreen();

        // Initialize admin login credentials
        adminLoginCredentials.put("admin", "password");

        while (true) {
            System.out.println("Welcome to the Salary Management System!");
            System.out.println("1. Admin Login");
            System.out.println("2. Employee Login");
            System.out.println("3. Add New Admin");
            System.out.println("4. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Admin Username: ");
                    String adminUsername = scanner.nextLine();
                    System.out.print("Enter Admin Password: ");
                    String adminPassword = scanner.nextLine();

                    if (adminLoginCredentials.containsKey(adminUsername) &&
                            adminLoginCredentials.get(adminUsername).equals(adminPassword)) {
                        // Admin logged in successfully
                        clearScreen();
                        System.out.println("Admin Login Successful!");
                        System.out.println("");
                        System.out.println("");
                        System.out.println("");

                        while (true) {
                            
                            System.out.println("1. Add New Employee");
                            System.out.println("2. Show All Employees");
                            System.out.println("3. Register Employee Data");
                            System.out.println("4. Show All  Employees Data");
                            System.out.println("5. Save to Database");
                            System.out.println("6. Read from Database");
                            System.out.println("7. Logout");

                            int adminChoice = scanner.nextInt();
                            scanner.nextLine();

                            switch (adminChoice) {
                                case 1:
                                    System.out.print("Enter New Employee Username: ");
                                    String newEmployeeUsername = scanner.nextLine();
                                    System.out.print("Enter New Employee Password: ");
                                    String newEmployeePassword = scanner.nextLine();

                                    // Check if new receptionist already exists
                                    if (EmployeeLoginCredentials.containsKey(newEmployeeUsername)) {
                                        System.out.println("Employee Username Already Exists!");
                                        System.out.println("");
                                        System.out.println("");

                                    } else {
                                        // Add new receptionist to the map
                                        EmployeeLoginCredentials.put(newEmployeeUsername,
                                                newEmployeePassword);
                                        clearScreen();
                                        System.out.println("New Employee Added Successfully!");
                                        System.out.println("");
                                        System.out.println("");
                                    }

                                    break;

                                case 2:
                                    // Show all registered receptionists
                                    clearScreen();
                                    System.out.println("Registered Employees:");
                                    System.out.println("");
                                     int x=1;
                                    for (String username : EmployeeLoginCredentials.keySet()) {
                                        System.out.println("====="+x+"----" + username + "=====");
                                        System.out.println("");
                                        x++;
                                    }

                                    break;

                                case 3:
                                  
                                    System.out.println("Enter Employee ID: ");
                                    int id = sc.nextInt();
                                    System.out.println("Enter Employee Name: ");
                                    String name = sc.next();
                                    System.out.println("Enter Employee Age: ");
                                    int age = sc.nextInt();
                                    System.out.println("Enter Employee Salary: ");
                                    int salary = sc.nextInt();

                                    listt.add(new EmpDetail(id, name, age, salary));
                                    clearScreen();
                                    System.out.println("Data Successfully Entered");
                                    break;
                                
                               case 4:
                                    clearScreen();
                                    {     int y=1;
                                  
                                        for (EmpDetail employeeData : listt) {
                                            System.out.println("====="+"Employee " +"----" +y+"=====");
                                            System.out.println("Employee ID: " + employeeData.getId());
                                            System.out.println("Employee Name: " + employeeData.getName());
                                            System.out.println("Employee Age: " + employeeData.getAge());
                                            System.out.println("Employee Salary: " + employeeData.getSalary());
                                            System.out.println("==================================");
                                            y++;
                                            // Add any other getter methods you want to use here
                                        }
                                        System.out.println("");
                                        System.out.println("");
                                        System.out.println("");
                                    }
                                    
                                    break;
                                
                                case 5:
                                    clearScreen();{
                                    System.out.println("Enter File Name to Write the Objects: ");
                                    String File_Name = sc.next();
                                    try {
                                        FileOutputStream fname = new FileOutputStream(File_Name);
                                        ObjectOutputStream Oname = new ObjectOutputStream(fname);
                                        Oname.writeObject(listt);
                                        Oname.close();
                                        fname.close();
                                        System.out.println("Data Has Been Stored In File");
                                    } catch (IOException ioe) {
                                        ioe.printStackTrace();
                                    }
                                   
                                }

                                case 6:
                                    clearScreen();
                                    {
                                    ArrayList<EmpDetail> emp = new ArrayList<>();
                                    System.out.println("Enter File Name to Read Employee Data: ");
                                    String File_Name = sc.next();
                                    try {
                                        FileInputStream finput = new FileInputStream(File_Name);
                                        ObjectInputStream Oinput = new ObjectInputStream(finput);

                                        emp = (ArrayList) Oinput.readObject();

                                        Oinput.close();
                                        finput.close();
                                    } catch (IOException ioe) {
                                        ioe.printStackTrace();
                                        return;
                                    } catch (ClassNotFoundException c) {
                                        System.out.println("Class not found");
                                        c.printStackTrace();
                                        return;
                                    }
                                    for (EmpDetail employee : emp) {
                                        System.out.println(employee);
                                    }
                                }
                                case 7:
                                    clearScreen();
                                    System.out.println("Admin Logged Out Successfully.");
                                    System.out.println("");
                                    System.out.println("");

                                    break;

                                default:
                                    System.out.println("Invalid Choice. Please Try Again.");
                                    System.out.println("");
                                    System.out.println("");
                                    break;
                            }

                            if (adminChoice == 7) {
                                break;
                            }
                        }

                    } else {
                        clearScreen();
                        System.out.println("Invalid Admin Username or Password!");

                    }

                    break;

                case 2:
                    System.out.print("Enter Receptionist Username: ");
                    String EmployeeUsername = scanner.nextLine();
                    System.out.print("Enter Receptionist Password: ");
                    String EmployeePassword = scanner.nextLine();

                    if (EmployeeLoginCredentials.containsKey(EmployeeUsername) &&
                            EmployeeLoginCredentials.get(EmployeeUsername).equals(EmployeePassword)) {
                        // Receptionist logged in successfully
                        clearScreen();
                        System.out.println("");
                        System.out.println("");

                        System.out.println("Receptionist Login Successful!");
                        System.out.println("");
                        System.out.println("");

                        while (true) {
                            System.out.println("1. View Your Data");
                            System.out.println("2. Logout");

                            int choicee = scanner.nextInt();
                            scanner.nextLine();

                            switch (choicee) {

                                case 1:

                                  
                                        // Add any other getter methods you want to use here
                                        System.out.println(
                                                "Please enter the your name :");
                                        String searchQuery = scanner.nextLine();
                                        boolean found = false;
                                        for (EmpDetail employeeData : listt) {
                                            if (employeeData.getName().equals(searchQuery)) {
                                                System.out.println("Employee ID: " + employeeData.getId());
                                                System.out.println("Employee Name: " + employeeData.getName());
                                                System.out.println("Employee Age: " + employeeData.getAge());
                                                System.out.println("Employee Salary: " + employeeData.getSalary());
                                                        
                                                // Add any other getter methods you want to use here
                                                found = true;
                                            }
                                            
                                        }
                                        if (!found) {
                                            System.out.println("No employee with the given name or ID found.");
                                        }
                                        break;

                                   

                              
                               

                                case 2:
                                    clearScreen();
                                    System.out.println(" Logged Out Successfully.");
                                    System.out.println("");
                                    System.out.println("");
                                    break;

                                default:
                                    System.out.println("Invalid Choice. Please Try Again.");
                                    break;
                            }

                            if (choicee == 2) {
                                break;
                            }
                        }
                        // Receptionist functionality goes here

                    } else {
                        clearScreen();
                        System.out.println("Invalid Receptionist Username or Password!");
                        System.out.println("");
                        System.out.println("");

                    }

                    break;

                case 3:
                    System.out.print("Enter New Admin Username: ");
                    String newAdminUsername = scanner.nextLine();
                    System.out.print("Enter New Admin Password: ");
                    String newAdminPassword = scanner.nextLine();
                    if (adminLoginCredentials.containsKey(newAdminUsername)) {
                        System.out.println("Admin Username Already Exists!");
                    } else {
                        // Add new admin to the map
                        adminLoginCredentials.put(newAdminUsername, newAdminPassword);
                        clearScreen();
                        System.out.println("New Admin Added Successfully!");
                        System.out.println("");
                        System.out.println("");
                        System.out.println("");

                    }

                    break;

                case 4:
                    clearScreen();
                    System.out.println("Thank you for using the Hotel Management System!");
                    System.out.println("");
                    System.out.println("");
                    return;

                default:
                    System.out.println("Invalid Choice. Please Try Again.");
                    break;
            }
        }
    }
}