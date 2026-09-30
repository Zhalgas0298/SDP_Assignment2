package logistics.road;

import logistics.model.Parcel;

/** Автотариф: объёмный делитель 5000, цена за кг*км. */
public class RoadCostCalculator {

    public double calculate(Parcel parcel, double distanceKm) {
        double chargeableKg = Math.max(parcel.weightKg(), parcel.volumeCm3() / 5000.0);
        return Math.round(chargeableKg * distanceKm * 0.005 * 100) / 100.0;
    }
}
