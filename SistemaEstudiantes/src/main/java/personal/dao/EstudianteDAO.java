package personal.dao;
import personal.dominio.Estudiante;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import static personal.conexion.Conexion.obtenerConexion;

//DAO -> Data Access Object
public class EstudianteDAO {

    public List<Estudiante> listarEstudiantes(){
        List<Estudiante> estudiantes = new ArrayList<>();
        PreparedStatement ps;
        ResultSet rs;
        Connection con = obtenerConexion();
        String sql = "SELECT * FROM estudiante ORDER BY id_estudiante";

        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                var estudiante = new Estudiante();
                estudiante.setIdEstudiante(rs.getInt("id_estudiante"));
                estudiante.setNombre(rs.getString("nombre"));
                estudiante.setApellido(rs.getString("apellido"));
                estudiante.setTelefono(rs.getString("telefono"));
                estudiante.setEmail(rs.getString("email"));
                estudiantes.add(estudiante);
            }
        } catch (SQLException e) {
            System.out.println("Ocurrio un error al selecionar datos: " + e.getMessage());
        }
        //Cerrar conexion a DB
        finally {
            try {
                con.close();
            }catch (Exception e){
                System.out.println("Ocurrio un error al cerrar la DB: " + e.getMessage());
            }
        }
        return estudiantes;
    }

    //Buscar Estudiante por ID
    public boolean buscarEstudiantePorId(Estudiante estudiante){
        PreparedStatement ps;
        ResultSet rs;
        Connection con = obtenerConexion();
        String sql = "SELECT * FROM ESTUDIANTE WHERE ID_ESTUDIANTE = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1,estudiante.getIdEstudiante());
            rs  = ps.executeQuery();
            if (rs.next()){
                estudiante.setNombre(rs.getString("nombre"));
                estudiante.setApellido(rs.getString("apellido"));
                estudiante.setTelefono(rs.getString("telefono"));
                estudiante.setEmail(rs.getString("email"));
                return  true;
            }
        } catch (SQLException e) {
            System.out.println("Ocurrio un error al buscar estudiante: " + e.getMessage());
        }
        //Cerrar conexion a DB
        finally {
            try {
                con.close();
            }catch (Exception e){
                System.out.println("Ocurrio un error al cerrar la DB: " + e.getMessage());
            }
        }
        return false;
    }

    // Agregar estudiante
    public boolean agregarEstudiante (Estudiante estudiante){
        PreparedStatement ps;
        Connection con = obtenerConexion();
        String sql = "INSERT INTO ESTUDIANTE (nombre, apellido, telefono, email) VALUES (?, ?, ?, ?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1,estudiante.getNombre());
            ps.setString(2,estudiante.getApellido());
            ps.setString(3,estudiante.getTelefono());
            ps.setString(4,estudiante.getEmail());
            ps.execute();
            return  true;

        } catch (SQLException e) {
            System.out.println("Ocurrio un error al agregar estudiante: " + e.getMessage());
        }
        //Cerrar conexion a DB
        finally {
            try {
                con.close();
            }catch (Exception e){
                System.out.println("Ocurrio un error al cerrar la DB: " + e.getMessage());
            }
        }return false;
    }

    //Modificar Estudiante
    public boolean modificarEstudiante (Estudiante estudiante){
            PreparedStatement ps;
            Connection con = obtenerConexion();
            String sql = "UPDATE estudiante SET nombre= ?, apellido=?, telefono=?, email= ? WHERE id_estudiante=?";
            try{
                ps = con.prepareStatement(sql);
                ps.setString(1, estudiante.getNombre());
                ps.setString(2, estudiante.getApellido());
                ps.setString(3, estudiante.getTelefono());
                ps.setString(4, estudiante.getEmail());
                ps.setInt(5,estudiante.getIdEstudiante());
                ps.execute();
                return true;
            } catch (Exception e) {
                System.out.println("Error al modificar estudiante: " + e.getMessage());
            }
            //Cerrar conexion a DB
            finally {
                try {
                    con.close();
                } catch (Exception e) {
                    System.out.println("Ocurrio un error al cerrar la DB: " + e.getMessage());
                }
            }
            return false;
    }

    //Eliminar estudiante
    public boolean elminarEstudiante(Estudiante estudiante){
        PreparedStatement ps;
        Connection con = obtenerConexion();
        String sql = "DELETE FROM estudiante WHERE id_estudiante= ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1,estudiante.getIdEstudiante());
            ps.execute();
            return true;
        } catch (Exception e) {
            System.out.println("Error al eliminar al estudiante: " + e.getMessage());
        }
        //Cerrar conexion a DB
        finally {
            try {
                con.close();
            } catch (Exception e) {
                System.out.println("Ocurrio un error al cerrar la DB: " + e.getMessage());
            }
        }
        return false;
    }

    public static void main(String[] args) {
        var estudianteDAO = new EstudianteDAO();

        // Agregar Estudiante
        //var nuevoEstudiante =  new Estudiante("Patroclio", "Trujillo", "1234567", "ptrujillo@algo");
        //System.out.println("Agregando un nuevo estudiante");
        //var agregado = estudianteDAO.agregarEstudiante(nuevoEstudiante);
        //if (agregado)
        //    System.out.println("Estudiante agregado: " + nuevoEstudiante);
        //else
        //    System.out.println("No se agrego el estudiante: " + nuevoEstudiante);

        //Modificar registro de Estudiante.
        //System.out.println("Modificacion de Estudiante: ");
        //var modificacionEstudiante = new Estudiante(2, "Ausencio", "Cortes", "21345", "acortes@algo.com" );
        //var modificado = estudianteDAO.modificarEstudiante(modificacionEstudiante);
        //if (modificado)
        //    System.out.println("Estudiante modificado con exito!" + modificacionEstudiante);
        //else
        //    System.out.println("No se modifico el estudiante." + modificacionEstudiante);

        //Listar Estudiantes
        System.out.println("Listado Estudiantes: ");
        List<Estudiante> estudiantes= estudianteDAO.listarEstudiantes();
        estudiantes.forEach(System.out::println);

        //Buscar Estudiante
        var estudiante1= new Estudiante(1);
        System.out.println("Estudiante antes de la busqueda : " + estudiante1);
        var encontrado = estudianteDAO.buscarEstudiantePorId(estudiante1);
        if (encontrado)
            System.out.println("Estudiante encontrado: " + estudiante1);
        else
            System.out.println("No se encontro estudiante: " + estudiante1.getIdEstudiante());

        //Eliminar Estudiante
        System.out.println("Eliminar estudiante");
        var estudianteElminar = new Estudiante(4);
        var elimnado = estudianteDAO.elminarEstudiante(estudianteElminar);
        if (elimnado)
            System.out.println("Esudiante eliminado");
        else
            System.out.println("No se pudo eliminar estudiante: " + estudianteElminar.getIdEstudiante());
    }
}