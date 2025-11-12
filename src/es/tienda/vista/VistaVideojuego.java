// Paquete donde se encuentra la clase
package es.tienda.vista;

// Importamos lo necesario
import es.tienda.controlador.ControladorVideojuego;
import es.tienda.modelo.Videojuego;

import java.util.List;
import java.util.Scanner;

/**
 * Clase VistaVideojuego
 * Representa la parte visual (consola) del patrón MVC.
 * Pide al usuario el nombre del videojuego y muestra los resultados de la búsqueda.
 */
public class VistaVideojuego {

    public static void main(String[] args) {

        // Creamos un objeto del controlador para manejar la lógica de consulta
        ControladorVideojuego controlador = new ControladorVideojuego();

        // Creamos un Scanner para leer la entrada del usuario
        Scanner sc = new Scanner(System.in);

        System.out.println("🎮 Bienvenido al sistema de gestión de la tienda de videojuegos 🎮");
        System.out.print("Introduce el nombre (o parte del nombre) del videojuego que quieres buscar: ");
        String nombreBusqueda = sc.nextLine(); // Leemos el texto que introduce el usuario

        // Llamamos al controlador para realizar la búsqueda
        List<Videojuego> resultados = controlador.buscarPorNombre(nombreBusqueda);

        // Mostramos los resultados en consola
        if (resultados.isEmpty()) {
            System.out.println("⚠️ No se encontraron videojuegos con ese nombre.");
        } else {
            System.out.println("\n📋 Resultados encontrados:\n");
            for (Videojuego v : resultados) {
                System.out.println(v); // Llamamos al método toString() de la clase Videojuego
                System.out.println("-----------------------------------------");
            }
        }

        // Cerramos el Scanner
        sc.close();
    }
}
