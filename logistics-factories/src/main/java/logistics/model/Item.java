package logistics.model;

/** Товар, который клиент хочет отправить (до упаковки). */
public record Item(String name, double weightKg, double lengthCm, double widthCm, double heightCm) {

    public double volumeCm3() {
        return lengthCm * widthCm * heightCm;
    }
}
