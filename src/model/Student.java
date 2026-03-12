package model;

public class Student {

    private int id;
    private String name;
    private int age;

    private static int autoId = 1;

    public Student(String name, int age) {
        this.id = autoId;
        autoId++;
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public static int getAutoId() {
        return autoId;
    }

    public static void setAutoId(int autoId) {
        Student.autoId = autoId;
    }

    @Override
    public String toString() {
        return "Estudiante: " +
                "id = " + id + " " +
                "nombre = " + name + " " +
                "edad = " + age;

    }

}