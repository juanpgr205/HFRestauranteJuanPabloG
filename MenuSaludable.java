package modelo;

import java.util.List;

/**
 * Representa un menú saludable en el restaurante.
 * Un menú saludable puede tener varios componentes, como proteínas, bebidas y postres.
 */
public class MenuSaludable {
    private List<Proteina> proteinas; // Lista de proteínas seleccionadas
    private List<Bebida> bebidas; // Lista de bebidas seleccionadas
    private List<Postre> postres; // Lista de postres seleccionados
    private int totalCalorias; // Calorías totales del menú
    private double precioTotal; // Precio total del menú

    /**
     * Constructor para crear un nuevo menú saludable.
     *
     * @param proteinas    Lista de proteínas seleccionadas.
     * @param bebidas      Lista de bebidas seleccionadas.
     * @param postres      Lista de postres seleccionados.
     * @param totalCalorias Calorías totales del menú.
     * @param precioTotal   Precio total del menú.
     */
    public MenuSaludable(List<Proteina> proteinas, List<Bebida> bebidas, List<Postre> postres, int totalCalorias, double precioTotal) {
        this.proteinas = proteinas;
        this.bebidas = bebidas;
        this.postres = postres;
        this.totalCalorias = totalCalorias;
        this.precioTotal = precioTotal;
    }

    /**
     * Calcula el precio total del menú saludable sumando el precio de cada componente.
     *
     * @return El precio total calculado del menú saludable.
     */
    public double calcularPrecio() {
        return precioTotal;
    }

    // Getters y Setters para los atributos adicionales
    public int getTotalCalorias() {
        return totalCalorias;
    }

    public void setTotalCalorias(int totalCalorias) {
        this.totalCalorias = totalCalorias;
    }

    public double getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(double precioTotal) {
        this.precioTotal = precioTotal;
    }

    // Getters y Setters de los otros atributos si los necesitas...
}
