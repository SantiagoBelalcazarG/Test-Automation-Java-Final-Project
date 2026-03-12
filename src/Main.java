import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        University university = new University();

        university.createFullTimeTeacher("Andres", 10000000, 5);
        university.createFullTimeTeacher("Ricardo", 8000000, 2);
        university.createPartTimeTeacher("Daniel", 5000000, 10);
        university.createPartTimeTeacher("Juan", 6000000, 15);

        university.createStudent(1, "Santiago", 22);
        university.createStudent(2, "Luis", 21);
        university.createStudent(3, "Darwin", 21);
        university.createStudent(4, "Kevin", 21);
        university.createStudent(5, "Manuel", 21);
        university.createStudent(6, "Brayan", 22);

        university.createCourse("Apps Moviles", 404, university.searchTeacherByName("Andres"));
        university.createCourse("Microservicios", 302, university.searchTeacherByName("Ricardo"));
        university.createCourse("IA", 202, university.searchTeacherByName("Daniel"));
        university.createCourse("Base de datos", 103, university.searchTeacherByName("Juan"));

        university.addStudentToCourse(1, "Apps Moviles");
        university.addStudentToCourse(2, "Apps Moviles");
        university.addStudentToCourse(3, "Microservicios");
        university.addStudentToCourse(4, "Microservicios");
        university.addStudentToCourse(5, "Microservicios");
        university.addStudentToCourse(5, "IA");
        university.addStudentToCourse(6, "IA");
        university.addStudentToCourse(3, "IA");
        university.addStudentToCourse(3, "Base de datos");
        university.addStudentToCourse(1, "Base de datos");

        boolean choice = true;

        while(choice){

            System.out.println("Bienvenido a la Universidad Icesi:");
            System.out.println("1. Ver todos los profesores");
            System.out.println("2. Ver todas las clases");
            System.out.println("3. Registrar estudiante");
            System.out.println("4. Registrar clase");
            System.out.println("5. Buscar clases de un estudiante");
            System.out.println("6. Salir");
            int menu = scanner.nextInt();
            scanner.nextLine();

            switch (menu){
                case 1:
                    int count = 0;

                    for (Teacher t : university.getTeachers()) {
                        count++;
                        System.out.println("Profesor " + (count));
                        System.out.println(t);
                    }
                    break;
                case 2:
                    int count2 = 0;
                    boolean choice2 = true;

                    for (Course c : university.getCourses()) {
                        count2++;
                        System.out.println("Clase " + (count2));
                        System.out.println(c.getName());
                    }

                    while(choice2){
                        System.out.println("Desea conocer mas informacion sobre alguna clase?");
                        System.out.println("(Ingrese el numero de la opcion deseada)");
                        System.out.println("1. Si");
                        System.out.println("2. No");
                        int menu2 = scanner.nextInt();
                        scanner.nextLine();

                        switch (menu2){
                            case 1:
                                System.out.println("Ingrese el nombre de la clase deseada:");
                                String courseName = scanner.nextLine();
                                System.out.println(university.searchCourseByName(courseName));
                                break;
                            case 2:
                                System.out.println("Saliendo");
                                choice2 = false;
                                break;
                            default:
                                System.out.println("Por favor seleccione alguna de las opciones");
                        }
                    }
                    break;
                case 3:
                    boolean choice3 = true;

                    System.out.println("Ingrese el id del estudiante:");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Ingrese el nombre del estudiante:");
                    String name = scanner.nextLine();
                    System.out.println("Ingrese la edad del estudiante:");
                    int age = scanner.nextInt();
                    scanner.nextLine();

                    university.createStudent(id, name, age);

                    while(choice3){
                        System.out.println("Como desea proceder?");
                        System.out.println("(Ingrese el numero de la opcion deseada)");
                        System.out.println("1. Añadir el estudiante a una clase");
                        System.out.println("2. Ver la lista de clases");
                        int menu2 = scanner.nextInt();
                        scanner.nextLine();

                        switch (menu2){
                            case 1:
                                System.out.println("Ingrese el nombre de la clase deseada:");
                                String courseName = scanner.nextLine();
                                university.addStudentToCourse(id, courseName);
                                System.out.println("El estudiante " + id + " ha sido añadido exitosamente");
                                System.out.println(university.searchCourseByName(courseName));
                                choice3 = false;
                                break;
                            case 2:
                                int count3 = 0;
                                for (Course c : university.getCourses()) {
                                    count3++;
                                    System.out.println("Clase " + (count3));
                                    System.out.println(c.getName());
                                }
                                break;
                            default:
                                System.out.println("Por favor seleccione alguna de las opciones");
                        }
                    }
                    break;
                case 4:
                    boolean choice4 = true;
                    boolean choice5 = true;

                    System.out.println("Ingrese el nombre de la clase:");
                    String courseName = scanner.nextLine();
                    System.out.println("Ingrese el salon de la clase:");
                    int classroom = scanner.nextInt();
                    scanner.nextLine();

                    while(choice4){
                        System.out.println("Como desea proceder?");
                        System.out.println("(Ingrese el numero de la opcion deseada)");
                        System.out.println("1. Añadir un profesor a la clase");
                        System.out.println("2. Ver la lista de profesores");
                        int menu2 = scanner.nextInt();
                        scanner.nextLine();

                        switch (menu2){
                            case 1:
                                System.out.println("Ingrese el nombre del profesor deseado:");
                                String teacherName = scanner.nextLine();

                                university.createCourse(courseName, classroom, university.searchTeacherByName(teacherName));
                                System.out.println("El profesor " + teacherName + " ha sido añadido exitosamente");
                                choice4 = false;
                                break;
                            case 2:
                                int count4 = 0;
                                for (Teacher t : university.getTeachers()) {
                                    count4++;
                                    System.out.println("Profesor " + (count4));
                                    System.out.println(t.getName());
                                }
                                break;
                            default:
                                System.out.println("Por favor seleccione alguna de las opciones");
                        }
                    }

                    while(choice5){
                        System.out.println("Como desea proceder?");
                        System.out.println("(Ingrese el numero de la opcion deseada)");
                        System.out.println("1. Añadir estudiantes a la clase");
                        System.out.println("2. Ver la lista de estudiantes");
                        System.out.println("3. Salir");
                        int menu2 = scanner.nextInt();
                        scanner.nextLine();

                        switch (menu2){
                            case 1:
                                System.out.println("Ingrese el id del estudiante deseado:");
                                int studentId = scanner.nextInt();
                                scanner.nextLine();

                                university.addStudentToCourse(studentId, courseName);
                                System.out.println("El estudiante " + studentId + " ha sido añadido exitosamente");
                                break;
                            case 2:
                                int count4 = 0;
                                for (Student s : university.getStudents()) {
                                    count4++;
                                    System.out.println("Estudiante " + (count4));
                                    System.out.println(s.getName());
                                }
                                break;
                            case 3:
                                System.out.println("Saliendo");
                                System.out.println("La clase ha sido creada correctamente:");
                                System.out.println(university.searchCourseByName(courseName));
                                choice5 = false;
                                break;
                            default:
                                System.out.println("Por favor seleccione alguna de las opciones");
                        }
                    }
                    break;
                case 5:
                    System.out.println("Ingrese el id del estudiante del que desea conocer sus clases inscritas:");
                    int id2 = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println(university.searchStudentCoursesById(id2));
                    break;
                case 6:
                    System.out.println("Hasta luego");
                    choice = false;
                    break;
                default:
                    System.out.println("Numero Invalido");
            }
        }

    }
}