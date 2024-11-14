package modelo;

/**
 * Representa una proteína en el menú saludable.
 */
public class Proteina {
    private String nombre;
    private double calorias;
    private double precio;

    /**
     * Constructor para crear una proteína.
     *
     * @param nombre   Nombre de la proteína.
     * @param calorias Calorías de la proteína.
     * @param precio   Precio de la proteína.
     */
    public Proteina(String nombre, double calorias, double precio) {
        this.nombre = nombre;
        this.calorias = calorias;
        this.precio = precio;
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public double getCalorias() {
        return calorias;
    }

    public double getPrecio() {
        return precio;
    }

    @Override
    public String toString() {
        return nombre + " (" + calorias + " cal)";
    }
}
