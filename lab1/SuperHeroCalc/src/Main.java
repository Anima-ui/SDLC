import superhero.controller.SuperHeroController;
import superhero.model.SuperHeroModel;
import superhero.view.MainFrame;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            useSystemLookAndFeel();

            SuperHeroModel model = new SuperHeroModel();
            MainFrame view = new MainFrame();
            new SuperHeroController(model, view);
            view.setVisible(true);
        });
    }

    private static void useSystemLookAndFeel() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ignored) {
        }
    }
}
