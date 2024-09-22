package Saturday_Masher;

import java.util.Arrays;

/**
 * This is StudentManagement
 * @author Isaac Jerryson
 * @version 24.05.2024
 */
public class StudentManagement extends Student{
    private Student[] students;

    public StudentManagement(String name, int studentId, double gpa, int studentAnzahl){
        super(name, studentId, gpa);
    }

    public boolean enterStudent(Student student){
        if(student != null) {
            for (int i = 0; i < students.length; i++) {
                if (students[i] == null) {
                    students[i] = student;
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public boolean sucheStudent(int id){
        for (Student student : students) {
            if (student != null) {
                if (id == student.getStudentId()) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();
        builder.append("Student-Listen: \n\n");
        for(Student student : students){
            if (student != null) {
                builder.append(student.toString()).append("\n");
            }
        }
        return builder.toString();
    }

    public double durchschnittGPA(){
        double summe = 0;
        for(Student student : students){
            if(student != null){
                summe += student.getGpa();
            }
        }
        return summe / students.length;
    }

    public double hoheGPA(){
        int hoeher = 0;
        for(int i = 1;i < students.length;i++){
            if(students[i].getGpa() > students[hoeher].getGpa()){
                hoeher = i;
            }
        }
        return hoeher;
    }


}
