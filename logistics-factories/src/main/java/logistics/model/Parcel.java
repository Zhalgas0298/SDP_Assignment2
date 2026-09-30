package logistics.model;

/** Упакованная посылка: вес и объём уже включают упаковку. */
public record Parcel(String description, double weightKg, double volumeCm3, String packagingType) {
}
