import java.util.Scanner;

public class App {
    static Scanner sc = new Scanner(System.in);
    static Academia academia = new Academia("Dev Senior");
    public static void main(String[] args) throws Exception {

        String opcion;
        do {
            System.out.println("\n==========MENU Principal==========");
            System.out.println("1. Gestionar Estudiantes");
            System.out.println("2. Gestionar Profesores");
            System.out.println("3. Gestionar Cursos");
            System.out.println("4. Salir");
            System.out.println("========================\n");
            System.out.print("Seleccione una opción:");
            opcion = sc.nextLine();

            switch (opcion) {
                case "1":
                    menuEstudiantes();
                    break;
                case "2":
                    menuProfesores();
                    break;
                case "3":
                    menuCursos();
                    break;
                case "4":
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción no válida");
                    break;
            }

        } while (!opcion.equals("4")); // el ciclo se repetirá mientras la opción seleccionada no sea 4 para salir del
                                       // sistema

        sc.nextLine();
    }

    public static void menuEstudiantes() {
        System.out.println("Gestionar Estudiantes");
        
    }

    public static void menuProfesores() {
        System.out.println("Gestionar Profesores");
    }

    public static void menuCursos() {
        System.out.println("Gestionar Cursos");
    }
}
