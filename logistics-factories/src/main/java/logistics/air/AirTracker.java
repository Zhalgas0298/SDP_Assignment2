package logistics.air;

import logistics.model.Parcel;

/** Авиатрекинг: статус рейса, скорость 800 км/ч + 6 часов на наземную обработку. */
public class AirTracker {

    public String describeRoute(Parcel parcel, double distanceKm) {
        return "Flight status SCHEDULED: origin hub -> destination hub for '" + parcel.description() + "'";
    }

    public double estimateDeliveryHours(double distanceKm) {
        return distanceKm / 800.0 + 6;
    }
}
