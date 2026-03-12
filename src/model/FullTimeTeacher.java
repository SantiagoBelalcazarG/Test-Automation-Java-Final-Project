package model;

public class FullTimeTeacher extends Teacher{

    private int experience;

    public FullTimeTeacher(String name, double salary, int experience) {
        super(name, salary);
        this.experience = experience;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    @Override
    public double calculateSalary(){
        return getSalary() * (getExperience() * 1.1);
    }

    @Override
    public String toString() {
        return "Profesor de Tiempo Completo: " +
                "nombre = " + getName() + " " +
                "salario = $" + calculateSalary() + " " +
                "experiencia = " + experience;
    }

}