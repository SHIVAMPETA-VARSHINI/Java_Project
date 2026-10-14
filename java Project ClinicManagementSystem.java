import java.util.*;

class Person {
    String name;
    int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

class Patient extends Person {
    int id;
    String doctor;

    Patient(int id, String name, int age) {
        super(name, age);
        this.id = id;
        this.doctor = "Not Selected";
    }
    void display() {
        System.out.println("ID     : " + id);
        System.out.println("Name   : " + name);
        System.out.println("Age    : " + age);
        System.out.println("Doctor : " + doctor);
    }
}

public class ClinicManagementSystem1 {

    static Scanner sc = new Scanner(System.in);
    static ArrayList<Patient> patients = new ArrayList<>();

    public static void main(String[] args) {

        int choice;

        do {
            System.out.println("\n===== CLINIC SYSTEM =====");
            System.out.println("1. Register Patient");
            System.out.println("2. Select Doctor");
            System.out.println("3. Display Patients");
            System.out.println("4. Exit");

            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    registerPatient();
                    break;

                case 2:
                    selectDoctor();
                    break;

                case 3:
                    displayPatients();
                    break;

                case 4:
                    System.out.println("Thank you!");
                    break;

                default:
                    System.out.println("Invalid choice");
            }

        } while (choice != 4);
    }

    static void registerPatient() {

        System.out.print("Enter patient name: ");
        String name = sc.nextLine();

        System.out.print("Enter age: ");
        int age = sc.nextInt();

        int id = 1001 + patients.size();

        Patient p = new Patient(id, name, age);

        patients.add(p);

        System.out.println("Patient Registered!");
        System.out.println("Patient ID: " + id);
    }

    static void selectDoctor() {

        System.out.print("Enter patient ID: ");
        int id = sc.nextInt();

        for (Patient p : patients) {

            if (p.id == id) {

                System.out.println("1. Dr. Ravi");
                System.out.println("2. Dr. Priya");
                System.out.println("3. Dr. Kumar");

                System.out.print("Choose doctor: ");
                int choice = sc.nextInt();

                if (choice == 1)
                    p.doctor = "Dr. Ravi";

                else if (choice == 2)
                    p.doctor = "Dr. Priya";

                else if (choice == 3)
                    p.doctor = "Dr. Kumar";

                else {
                    System.out.println("Invalid choice");
                    return;
                }

                System.out.println("Doctor Selected!");
                return;
            }
        }

        System.out.println("Patient not found.");
    }

    static void displayPatients() {

        if (patients.size() == 0) {
            System.out.println("No patients.");
            return;
        }

        for (Patient p : patients) {
            System.out.println("-------------------");
            p.display();
        }
    }
}