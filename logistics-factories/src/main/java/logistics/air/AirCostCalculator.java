package logistics.air;

import logistics.model.Parcel;

/** Авиатариф: объёмный делитель 6000, топливная надбавка 15%. */
public class AirCostCalculator {

    private static final double FUEL_SURCHARGE = 0.15;

    public double calculate(Parcel parcel, double distanceKm) {
        double chargeableKg = Math.max(parcel.weightKg(), parcel.volumeCm3() / 6000.0);
        double base = chargeableKg * distanceKm * 0.012;
        return Math.round(base * (1 + FUEL_SURCHARGE) * 100) / 100.0;
    }
}
