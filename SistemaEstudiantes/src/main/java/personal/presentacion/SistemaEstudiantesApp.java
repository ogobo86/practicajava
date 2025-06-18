package personal.presentacion;

import personal.dao.EstudianteDAO;
import personal.dominio.Estudiante;

import java.util.Scanner;

public class SistemaEstudiantesApp {

    public static void main (String[] args) {
        var salir = false;
        var consola = new Scanner(System.in);
        // Servicio
        var estudianteDAo= new EstudianteDAO();

        while (!salir){
            try {
                mostrarMenu();
                salir = ejecutarOpciones(consola, estudianteDAo);
            }catch (Exception e){
                System.out.println("Ocurrio un error" + e.getMessage());
            }
            System.out.println();
        }// fin while
    }

    private static void mostrarMenu(){
        System.out.print("""
                *** Sistema de Estudiantes ***
                1. Listar estudiantes.
                2. Buscar Estudiante por Id.
                3. Agregar Estudiante.
                4. Modificar Estudiante.
                5. Eliminar Estudiante.
                6. Salir.
                Elige una opción:
                """);
    }

    private static boolean ejecutarOpciones(Scanner consola, EstudianteDAO estudianteDAO){
        var opcion = Integer.parseInt(consola.nextLine());
        var salir = false;
        switch (opcion){
            // Listar estudiantes
            case 1 -> {
                System.out.println("Listado de Estudiantes");
                var estudiantes = estudianteDAO.listarEstudiantes();
                estudiantes.forEach(System.out::println);
            }
            // Buscar Estudiantes por ID
            case 2 -> {
                System.out.println("Introduce el Id del estudiante: ");
                var idEstudiante = Integer.parseInt(consola.nextLine());
                var estudiante = new Estudiante(idEstudiante);
                var encontrado = estudianteDAO.buscarEstudiantePorId(estudiante);
                if (encontrado)
                    System.out.println("Estudiante encontrado: " + estudiante);
                else
                    System.out.println("Estudiante NO encontrado: " + estudiante);
            }
            // Agregar Estudiante
            case 3 -> {
                System.out.println("Agregar estudiante: ");
                System.out.print("Nombre: ");
                var nombre = consola.nextLine();
                System.out.print("Apellido: ");
                var apellido = consola.nextLine();
                System.out.print("Telefono: ");
                var telefono = consola.nextLine();
                System.out.println("E-mail: ");
                var email= consola.nextLine();
                var estudiante = new Estudiante(nombre, apellido, telefono, email);
                var agregado = estudianteDAO.agregarEstudiante(estudiante);
                if (agregado)
                    System.out.println("Estudiante agregado: " + estudiante);
                else
                    System.out.println("Estudiante NO agregado: " + estudiante);
            }
            // Modificar Estudiante
            case 4 -> {
                System.out.println("Modificar Estudiante: ");
                System.out.println("Id Estudiante: ");
                var idEstudiante = Integer.parseInt(consola.nextLine());
                var nombre = consola.nextLine();
                System.out.print("Apellido: ");
                var apellido = consola.nextLine();
                System.out.print("Telefono: ");
                var telefono = consola.nextLine();
                System.out.println("E-mail: ");
                var email= consola.nextLine();
                var estudiante = new Estudiante(idEstudiante,nombre, apellido, telefono, email);
                var modificar = estudianteDAO.modificarEstudiante(estudiante);
                if (modificar)
                    System.out.println("Estudiante modificado: " + estudiante);
                else
                    System.out.println("Estudiante NO modificado: " + estudiante);
            }
            // Eliminar Estudiante
            case 5 -> {
                System.out.println("Eliminar Estudiante: ");
                System.out.println("Id Estudiante: ");
                var idEstudiante = Integer.parseInt(consola.nextLine());
                var estudiante = new Estudiante(idEstudiante);
                var eliminar = estudianteDAO.elminarEstudiante(estudiante);
                if (eliminar)
                    System.out.println("Estudiante eliminado: " + estudiante);
                else
                    System.out.println("Estudiante NO eliminado: " + estudiante);
            }
            // Salir del Menu
            case 6 -> {
                System.out.println("Hasta pronto!");
                salir = true;
            }
            default -> System.out.println("Opcion no reconocida.");
        }
        return salir;
    }
}
