package modelo;

/**
 * Representa una bebida en el menú saludable.
 */
public class Bebida {
    private String nombre;
    private double calorias;
    private double precio;
    private boolean esBajaAzucar; // Indica si la bebida es baja en azúcar o no

    /**
     * Constructor para crear una bebida con sus atributos principales.
     *
     * @param nombre      El nombre de la bebida.
     * @param calorias    La cantidad de calorías de la bebida.
     * @param precio      El precio de la bebida.
     * @param esBajaAzucar Indica si la bebida es baja en azúcar o no.
     */
    public Bebida(String nombre, double calorias, double precio, boolean esBajaAzucar) {
        this.nombre = nombre;
        this.calorias = calorias;
        this.precio = precio;
        this.esBajaAzucar = esBajaAzucar;
    }

    /**
     * Obtiene el nombre de la bebida.
     *
     * @return El nombre de la bebida.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre de la bebida.
     *
     * @param nombre El nombre de la bebida.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene la cantidad de calorías de la bebida.
     *
     * @return Las calorías de la bebida.
     */
    public double getCalorias() {
        return calorias;
    }

    /**
     * Establece la cantidad de calorías de la bebida.
     *
     * @param calorias Las calorías de la bebida.
     */
    public void setCalorias(double calorias) {
        this.calorias = calorias;
    }

    /**
     * Obtiene el precio de la bebida.
     *
     * @return El precio de la bebida.
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * Establece el precio de la bebida.
     *
     * @param precio El precio de la bebida.
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    /**
     * Indica si la bebida es baja en azúcar.
     *
     * @return true si la bebida es baja en azúcar, false en caso contrario.
     */
    public boolean esBajaAzucar() {
        return esBajaAzucar;
    }

    /**
     * Establece si la bebida es baja en azúcar.
     *
     * @param esBajaAzucar true si la bebida es baja en azúcar, false en caso contrario.
     */
    public void setEsBajaAzucar(boolean esBajaAzucar) {
        this.esBajaAzucar = esBajaAzucar;
    }

    /**
     * Calcula el precio final de la bebida, considerando si tiene un descuento
     * por ser baja en azúcar.
     *
     * @return El precio final de la bebida.
     */
    public double calcularPrecioFinal() {
        return esBajaAzucar ? precio * 0.9 : precio; // 10% de descuento si es baja en azúcar
    }

    @Override
    public String toString() {
        return nombre + " - " + calorias + " calorías - ₡" + calcularPrecioFinal();
    }
}
