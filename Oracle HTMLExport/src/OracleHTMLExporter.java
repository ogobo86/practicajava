import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OracleHTMLExporter {

    private static final String JDBC_URL = "jdbc:oracle:thin:@tu_servidor:puerto:tusid";
    private static final String USUARIO = "tu_usuario";
    private static final String CONTRASENA = "tu_contraseña";
    private static final String CONSULTA_SQL = "SELECT columna1, columna2 FROM tu_tabla";
    private static final String ARCHIVO_HTML = "reporte.html";

    public static void main(String[] args) {
        try {
            // Conectar a la base de datos y ejecutar la consulta
            try (Connection connection = DriverManager.getConnection(JDBC_URL, USUARIO, CONTRASENA);
                 PreparedStatement preparedStatement = connection.prepareStatement(CONSULTA_SQL);
                 ResultSet resultSet = preparedStatement.executeQuery();
                 FileWriter htmlWriter = new FileWriter(ARCHIVO_HTML)) {

                // Escribir encabezados en el archivo HTML
                writeHtmlHeader(htmlWriter);

                // Escribir datos en la tabla
                writeTableData(resultSet, htmlWriter);

                htmlWriter.write("</table></body></html>");

                System.out.println("Reporte generado exitosamente en " + ARCHIVO_HTML);

            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void writeHtmlHeader(FileWriter htmlWriter) throws IOException {
        htmlWriter.write("<html><head><title>Reporte HTML</title></head><body>\n");
        htmlWriter.write("<h1>Reporte HTML</h1>\n<table border=\"1\">\n");
        // Escribir encabezados de la tabla
        htmlWriter.write("<tr><th>Columna1</th><th>Columna2</th></tr>\n");
    }

    private static void writeTableData(ResultSet resultSet, FileWriter htmlWriter) throws SQLException, IOException {
        // Escribir datos en la tabla
        while (resultSet.next()) {
            htmlWriter.write("<tr>");
            htmlWriter.write("<td>" + resultSet.getString("columna1") + "</td>");
            htmlWriter.write("<td>" + resultSet.getString("columna2") + "</td>");
            htmlWriter.write("</tr>\n");
        }
    }
}
