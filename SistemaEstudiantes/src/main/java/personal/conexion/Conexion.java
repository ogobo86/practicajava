package personal.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    public static Connection obtenerConexion(){
        Connection conexion= null;
        var baseDatos = "estudiantes_db";
        var url= "jdbc:mysql://localhost:3306/" + baseDatos;
        var usuario = "root";
        var password = "";
        //Cargamos la clase del driver de mysql a memorira
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection(url,usuario, password);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Ocurrio un error en la conexion: " + e.getMessage());
        }
        return conexion;
    }

    public static void main (String[] args){
        var conexion = Conexion.obtenerConexion();
        if (conexion != null)
            System.out.println("Conexion exitosa: " + conexion);
        else
            System.out.println("Error al conectarse");
    }
}