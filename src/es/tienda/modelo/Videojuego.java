// Paquete donde se encuentra la clase
package es.tienda.modelo;

//Clase Videojuego que representa un videojuego en la tienda
public class Videojuego {

    // Atributos que coinciden con los campos de la tabla MySQL
    private int idjuego;
    private String nombre;
    private int anno;
    private String compania;
    private double precio;
    private String sinopsis;
    private String plataforma;

    // --- Constructores ---
    // Constructor vacío (por si queremos crear el objeto sin datos)
    public Videojuego() {
    }

    // Constructor con todos los campos (para crear el objeto completo de golpe)
    public Videojuego(int idjuego, String nombre, int anno, String compania, double precio, String sinopsis, String plataforma) {
        this.idjuego = idjuego;
        this.nombre = nombre;
        this.anno = anno;
        this.compania = compania;
        this.precio = precio;
        this.sinopsis = sinopsis;
        this.plataforma = plataforma;
    }

    // --- Getters y Setters ---
    // Permiten acceder y modificar los atributos de manera controlada

    public int getIdjuego() {
        return idjuego;
    }

    public void setIdjuego(int idjuego) {
        this.idjuego = idjuego;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getAnno() {
        return anno;
    }

    public void setAnno(int anno) {
        this.anno = anno;
    }

    public String getCompania() {
        return compania;
    }

    public void setCompania(String compania) {
        this.compania = compania;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    public String getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }

    // --- Método toString() ---
    // Sirve para mostrar los datos del videojuego de forma legible por consola.
    @Override
    public String toString() {
        return "Videojuego {" +
                "idjuego=" + idjuego +
                ", nombre='" + nombre + '\'' +
                ", año=" + anno +
                ", compañía='" + compania + '\'' +
                ", precio=" + precio +
                ", sinopsis='" + sinopsis + '\'' +
                ", plataforma='" + plataforma + '\'' +
                '}';
    }
}
