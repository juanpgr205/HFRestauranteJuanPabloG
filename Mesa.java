package modelo;

/**
 * Clase que representa una mesa en el restaurante.
 * Cada mesa tiene un número, un estado de disponibilidad y un mesero asignado.
 */
public class Mesa {
    private int numeroMesa;
    private boolean disponible; // Estado de disponibilidad de la mesa
    private Mesero meseroAsignado; // Mesero asignado a la mesa

    /**
     * Constructor de la clase Mesa.
     *
     * @param numeroMesa El número de la mesa.
     */
    public Mesa(int numeroMesa) {
        this.numeroMesa = numeroMesa;
        this.disponible = true; // Por defecto, la mesa está disponible al ser creada.
        this.meseroAsignado = null; // No tiene mesero asignado al principio.
    }

    /**
     * Obtiene el número de la mesa.
     *
     * @return El número de la mesa.
     */
    public int getNumeroMesa() {
        return numeroMesa;
    }

    /**
     * Obtiene el estado de disponibilidad de la mesa.
     *
     * @return true si la mesa está disponible, false si no lo está.
     */
    public boolean isDisponible() {
        return disponible;
    }

    /**
     * Establece el estado de disponibilidad de la mesa.
     *
     * @param disponible true para marcar la mesa como disponible, false para no disponible.
     */
    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    /**
     * Asigna un mesero a la mesa y marca la mesa como no disponible.
     *
     * @param mesero El mesero que se asignará a la mesa.
     */
    public void asignarMesero(Mesero mesero) {
        if (isDisponible()) { // Solo se puede asignar si la mesa está disponible
            this.meseroAsignado = mesero;
            this.disponible = false; // La mesa ya no está disponible después de asignar un mesero.
        }
    }

    /**
     * Libera la mesa, poniéndola como disponible y desasignando al mesero.
     */
    public void liberarMesa() {
        if (!isDisponible()) { // Solo se puede liberar si la mesa no está disponible
            this.meseroAsignado = null;
            this.disponible = true; // La mesa ahora está disponible.
        }
    }

    /**
     * Obtiene el mesero asignado a la mesa.
     *
     * @return El mesero asignado a la mesa, o null si no hay mesero asignado.
     */
    public Mesero getMeseroAsignado() {
        return meseroAsignado;
    }

    public void setMeseroAsignado(Mesero meseroAsignado) {
        this.meseroAsignado = meseroAsignado;
    }
}
