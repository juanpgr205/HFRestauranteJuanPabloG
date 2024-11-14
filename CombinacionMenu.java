package modelo;

import java.util.List;

/**
 * Representa una combinación de menú saludable.
 */
public class CombinacionMenu {
    private Bebida bebida;
    private Proteina proteina;
    private List<Acompanamiento> acompanamientos;
    private Postre postre;
    private double caloriasTotales;
    private double precioTotal;

    /**
     * Constructor para crear una combinación de menú saludable.
     *
     * @param bebida           La bebida de la combinación.
     * @param proteina         La proteína de la combinación.
     * @param acompanamientos   Lista de acompañamientos (hasta 3).
     * @param postre           El postre de la combinación (opcional).
     */
    public CombinacionMenu(Bebida bebida, Proteina proteina, List<Acompanamiento> acompanamientos, Postre postre) {
        this.bebida = bebida;
        this.proteina = proteina;
        this.acompanamientos = acompanamientos;
        this.postre = postre;
        calcularCaloriasTotales();
        calcularPrecioTotal();
    }

    /**
     * Genera una combinación de menú saludable basada en listas de opciones y un límite de calorías.
     *
     * @param bebidas Lista de bebidas.
     * @param proteinas Lista de proteínas.
     * @param acompanamientos Lista de acompañamientos.
     * @param postres Lista de postres.
     * @param caloriasMax El límite de calorías permitido.
     * @return Una instancia de CombinacionMenu si cumple el límite de calorías, o null si no es posible.
     */
    public static CombinacionMenu generarCombinacion(List<Bebida> bebidas, List<Proteina> proteinas,
                                                     List<Acompanamiento> acompanamientos, List<Postre> postres,
                                                     int caloriasMax) {
        if (bebidas.isEmpty() || proteinas.isEmpty() || acompanamientos.isEmpty()) {
            return null; // No se puede crear la combinación sin al menos una bebida, una proteína y un acompañamiento.
        }

        // Seleccionamos los primeros elementos como ejemplo
        Bebida bebidaSeleccionada = bebidas.get(0);
        Proteina proteinaSeleccionada = proteinas.get(0);
        List<Acompanamiento> acompanamientoSeleccionado = acompanamientos.subList(0, Math.min(acompanamientos.size(), 3));
        Postre postreSeleccionado = postres.isEmpty() ? null : postres.get(0);

        CombinacionMenu combinacion = new CombinacionMenu(bebidaSeleccionada, proteinaSeleccionada, acompanamientoSeleccionado, postreSeleccionado);

        if (combinacion.getCaloriasTotales() <= caloriasMax) {
            return combinacion;
        }
        return null; // No cumple con el límite de calorías
    }

    /**
     * Calcula las calorías totales de la combinación.
     */
    private void calcularCaloriasTotales() {
        caloriasTotales = bebida.getCalorias() + proteina.getCalorias();
        for (Acompanamiento acomp : acompanamientos) {
            caloriasTotales += acomp.getCalorias();
        }
        if (postre != null) {
            caloriasTotales += postre.getCalorias();
        }
    }

    /**
     * Calcula el precio total de la combinación.
     */
    private void calcularPrecioTotal() {
        precioTotal = bebida.getPrecio() + proteina.getPrecio();
        for (Acompanamiento acomp : acompanamientos) {
            precioTotal += acomp.getPrecio();
        }
        if (postre != null) {
            precioTotal += postre.getPrecio();
        }
    }

    /**
     * Obtiene las calorías totales de la combinación.
     *
     * @return Calorías totales.
     */
    public double getCaloriasTotales() {
        return caloriasTotales;
    }

    /**
     * Obtiene el precio total de la combinación.
     *
     * @return Precio total.
     */
    public double getPrecioTotal() {
        return precioTotal;
    }

    @Override
    public String toString() {
        return "Combinación de Menú: " + bebida.getNombre() + ", " + proteina.getNombre() +
                ", Acompañamientos: " + acompanamientos +
                (postre != null ? ", Postre: " + postre.getNombre() : "") +
                " | Calorías Totales: " + caloriasTotales + ", Precio Total: $" + precioTotal;
    }
}
