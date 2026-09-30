package logistics.sea;

import logistics.model.Parcel;

/** Морской тариф: портовый сбор 25 + цена за кубометр (CBM) на 1000 км. */
public class SeaCostCalculator {

    private static final double PORT_FEE = 25.0;

    public double calculate(Parcel parcel, double distanceKm) {
        double cbm = Math.max(parcel.volumeCm3() / 1_000_000.0, parcel.weightKg() / 1000.0);
        double cost = PORT_FEE + cbm * 60.0 * distanceKm / 1000.0;
        return Math.round(cost * 100) / 100.0;
    }
}
