import GUI.VistaRestaurante;
import controlador.*;
import modelo.*;
public class Main {
    public static void main(String[] args) {
        // Inicialización de los controladores
        ControladorRestaurante controladorRestaurante = new ControladorRestaurante();
        ControladorMenu controladorMenu = new ControladorMenu();

        // Ejecuta la interfaz VistaRestaurante
        javax.swing.SwingUtilities.invokeLater(() -> {
            VistaRestaurante gui = new VistaRestaurante(controladorRestaurante, controladorMenu);
            gui.setVisible(true);
        });
    }
}
