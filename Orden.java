package modelo;

/**
 * Representa una orden en el restaurante, con su selección de menú saludable y el mesero asignado.
 */
public class Orden {
    private Mesa mesa;
    private Mesero mesero;
    private MenuSaludable menuSaludable;
    private double total;

    /**
     * Constructor para crear una nueva orden con el menú saludable y el mesero asignado.
     *
     * @param mesa          La mesa donde se realiza la orden.
     * @param mesero        El mesero asignado a la mesa.
     * @param menuSaludable El menú saludable seleccionado por el cliente.
     */
    public Orden(Mesa mesa, Mesero mesero, MenuSaludable menuSaludable) {
        this.mesa = mesa;
        this.mesero = mesero;
        this.menuSaludable = menuSaludable;
        this.total = calcularTotal();
    }

    /**
     * Calcula el total de la orden sumando el precio de cada componente del menú.
     *
     * @return El costo total de la orden.
     */
    private double calcularTotal() {
        return menuSaludable.calcularPrecio();
    }

    /**
     * Obtiene la mesa asociada a la orden.
     *
     * @return La mesa donde se realizó la orden.
     */
    public Mesa getMesa() {
        return mesa;
    }

    /**
     * Obtiene el mesero asignado a la orden.
     *
     * @return El mesero asignado a la orden.
     */
    public Mesero getMesero() {
        return mesero;
    }

    /**
     * Obtiene el menú saludable seleccionado en la orden.
     *
     * @return El menú saludable de la orden.
     */
    public MenuSaludable getMenuSaludable() {
        return menuSaludable;
    }

    /**
     * Obtiene el total de la orden.
     *
     * @return El costo total de la orden.
     */
    public double getTotal() {
        return total;
    }
}
