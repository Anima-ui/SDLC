package superhero.view;

import superhero.model.HeroData;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

public class InputDialog extends JDialog {
    private final JTextField heightField = new JTextField(10);
    private final JTextField weightField = new JTextField(10);
    private final JTextField ageField = new JTextField(10);
    private final JTextField pullUpsField = new JTextField(10);
    private final JTextField sleepField = new JTextField(10);
    private final JButton calculateButton = new JButton("Рассчитать");

    public InputDialog(JFrame owner, HeroData previousData) {
        super(owner, "Данные супергероя", true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
        setContentPane(createContent());
        fill(previousData);
        getRootPane().setDefaultButton(calculateButton);
        pack();
        setLocationRelativeTo(owner);
    }

    public void setCalculateAction(Runnable action) {
        calculateButton.addActionListener(event -> action.run());
    }

    public String heightText() {
        return heightField.getText();
    }

    public String weightText() {
        return weightField.getText();
    }

    public String ageText() {
        return ageField.getText();
    }

    public String pullUpsText() {
        return pullUpsField.getText();
    }

    public String sleepText() {
        return sleepField.getText();
    }

    public void showError(String message) {
        JOptionPane.showMessageDialog(this, message, "Ошибка ввода", JOptionPane.ERROR_MESSAGE);
    }

    private JPanel createContent() {
        JPanel root = new JPanel(new BorderLayout(12, 12));
        root.setBorder(BorderFactory.createEmptyBorder(16, 18, 14, 18));

        JPanel fields = new JPanel(new GridLayout(0, 3, 8, 9));
        addField(fields, "Рост", heightField, "см");
        addField(fields, "Вес", weightField, "кг");
        addField(fields, "Возраст", ageField, "лет");
        addField(fields, "Подтягивания", pullUpsField, "раз");
        addField(fields, "Сон в сутки", sleepField, "часов");

        JButton cancelButton = new JButton("Отмена");
        cancelButton.addActionListener(event -> dispose());

        JPanel buttons = new JPanel();
        calculateButton.setPreferredSize(new Dimension(130, 32));
        cancelButton.setPreferredSize(new Dimension(100, 32));
        buttons.add(calculateButton);
        buttons.add(cancelButton);

        root.add(new JLabel("Введите параметры для расчёта:"), BorderLayout.NORTH);
        root.add(fields, BorderLayout.CENTER);
        root.add(buttons, BorderLayout.SOUTH);
        return root;
    }

    private void addField(JPanel panel, String label, JTextField field, String unit) {
        panel.add(new JLabel(label + ":"));
        panel.add(field);
        panel.add(new JLabel(unit));
    }

    private void fill(HeroData data) {
        if (data == null) {
            return;
        }
        heightField.setText(format(data.heightCm()));
        weightField.setText(format(data.weightKg()));
        ageField.setText(Integer.toString(data.age()));
        pullUpsField.setText(Integer.toString(data.pullUps()));
        sleepField.setText(format(data.sleepHours()));
    }

    private String format(double value) {
        return value == Math.rint(value) ? String.format("%.0f", value) : String.format("%.1f", value);
    }
}
