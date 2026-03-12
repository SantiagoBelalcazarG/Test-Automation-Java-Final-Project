import java.util.ArrayList;

public class Course {

    private String name;
    private int classroom;
    private ArrayList<Student> students;
    private Teacher teacher;

    public Course(String name, int classroom, Teacher teacher) {
        this.name = name;
        this.classroom = classroom;
        this.students = new ArrayList<>();
        this.teacher = teacher;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getClassroom() {
        return classroom;
    }

    public void setClassroom(int classroom) {
        this.classroom = classroom;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public boolean hasStudent(int id){
        for (Student s : students) {
            if (id == s.getId()){
                return true;
            }
        }
        return false;
    }

    public void addStudent(Student student){
        if (!hasStudent(student.getId())){
            students.add(student);
        }
    }

    @Override
    public String toString() {
        return "Clase: \n" +
                "nombre = " + name + "\n" +
                "salon = " + classroom + "\n" +
                "estudiantes = " + students.toString() + "\n" +
                "profesor = " + teacher;

    }

}