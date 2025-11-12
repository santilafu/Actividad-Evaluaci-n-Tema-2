// Paquete de la clase ConexionBD
package es.tienda.modelo;
// Importaciones necesarias para la conexión a la base de datos
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
// Clase para gestionar la conexión a la base de datos
public class ConexionBD {

    //Costantes para la conexión a la base de datos
    private static final String URL = "jdbc:mysql://localhost:3306/dbgametop";
    private static final String USER = "root";
    private static final String PASSWORD = "B@se1234Datos";

    // Método publico que establece y devuelve la conexión a la base de datos
    public static Connection getConnection() {
        Connection conexion = null;//Objeto de conexión inicializado a null
        try {
            // Establece la conexión utilizando DriverManager
            conexion = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            // Manejo de excepciones en caso de error de conexión
            e.printStackTrace();//Imprime el seguimiento del error

    }
        return conexion;//Devuelve el objeto de conexión
    }
}
