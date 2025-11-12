// Paquete del controlador
package es.tienda.controlador;

// Importamos lo necesario
import es.tienda.modelo.ConexionBD;
import es.tienda.modelo.Videojuego;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase ControladorVideojuego
 * Se encarga de conectar con la base de datos y ejecutar el procedimiento almacenado 'nombrejuego'.
 */
public class ControladorVideojuego {

    /**
     * Método que ejecuta el procedimiento 'nombrejuego' y devuelve una lista de videojuegos.
     * @param nombreJuego nombre (o parte del nombre) del juego a buscar.
     * @return lista de videojuegos que coinciden con la búsqueda.
     */
    public List<Videojuego> buscarPorNombre(String nombreJuego) {
        // Creamos una lista vacía donde guardaremos los resultados
        List<Videojuego> lista = new ArrayList<>();

        // Establecemos la conexión con la base de datos
        try (Connection con = ConexionBD.getConnection()) {

            // Preparamos la llamada al procedimiento almacenado
            CallableStatement cs = con.prepareCall("{CALL nombrejuego(?)}");

            // Establecemos el parámetro (el nombre del juego que queremos buscar)
            cs.setString(1, nombreJuego);

            // Ejecutamos la consulta y obtenemos el resultado
            ResultSet rs = cs.executeQuery();

            // Recorremos los resultados y los convertimos en objetos Videojuego
            while (rs.next()) {
                Videojuego v = new Videojuego(
                        rs.getInt("idjuego"),
                        rs.getString("nombre"),
                        rs.getInt("anno"),
                        rs.getString("compania"),
                        rs.getDouble("precio"),
                        rs.getString("sinopsis"),
                        rs.getString("plataforma")
                );
                lista.add(v); // Añadimos el videojuego a la lista
            }

            // Cerramos el ResultSet y CallableStatement
            rs.close();
            cs.close();

        } catch (SQLException e) {
            System.out.println("Error al ejecutar la consulta: " + e.getMessage());
        }

        // Devolvemos la lista de videojuegos encontrados
        return lista;
    }
}
