import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListadoPersonasApp {
    public static void main (String[] args){
        Scanner consola = new Scanner(System.in);
        //definimos la lista fuera del ciclo while
        List <Persona> personas = new ArrayList<>();
        //Menu
        var salir = false;

        while (!salir){
            mostrarMenu();
            try {
                salir = ejecutarOperacion(consola, personas);
            }catch (Exception e){
                System.out.println("Ocurrio un error: " + e.getMessage());
            }
            System.out.println();
        }

    }

    private static void  mostrarMenu (){
        //Mostramos Opciones
        System.out.println("""
                * * * * Listado Personas App * * * *
                [1]. Agregar
                [2]. Consultar
                [3]. Salir
                """);
        System.out.print("Proporciona la opcion?: ");
    }

    private static boolean ejecutarOperacion(Scanner consola, List<Persona> personas){
        var opcion = Integer.parseInt(consola.nextLine());
        var salir = false;
        //validamos opcion
        switch (opcion){
            case 1-> { //agrega persona a la lista
                System.out.println("Proporciona el nombre: ");
                var nombre = consola.nextLine();
                System.out.println("Proporciona el numero de telefono: ");
                var telefono = consola.nextLine();
                System.out.println("Proporciona el correo electronico: ");
                var correo = consola.nextLine();
                //CREAMOS EL OBJETO PERONSA
                var persona = new Persona(nombre, telefono, correo);
                //AGREGAMOS EL OBJETO A LA LISTA
                personas.add(persona);
                System.out.println("La lista tiene: " + personas.size() + " elementos.");
            }
            case 2 -> { // listar las perosnas
                System.out.println("Listado de personas: ");
                // Mejora usando LAMBDA y metodo de referencia
                // personas.forEach((persona) -> System.out.println(persona)); //OCUPA LAMBDA
                personas.forEach((System.out::println));
            }
            case 3 -> { //salir ciclo
                System.out.println("Haz terminado de ejecutar el programa");
                salir = true;
            }
            default -> System.out.println("Opcion erronea: " + opcion);
        }//fin s
        return salir;
    }
}