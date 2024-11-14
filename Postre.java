package modelo;

/**
 * Representa un postre en el menú saludable del restaurante.
 */
public class Postre {
    private String nombre;
    private double precio;
    private double calorias;

    /**
     * Constructor para crear un postre.
     *
     * @param nombre   Nombre del postre.
     * @param precio   Precio del postre.
     * @param calorias Calorías del postre.
     */
    public Postre(String nombre, double precio, double calorias) {
        this.nombre = nombre;
        this.precio = precio;
        this.calorias = calorias;
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public double getCalorias() {
        return calorias;
    }

    @Override
    public String toString() {
        return nombre + " - Precio: " + precio + " colones, Calorías: " + calorias;
    }
}
