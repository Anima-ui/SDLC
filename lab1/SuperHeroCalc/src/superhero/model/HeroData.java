package superhero.model;

public record HeroData(
        double heightCm,
        double weightKg,
        int age,
        int pullUps,
        double sleepHours
) {
}
