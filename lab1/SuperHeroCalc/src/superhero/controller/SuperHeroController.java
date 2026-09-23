package superhero.controller;

import superhero.model.HeroData;
import superhero.model.SuperHeroModel;
import superhero.model.ValidationException;
import superhero.view.InputDialog;
import superhero.view.MainFrame;

public class SuperHeroController {
    private final SuperHeroModel model;
    private final MainFrame view;

    public SuperHeroController(SuperHeroModel model, MainFrame view) {
        this.model = model;
        this.view = view;

        view.setInputAction(this::openInputDialog);
        view.observe(model);
    }

    private void openInputDialog() {
        InputDialog dialog = new InputDialog(view, model.getLastData());
        dialog.setCalculateAction(() -> calculate(dialog));
        dialog.setVisible(true);
    }

    private void calculate(InputDialog dialog) {
        try {
            HeroData data = new HeroData(
                    parseDouble(dialog.heightText(), "рост"),
                    parseDouble(dialog.weightText(), "вес"),
                    parseInteger(dialog.ageText(), "возраст"),
                    parseInteger(dialog.pullUpsText(), "количество подтягиваний"),
                    parseDouble(dialog.sleepText(), "продолжительность сна")
            );

            model.calculate(data);
            dialog.dispose();
        } catch (ValidationException exception) {
            dialog.showError(exception.getMessage());
        }
    }

    private double parseDouble(String text, String fieldName) throws ValidationException {
        String normalized = text.trim().replace(',', '.');
        if (normalized.isEmpty()) {
            throw new ValidationException("Заполните поле «" + fieldName + "».");
        }
        try {
            return Double.parseDouble(normalized);
        } catch (NumberFormatException exception) {
            throw new ValidationException("Поле «" + fieldName + "» должно содержать число.");
        }
    }

    private int parseInteger(String text, String fieldName) throws ValidationException {
        String normalized = text.trim();
        if (normalized.isEmpty()) {
            throw new ValidationException("Заполните поле «" + fieldName + "».");
        }
        try {
            return Integer.parseInt(normalized);
        } catch (NumberFormatException exception) {
            throw new ValidationException("Поле «" + fieldName + "» должно содержать целое число.");
        }
    }
}
