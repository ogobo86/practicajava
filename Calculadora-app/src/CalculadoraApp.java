
import java.util.Scanner;

public class CalculadoraApp {

    public static void main(String[] args) {
        Scanner consola = new Scanner(System.in);

        System.out.println("**** Aplicacionn Calculadora ****");

        System.out.println("""
                1. Suma
                2. Resta
                3. Multiplicacion
                4. Division
                5. Salir
                """);
        System.out.println("Operacion a realizar? ");
        var operacion = Integer.parseInt(consola.nextLine());

        if (operacion >= 1 && operacion <= 4) {
            System.out.println("Proporciona valor operando1");
            var operando1 = Integer.parseInt( consola.nextLine());
            System.out.println("Proporciona valor operando2");
            var operando2 = Integer.parseInt( consola.nextLine());
            int resultado;

            switch (operacion) {
                case 1 -> {
                    System.out.println("Haz seleccionado suma");
                    resultado = operando1 + operando2 ;
                    System.out.println("El resultado de la operacion suma es: " + resultado);
                }
                case 2 -> {
                    System.out.println("Haz seleccionado resta");
                    resultado = operando1 - operando2 ;
                    System.out.println("El resultado de la operacion resta es: " + resultado);
                }
                case 3 -> {
                    System.out.println("Haz seleccionado multiplicacion");
                    resultado = operando1 * operando2 ;
                    System.out.println("El resultado de la operacion multiplicacion es: " + resultado);
                }
                case 4 -> {
                    System.out.println("Haz seleccionado division");
                    resultado = operando1 / operando2 ;
                    System.out.println("El resultado de la operacion division es: " + resultado);
                }
            }
        }

    }
}
