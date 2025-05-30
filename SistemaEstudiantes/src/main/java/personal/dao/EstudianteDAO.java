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

    public static void main(String[] args) {
        var estudianteDAO = new EstudianteDAO();
        //Listar Estudiantes
        System.out.println("Listado Estudiantes: ");
        List<Estudiante> estudiantes= estudianteDAO.listarEstudiantes();
        estudiantes.forEach(System.out::println);

        //Buscar Estudiante
        var estudiante1= new Estudiante(2);
        System.out.println("Estudiante antes de la busqueda : " + estudiante1);
        var encontrado = estudianteDAO.buscarEstudiantePorId(estudiante1);
        if (encontrado)
            System.out.println("Estudiante encontrado: " + estudiante1);
        else
            System.out.println("No se encontro estudiante: " + estudiante1.getIdEstudiante());
    }
}