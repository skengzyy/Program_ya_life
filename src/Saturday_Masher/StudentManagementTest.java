package Saturday_Masher;

/**
 * This is StudentManagementTest
 */
public class StudentManagementTest {
    public static void main(String[] args) {
        // Erstelle ein StudentManagement-Objekt
        StudentManagement management = new StudentManagement("Admin", 0, 0.0, 5);

        // Erstelle einige Student-Objekte
        Student student1 = new Student("Alice", 1, 3.5);
        Student student2 = new Student("Bob", 2, 3.8);
        Student student3 = new Student("Charlie", 3, 2.9);
        Student student4 = new Student("David", 4, 3.2);
        Student student5 = new Student("Eva", 5, 3.9);

        // Füge die Studenten hinzu
        management.enterStudent(student1);
        management.enterStudent(student2);
        management.enterStudent(student3);
        management.enterStudent(student4);
        management.enterStudent(student5);

        // Ausgabe der Student-Listen
        System.out.println(management);

        // Suche nach einem Studenten
        System.out.println("Suche nach Student mit ID 3: " + management.sucheStudent(3));
        System.out.println("Suche nach Student mit ID 6: " + management.sucheStudent(6));

        // Durchschnitts-GPA
        System.out.println("Durchschnitts-GPA: " + management.durchschnittGPA());

        // Höchste GPA
        System.out.println("Höchste GPA: " + management.hoheGPA());
    }
}
