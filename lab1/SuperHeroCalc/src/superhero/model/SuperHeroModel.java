package superhero.model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class SuperHeroModel {
    public static final String STATE_PROPERTY = "state";

    private final PropertyChangeSupport changes = new PropertyChangeSupport(this);
    private HeroData lastData;
    private HeroResult result;

    public void calculate(HeroData data) throws ValidationException {
        validate(data);

        HeroData oldData = lastData;
        lastData = data;
        result = evaluate(data);

        // Активная модель
        changes.firePropertyChange(STATE_PROPERTY, oldData, data);
    }

    public HeroData getLastData() {
        return lastData;
    }

    public HeroResult getResult() {
        return result;
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changes.addPropertyChangeListener(listener);
    }

    private void validate(HeroData data) throws ValidationException {
        if (!Double.isFinite(data.heightCm()) || data.heightCm() <= 0) {
            throw new ValidationException("Рост должен быть положительным числом.");
        }
        if (!Double.isFinite(data.weightKg()) || data.weightKg() <= 0) {
            throw new ValidationException("Вес должен быть положительным числом.");
        }
        if (data.age() <= 0) {
            throw new ValidationException("Возраст должен быть положительным целым числом.");
        }
        if (data.pullUps() < 0) {
            throw new ValidationException("Количество подтягиваний должно быть неотрицательным целым числом.");
        }
        if (!Double.isFinite(data.sleepHours()) || data.sleepHours() < 0 || data.sleepHours() > 24) {
            throw new ValidationException("Продолжительность сна должна быть числом от 0 до 24 часов.");
        }
    }

    private HeroResult evaluate(HeroData data) {
        double heightMeters = data.heightCm() / 100.0;
        double bmi = data.weightKg() / (heightMeters * heightMeters);

        int pullUpScore = (int) Math.min(40L, (long) data.pullUps() * 4L);
        int score = bodyMassScore(bmi)
                + pullUpScore
                + ageScore(data.age())
                + sleepScore(data.sleepHours());

        HeroLevel level;
        if (data.sleepHours() < 5 || data.sleepHours() > 11) {
            level = HeroLevel.NEEDS_VACATION;
        } else if (score >= 80) {
            level = HeroLevel.LEGEND;
        } else if (score >= 55) {
            level = HeroLevel.HERO;
        } else {
            level = HeroLevel.TRAINEE;
        }

        return new HeroResult(level, score, bmi);
    }

    private int bodyMassScore(double bmi) {
        if (bmi >= 18.5 && bmi < 25) {
            return 25;
        }
        if (bmi >= 16 && bmi < 30) {
            return 15;
        }
        return 5;
    }

    private int ageScore(int age) {
        if (age >= 19 && age <= 35) {
            return 20;
        }
        if (age >= 36 && age <= 50) {
            return 15;
        }
        return 10;
    }

    private int sleepScore(double hours) {
        if (hours >= 7 && hours <= 9) {
            return 20;
        }
        if (hours >= 6 && hours <= 10) {
            return 12;
        }
        if (hours >= 5 && hours <= 11) {
            return 5;
        }
        return 0;
    }
}
