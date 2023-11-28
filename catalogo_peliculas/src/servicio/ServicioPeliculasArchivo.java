package servicio;

import dominio.Pelicula;

import java.io.*;

public class ServicioPeliculasArchivo implements IServicioPeliculas{

    private final String NOMBRE_ARCHIVO = "peliculas.txt";

    // CONSTRUCTOR
    public  ServicioPeliculasArchivo(){
        var archivo = new File(NOMBRE_ARCHIVO);
        try{
            // SI YA EXISTE EL ARCHIVO NO SE VUELVE A CREAR
            if (archivo.exists()){
                System.out.println("El archivo ya existe");
            }else{
               // SI NO XISTE SE CREA VACIO
               var salida = new PrintWriter((new FileWriter(archivo)));
               salida.close();
                System.out.println("Se a creado el archivo");
            }
        }catch  (Exception e) {
            System.out.println("Ocurrio un error al abrir el archivo:  " + e.getMessage());
        }
    }

    @Override
    public void listarPeliculas() {
        // variable para poder abrir el archivo
        var archivo = new File (NOMBRE_ARCHIVO);

        try{
            System.out.println("Listado de Peliculas");
            // Abrimos el archivo
            var entrada = new BufferedReader(new FileReader(archivo));
            // Leemos las lineas del archivo
            String linea;
            linea = entrada.readLine();
            // Leemos todas las lineas
            while (linea != null){
                var pelicula = new Pelicula(linea);
                System.out.println(pelicula);
                // antes de terminar el ciclo se vuelve a leer la linea
                linea = entrada.readLine();
            }
            // cerrar el archivo
            entrada.close();
        }catch (Exception e){
            System.out.println("Ocurrio un error al leer el archivo: "+ e.getMessage());
        }
    }

    @Override
    public void agregarPelicula(Pelicula pelicula) {
        boolean anexa = false;
        var archivo = new File(NOMBRE_ARCHIVO);
        try{
            // revisamos la existencia de archivo
            anexa = archivo.exists();
            var salida = new PrintWriter(new FileWriter(archivo, anexa));
            // agregamos pelicula (tostring)
            salida.println(pelicula);
            salida.close();
            System.out.println("Se agrego el archivo: " + pelicula);
        }catch (Exception e){
            System.out.println("Ocurrio un error al agregar el archivo: "+ e.getMessage());
        }
    }

    @Override
    public void buscarPelicula(Pelicula pelicula) {
        var archivo = new File(NOMBRE_ARCHIVO);

        try{
            //abrimos el archivo para lectura linea a linea
            var entrada = new BufferedReader(new FileReader(archivo));
            String lineaTexto;
            lineaTexto = entrada.readLine();
            var indice = 1;
            var encontrada = false;
            var peliculaBuscar = pelicula.getNombre();

            while (lineaTexto != null){
                // Buscamos sin importar mayusculas/minusculas
                if (peliculaBuscar != null && peliculaBuscar.equalsIgnoreCase(lineaTexto)){
                    encontrada = true;
                    break;
                }
                // leemos la siguiente linea antes de la siguiente iteracion
                lineaTexto = entrada.readLine();
                indice ++;
            }// FIN WHILE
            // Imprimimos los resultados
            if (encontrada )
                System.out.println("Pelicula " + lineaTexto + " encontrada " + indice);
            else
                System.out.println("NO se encontro la pelicula: "+ pelicula.getNombre());
            // CERRAMOS
            entrada.close();

        }catch (Exception e){
            System.out.println("Ocurrio un error al buscar en el archivo: "+ e.getMessage());
        }
    }
}
