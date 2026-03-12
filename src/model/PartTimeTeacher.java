package model;

public class PartTimeTeacher extends Teacher{

    private int activeHours;

    public PartTimeTeacher(String name, double salary, int activeHours) {
        super(name, salary);
        this.activeHours = activeHours;
    }

    public int getActiveHours() {
        return activeHours;
    }

    public void setActiveHours(int activeHours) {
        this.activeHours = activeHours;
    }

    @Override
    public double calculateSalary(){
        return getSalary() * getActiveHours();
    }

    @Override
    public String toString() {
        return "Profesor de Tiempo Parcial:  " +
                "nombre = " + getName() + " " +
                "salario = $" + calculateSalary() + " " +
                "horas semanales = " + activeHours;
    }

}