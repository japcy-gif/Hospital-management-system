import java.util.*;

public class HospitalManagementSystem {
    static Scanner sc = new Scanner(System.in);
    static String systemUsername = "";
    static String systemPassword = "";
    static boolean isLoggedIn = false;

    static class Doctor {
        String name, specialization;
        int id;

        Doctor(int id, String name, String specialization) {
            this.id = id;
            this.name = name;
            this.specialization = specialization;
        }
    }

    static class Patient {
        String name;
        int age, id;

        Patient(int id, String name, int age) {
            this.id = id;
            this.name = name;
            this.age = age;
        }
    }

    static class Appointment {
        int appointmentId;
        int patientId;
        int doctorId;
        String date;

        Appointment(int appointmentId, int patientId, int doctorId, String date) {
            this.appointmentId = appointmentId;
            this.patientId = patientId;
            this.doctorId = doctorId;
            this.date = date;
        }
    }

    static class Symptoms {
        int patientId;
        String description;

        Symptoms(int patientId, String description) {
            this.patientId = patientId;
            this.description = description;
        }
    }

    static class Prescription {
        int patientId;
        String prescription;

        Prescription(int patientId, String prescription) {
            this.patientId = patientId;
            this.prescription = prescription;
        }
    }

    static List<Doctor> doctors = new ArrayList<>();
    static List<Patient> patients = new ArrayList<>();
    static List<Appointment> appointments = new ArrayList<>();
    static List<Symptoms> symptomsList = new ArrayList<>();
    static List<Prescription> prescriptions = new ArrayList<>();

    public static void main(String[] args) {
        int choice;

        while (true) {
            System.out.println("\n=== Hospital Management System ===");
            System.out.println("1. Sign Up");
            System.out.println("2. Login");
            System.out.println("3. Add Doctor");
            System.out.println("4. View Doctors");
            System.out.println("5. Add Patient");
            System.out.println("6. View Patients");
            System.out.println("7. Book Appointment");
            System.out.println("8. View Appointments");
            System.out.println("9. Enter Patient Symptoms");
            System.out.println("10. Doctor Prescription");
            System.out.println("11. View Prescriptions");
            System.out.println("12. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    signUp();
                    break;
                case 2:
                    login();
                    break;
                case 3:
                    addDoctor();
                    break;
                case 4:
                    viewDoctors();
                    break;
                case 5:
                    addPatient();
                    break;
                case 6:
                    viewPatients();
                    break;
                case 7:
                    bookAppointment();
                    break;
                case 8:
                    viewAppointments();
                    break;
                case 9:
                    enterSymptoms();
                    break;
                case 10:
                    doctorPrescription();
                    break;
                case 11:
                    viewPrescriptions();
                    break;
                case 12:
                    System.out.println("Exiting System. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice!");
                    break;
            }
        }
    }

    static void signUp() {
        System.out.print("Set Username: ");
        systemUsername = sc.nextLine();
        System.out.print("Set Password: ");
        systemPassword = sc.nextLine();
        System.out.println("Sign-up successful.");
    }

    static void login() {
        System.out.print("Enter Username: ");
        String username = sc.nextLine();
        System.out.print("Enter Password: ");
        String password = sc.nextLine();
        if (username.equals(systemUsername) && password.equals(systemPassword)) {
            isLoggedIn = true;
            System.out.println("Login Successful!");
        } else {
            System.out.println("Invalid credentials!");
        }
    }

    static void addDoctor() {
        if (!isLoggedIn) {
            System.out.println("Please login first.");
            return;
        }
        System.out.print("Enter Doctor ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Doctor Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Specialization: ");
        String specialization = sc.nextLine();
        doctors.add(new Doctor(id, name, specialization));
        System.out.println("Doctor added successfully.");
    }

    static void viewDoctors() {
        if (doctors.isEmpty()) {
            System.out.println("No doctors found.");
            return;
        }
        System.out.println("\n--- List of Doctors ---");
        for (Doctor d : doctors) {
            System.out.println("ID: " + d.id + ", Name: " + d.name + ", Specialization: " + d.specialization);
        }
    }

    static void addPatient() {
        if (!isLoggedIn) {
            System.out.println("Please login first.");
            return;
        }
        System.out.print("Enter Patient ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Patient Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Age: ");
        int age = sc.nextInt();
        patients.add(new Patient(id, name, age));
        System.out.println("Patient added successfully.");
    }

    static void viewPatients() {
        if (patients.isEmpty()) {
            System.out.println("No patients found.");
            return;
        }
        System.out.println("\n--- List of Patients ---");
        for (Patient p : patients) {
            System.out.println("ID: " + p.id + ", Name: " + p.name + ", Age: " + p.age);
        }
    }

    static void bookAppointment() {
        if (!isLoggedIn) {
            System.out.println("Please login first.");
            return;
        }
        System.out.print("Enter Appointment ID: ");
        int appId = sc.nextInt();
        System.out.print("Enter Patient ID: ");
        int patId = sc.nextInt();
        System.out.print("Enter Doctor ID: ");
        int docId = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Appointment Date (YYYY-MM-DD): ");
        String date = sc.nextLine();
        appointments.add(new Appointment(appId, patId, docId, date));
        System.out.println("Appointment booked successfully.");
    }

    static void viewAppointments() {
        if (appointments.isEmpty()) {
            System.out.println("No appointments found.");
            return;
        }
        System.out.println("\n--- List of Appointments ---");
        for (Appointment a : appointments) {
            System.out.println("Appointment ID: " + a.appointmentId + ", Patient ID: " + a.patientId +
                    ", Doctor ID: " + a.doctorId + ", Date: " + a.date);
        }
    }

    static void enterSymptoms() {
        System.out.print("Enter Patient ID: ");
        int patId = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Symptoms: ");
        String desc = sc.nextLine();
        symptomsList.add(new Symptoms(patId, desc));
        System.out.println("Symptoms recorded.");
    }

    static void doctorPrescription() {
        System.out.print("Enter Patient ID: ");
        int patId = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Prescription: ");
        String presc = sc.nextLine();
        prescriptions.add(new Prescription(patId, presc));
        System.out.println("Prescription added.");
    }

    static void viewPrescriptions() {
        if (prescriptions.isEmpty()) {
            System.out.println("No prescriptions available.");
            return;
        }
        System.out.println("\n--- List of Prescriptions ---");
        for (Prescription p : prescriptions) {
            System.out.println("Patient ID: " + p.patientId + ", Prescription: " + p.prescription);
        }
    }
}
