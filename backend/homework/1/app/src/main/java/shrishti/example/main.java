package shrishti.example;
//import shrishti.example.studentRepository;
//import shrishti.example.student;
import java.util.Scanner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class main {
    public static void main(String[] args) {
        Logger log= LoggerFactory.getLogger(logger.class);
        Scanner scanner = new Scanner(System.in);
        studentRepository repo = new studentRepository();

        boolean running=true;

        while(running){
            System.out.println("Select an option");
            System.out.println("1: Add a student");
            System.out.println("2: Retrieve student data by ID");
            System.out.println("3: Retrieve Student by Name");
            System.out.println("4: Update the student information");
            System.out.println("0: to exit the system");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addStudent(repo,scanner);
                    break;
                case 2:
                    retrieveStudentById(repo,scanner);
                    break;
                case 3:
                    retrieveStudentByName(repo,scanner);
                    break;
                case 4:
                    updateStudentData(repo,scanner);
                    break;
                case 0:
                    System.out.println("Turning off!");
                    running=false;
            }
        }
    }

        public static void addStudent(studentRepository repo, Scanner scanner){
            student st = new student();
            System.out.println("Give student details:");
            System.out.print("id: ");
            st.setId(scanner.nextInt());

            System.out.print("name: ");
            st.setName(scanner.next());

            System.out.print("age: ");
            st.setAge(scanner.nextInt());

            System.out.print("grade: ");
            st.setGrade(scanner.next().charAt(0));
            repo.addStudent(st);
        }


        public static void retrieveStudentById(studentRepository repo, Scanner scanner){
            System.out.println("Enter id of the user : ");
            int id= scanner.nextInt();
            student student = repo.retrieve(id);
            repo.printStudent(student);

        }
        private static void retrieveStudentByName(studentRepository repo, Scanner scanner) {
            System.out.println("Enter the name of student to be retrieved: ");
            String name=scanner.next().toLowerCase();
            student student = repo.retrieve(name);
            repo.printStudent(student);
        }
    private static void updateStudentData(studentRepository repo, Scanner scanner) {
        System.out.print("Enter student ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter the new name:");
        String name = scanner.nextLine();

        System.out.print("Enter new age: ");
        int age = scanner.nextInt();

        System.out.print("Enter new grade: ");
        char grade = scanner.next().charAt(0);
        student st =new student();
        st.setGrade(grade);
        st.setId(id);
        st.setAge(age);
        st.setName(name);
        repo.update(st,id);
    }

    }

