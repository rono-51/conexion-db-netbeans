package tiendamanual.Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion {
    private Connection conn;
    private final String bd = "tiendaManual"; 
    private final String url = "jdbc:mysql://localhost:3306/" + bd; 
    private final String user = "root";
    private final String password = "";
    private final String driver = "com.mysql.cj.jdbc.Driver";
    
    public Conexion() {
    }   
    
    public Connection getConexion() {
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Conexión exitosa a la base de datos: " + bd);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conn;
    }
    
    public static void main(String[] args) {
        Conexion conexion = new Conexion();
        Connection conn = conexion.getConexion();
        if (conn != null) {
            System.out.println("Conexión establecida correctamente");
        } else {
            System.out.println("Error al conectar con la base de datos");
        }
    }
}
