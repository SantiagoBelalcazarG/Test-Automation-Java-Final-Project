package model;

import java.util.ArrayList;

public class University {

    private ArrayList<Teacher> teachers;
    private ArrayList<Student> students;
    private ArrayList<Course> courses;

    public University() {
        this.teachers = new ArrayList<>();
        this.students = new ArrayList<>();
        this.courses = new ArrayList<>();
    }

    public ArrayList<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(ArrayList<Teacher> teachers) {
        this.teachers = teachers;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public void setCourses(ArrayList<Course> courses) {
        this.courses = courses;
    }

    public Student searchStudentById(int id){
        for (Student s : students){
            if (id == s.getId()){
                return s;
            }
        }
        return null;
    }

    public Course searchCourseByName(String name){
        for (Course c : courses){
            if (name.equalsIgnoreCase(c.getName())){
                return c;
            }
        }
        return null;
    }

    public Teacher searchTeacherByName(String name){
        for (Teacher t : teachers){
            if (name.equalsIgnoreCase(t.getName())){
                return t;
            }
        }
        return null;
    }

    public ArrayList<Course> searchStudentCoursesById(int id){
        ArrayList<Course> coursesResult = new ArrayList<>();

        for (Course c : courses){
            if (c.hasStudent(id)){
                coursesResult.add(c);
            }
        }
        return coursesResult;
    }

    public void createStudent(int id, String name, int age){
        Student student = new Student(id, name, age);
        students.add(student);
    }

    public void createCourse(String name, int classroom, Teacher teacher){
        if (searchCourseByName(name) == null){
            Course course = new Course(name, classroom, teacher);
            courses.add(course);
        }
    }

    public void createFullTimeTeacher(String name, double salary, int experience){
        if (searchTeacherByName(name) == null){
            Teacher teacher = new FullTimeTeacher(name, salary, experience);
            teachers.add(teacher);
        }
    }

    public void createPartTimeTeacher(String name, double salary, int activeHours){
        if (searchTeacherByName(name) == null){
            Teacher teacher = new PartTimeTeacher(name, salary, activeHours);
            teachers.add(teacher);
        }
    }

    public void addStudentToCourse(int studentId, String courseName){
        Student student = searchStudentById(studentId);
        Course course = searchCourseByName(courseName);

        if (student != null && course != null){
            course.addStudent(student);
        }
    }
}