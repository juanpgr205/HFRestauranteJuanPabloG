package modelo;

/**
 * Representa a un mesero en el restaurante, encargado de atender mesas y órdenes.
 */
public class Mesero {
    private String nombre;
    private int id;
    private boolean disponible; // Atributo para indicar disponibilidad del mesero

    /**
     * Constructor para crear un mesero.
     *
     * @param nombre Nombre del mesero.
     * @param id     ID del mesero.
     */
    public Mesero(String nombre, int id) {
        this.nombre = nombre;
        this.id = id;
        this.disponible = true; // El mesero comienza disponible
    }

    /**
     * Verifica si el mesero está disponible.
     *
     * @return true si el mesero está disponible, false si no.
     */
    public boolean isDisponible() {
        return disponible;
    }

    /**
     * Asigna una mesa al mesero y lo marca como no disponible.
     */
    public void asignarMesa() {
        this.disponible = false;
    }

    /**
     * Libera al mesero, marcándolo como disponible nuevamente.
     */
    public void liberarMesero() {
        this.disponible = true;
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public int getId() {
        return id;
    }
}
