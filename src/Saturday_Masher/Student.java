package Saturday_Masher;
/**
 * This is Student
 * @author Isaac Jerryson
 * @version 24.05.2024
 */
public class Student {
    private String name;
    private int studentId;
    private double gpa;

    public Student(String name, int studentId, double gpa) {
        setName(name);
        setStudentId(studentId);
        setGpa(gpa);
    }

    public Student() {
        setName("Student");
        setStudentId(0);
        setGpa(0.0);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        if(gpa >= 0.0) this.gpa = gpa;
    }

    public void neuStudent(){
        new Student();
    }

    @Override
    public String toString(){
        return "Student-Daten\n\n Name: "+ getName() +"\n Id: "+ getStudentId() +"\n GPA: "+ getGpa();
    }
}
