package es.tienda.vista;

import es.tienda.controlador.ControladorVideojuego;
import es.tienda.modelo.Videojuego;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.List;

/**
 * Versión mejorada de la interfaz gráfica para la tienda de videojuegos.
 * Incluye colores, tipografía y diseño más limpio y centrado.
 */
public class VentanaVideojuego extends JFrame {

    private JTextField campoBusqueda;
    private JButton botonBuscar;
    private JPanel panelResultados;
    private ControladorVideojuego controlador;

    public VentanaVideojuego() {
        controlador = new ControladorVideojuego();
        configurarVentana();
        construirInterfaz();
    }

    private void configurarVentana() {
        setTitle("🎮 Tienda GameTop - Búsqueda de Videojuegos");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(15, 15));
        getContentPane().setBackground(new Color(245, 245, 245)); // Fondo gris claro
    }

    private void construirInterfaz() {
        // --- Cabecera ---
        JLabel titulo = new JLabel("🎮 Tienda GameTop");
        titulo.setFont(new Font("Segoe UI", Font.BOLD, 28));
        titulo.setHorizontalAlignment(SwingConstants.CENTER);
        titulo.setBorder(new EmptyBorder(20, 0, 10, 0));
        add(titulo, BorderLayout.NORTH);

        // --- Panel de búsqueda ---
        JPanel panelBusqueda = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        panelBusqueda.setBackground(new Color(250, 250, 250));

        campoBusqueda = new JTextField(20);
        campoBusqueda.setFont(new Font("Segoe UI", Font.PLAIN, 16));

        botonBuscar = new JButton("Buscar");
        botonBuscar.setFont(new Font("Segoe UI", Font.BOLD, 16));
        botonBuscar.setBackground(new Color(50, 130, 200));
        botonBuscar.setForeground(Color.WHITE);
        botonBuscar.setFocusPainted(false);
        botonBuscar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        panelBusqueda.add(campoBusqueda);
        panelBusqueda.add(botonBuscar);
        add(panelBusqueda, BorderLayout.CENTER);

        // --- Panel de resultados ---
        panelResultados = new JPanel();
        panelResultados.setLayout(new BoxLayout(panelResultados, BoxLayout.Y_AXIS));
        panelResultados.setBackground(Color.WHITE);
        JScrollPane scroll = new JScrollPane(panelResultados);
        scroll.setBorder(new EmptyBorder(15, 15, 15, 15));
        add(scroll, BorderLayout.SOUTH);

        // Acción del botón
        botonBuscar.addActionListener((ActionEvent e) -> mostrarResultados());
    }

    private void mostrarResultados() {
        String nombre = campoBusqueda.getText().trim();

        if (nombre.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Introduce un nombre para buscar.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }

        panelResultados.removeAll(); // Limpia resultados anteriores

        List<Videojuego> lista = controlador.buscarPorNombre(nombre);

        if (lista.isEmpty()) {
            JLabel mensaje = new JLabel("⚠️ No se encontraron resultados para: " + nombre);
            mensaje.setFont(new Font("Segoe UI", Font.ITALIC, 16));
            mensaje.setForeground(Color.GRAY);
            mensaje.setBorder(new EmptyBorder(10, 0, 10, 0));
            panelResultados.add(mensaje);
        } else {
            for (Videojuego v : lista) {
                JPanel tarjeta = crearTarjetaJuego(v);
                panelResultados.add(tarjeta);
            }
        }

        panelResultados.revalidate();
        panelResultados.repaint();
    }

    private JPanel crearTarjetaJuego(Videojuego v) {
        JPanel tarjeta = new JPanel(new GridLayout(0, 1));
        tarjeta.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(200, 200, 200), 1),
                new EmptyBorder(10, 10, 10, 10)
        ));
        tarjeta.setBackground(Color.WHITE);

        JLabel nombre = new JLabel("🎮 " + v.getNombre());
        nombre.setFont(new Font("Segoe UI", Font.BOLD, 18));

        JLabel compania = new JLabel("🏢 Compañía: " + v.getCompania());
        JLabel anio = new JLabel("📅 Año: " + v.getAnno());
        JLabel plataforma = new JLabel("💻 Plataforma: " + v.getPlataforma());
        JLabel precio = new JLabel("💶 Precio: " + v.getPrecio() + " €");
        JLabel sinopsis = new JLabel("<html><p style='width:600px;'>" + v.getSinopsis() + "</p></html>");
        sinopsis.setForeground(new Color(80, 80, 80));

        tarjeta.add(nombre);
        tarjeta.add(compania);
        tarjeta.add(anio);
        tarjeta.add(plataforma);
        tarjeta.add(precio);
        tarjeta.add(sinopsis);

        return tarjeta;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new VentanaVideojuego().setVisible(true);
        });
    }
}
