package Main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    private static final String URL = "jdbc:mysql://localhost:3306/sistemaaportaciones ";
    private static final String USER = "root";
    private static final String PASSWORD = "43070236";

    private static Conexion instancia;
    private Connection conexion;

    private Conexion() {
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            this.conexion = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conexión exitosa a la base de datos");
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println("Error al conectar a la base de datos: " + e.getMessage());
        }
    }

    public static Conexion getInstancia() {
        if (instancia == null) {
            instancia = new Conexion();
        }
        return instancia;
    }

    public Connection getConexion() {
        return conexion;
    }

    public void desconectar() {
        try {
            if (conexion != null && !conexion.isClosed()) {
                conexion.close();
                System.out.println("Desconexión exitosa de la base de datos");
            }
        } catch (SQLException e) {
            System.err.println("Error al desconectar de la base de datos: " + e.getMessage());
        }
    }
}
