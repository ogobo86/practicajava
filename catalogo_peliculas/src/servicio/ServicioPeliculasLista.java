package servicio;

import dominio.Pelicula;

import java.util.ArrayList;
import java.util.List;

public class ServicioPeliculasLista implements IServicioPeliculas{

    private final List<Pelicula> peliculas;


    public ServicioPeliculasLista(){
        this.peliculas = new ArrayList<>();
    }

    @Override
    public void listarPeliculas() {
        System.out.println("Listado de Peliculas..");
        peliculas.forEach(System.out::println);
    }

    @Override
    public void agregarPelicula(Pelicula pelicula) {
        peliculas.add(pelicula);
        System.out.println("Se agrego la pelicua: " + pelicula);
    }

    @Override
    public void buscarPelicula(Pelicula pelicula) {
        // Regresa el indice de la pelicula encontrada en la lista
        var indice = peliculas.indexOf(pelicula);
        if (indice == -1)
            System.out.println("No se encontro la pelicula: " + pelicula);
        else
            System.out.println("Pelicula encontrada en el indice: " + indice);

    }

    public static void main(String[] args) {
        // Creamos objetos de tipo pelicula para agregar a lista
        var pelicula1  = new Pelicula("Vengadores");
        var pelicula2 = new Pelicula("Caballeros del Zodiaco");

        // Creamos el servicio (patron de disenio service)
        IServicioPeliculas servicioPeliculas = new ServicioPeliculasLista();

        // Agregamos las peliculas a la lista
        servicioPeliculas.agregarPelicula(pelicula1);
        servicioPeliculas.agregarPelicula(pelicula2);

        // Listamos las peliculas
        servicioPeliculas.listarPeliculas();

        // Buscamos una pelicula (SE DEBE DE IMPLEMENTAR LOS METODOS EQUALS Y HASHCODE)
        servicioPeliculas.buscarPelicula(pelicula1);

    }
}
