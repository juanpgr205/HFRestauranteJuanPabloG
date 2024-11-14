package modelo;

/**
 * Representa un acompañamiento en el menú saludable.
 */
public class Acompanamiento {
    private String nombre;
    private int calorias;
    private double precio;

    /**
     * Constructor para crear un acompañamiento con sus atributos principales.
     *
     * @param nombre   El nombre del acompañamiento.
     * @param calorias La cantidad de calorías del acompañamiento.
     * @param precio   El precio del acompañamiento.
     */
    public Acompanamiento(String nombre, int calorias, double precio) {
        this.nombre = nombre;
        this.calorias = calorias;
        this.precio = precio;
    }

    /**
     * Obtiene el nombre del acompañamiento.
     *
     * @return El nombre del acompañamiento.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Obtiene la cantidad de calorías del acompañamiento.
     *
     * @return Las calorías del acompañamiento.
     */
    public int getCalorias() {
        return calorias;
    }

    /**
     * Obtiene el precio del acompañamiento.
     *
     * @return El precio del acompañamiento.
     */
    public double getPrecio() {
        return precio;
    }

    @Override
    public String toString() {
        return nombre + " - " + calorias + " calorías - ₡" + precio;
    }
}
