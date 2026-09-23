package superhero.model;

public enum HeroLevel {
    TRAINEE("Стажёр"),
    HERO("Герой"),
    LEGEND("Легенда"),
    NEEDS_VACATION("Нужно срочно в отпуск");

    private final String title;

    HeroLevel(String title) {
        this.title = title;
    }

    public String title() {
        return title;
    }
}
