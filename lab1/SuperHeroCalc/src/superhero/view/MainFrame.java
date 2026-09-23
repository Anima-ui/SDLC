package superhero.view;

import superhero.model.HeroData;
import superhero.model.HeroResult;
import superhero.model.SuperHeroModel;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

public class MainFrame extends JFrame {
    private final JLabel levelLabel = new JLabel("Данные ещё не введены", SwingConstants.CENTER);
    private final JLabel scoreLabel = new JLabel(" ", SwingConstants.CENTER);
    private final JLabel heightValue = new JLabel("—");
    private final JLabel weightValue = new JLabel("—");
    private final JLabel ageValue = new JLabel("—");
    private final JLabel pullUpsValue = new JLabel("—");
    private final JLabel sleepValue = new JLabel("—");
    private final JButton inputButton = new JButton("Ввести данные");

    public MainFrame() {
        super("Калькулятор уровня супергероя");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(540, 390));
        setContentPane(createContent());
        pack();
        setLocationRelativeTo(null);
    }

    public void setInputAction(Runnable action) {
        inputButton.addActionListener(event -> action.run());
    }

    public void observe(SuperHeroModel model) {
        model.addPropertyChangeListener(event -> {
            if (SuperHeroModel.STATE_PROPERTY.equals(event.getPropertyName())) {
                showState(model.getLastData(), model.getResult());
            }
        });
    }

    public void showState(HeroData data, HeroResult result) {
        heightValue.setText(format(data.heightCm()) + " см");
        weightValue.setText(format(data.weightKg()) + " кг");
        ageValue.setText(data.age() + " лет");
        pullUpsValue.setText(data.pullUps() + " раз");
        sleepValue.setText(format(data.sleepHours()) + " ч");

        levelLabel.setText(result.level().title());
        scoreLabel.setText(String.format("Результат: %d баллов · ИМТ: %.1f", result.score(), result.bodyMassIndex()));
    }

    private JPanel createContent() {
        JPanel root = new JPanel(new BorderLayout(16, 16));
        root.setBorder(BorderFactory.createEmptyBorder(20, 24, 20, 24));

        JLabel title = new JLabel("Ваш уровень супергероя", SwingConstants.CENTER);
        title.setFont(title.getFont().deriveFont(Font.BOLD, 22f));

        levelLabel.setFont(levelLabel.getFont().deriveFont(Font.BOLD, 26f));
        levelLabel.setForeground(new Color(35, 78, 140));

        JPanel heading = new JPanel(new GridLayout(0, 1, 0, 7));
        heading.add(title);
        heading.add(levelLabel);
        heading.add(scoreLabel);

        JPanel values = new JPanel(new GridLayout(0, 2, 10, 8));
        values.setBorder(BorderFactory.createTitledBorder("Последние введённые данные"));
        addRow(values, "Рост:", heightValue);
        addRow(values, "Вес:", weightValue);
        addRow(values, "Возраст:", ageValue);
        addRow(values, "Подтягивания:", pullUpsValue);
        addRow(values, "Сон в сутки:", sleepValue);

        JPanel buttonPanel = new JPanel();
        inputButton.setPreferredSize(new Dimension(180, 36));
        buttonPanel.add(inputButton);

        root.add(heading, BorderLayout.NORTH);
        root.add(values, BorderLayout.CENTER);
        root.add(buttonPanel, BorderLayout.SOUTH);
        return root;
    }

    private void addRow(JPanel panel, String name, JLabel value) {
        JLabel label = new JLabel(name);
        label.setFont(label.getFont().deriveFont(Font.BOLD));
        panel.add(label);
        panel.add(value);
    }

    private String format(double value) {
        return value == Math.rint(value) ? String.format("%.0f", value) : String.format("%.1f", value);
    }
}
