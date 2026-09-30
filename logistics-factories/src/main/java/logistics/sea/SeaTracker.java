package logistics.sea;

import logistics.model.Parcel;

/** Морской трекинг: портовые вехи, 30 км/ч + 72 часа на таможню. */
public class SeaTracker {

    public String describeRoute(Parcel parcel, double distanceKm) {
        return "Port milestones: loading port -> customs -> vessel departure -> discharge port for '"
                + parcel.description() + "'";
    }

    public double estimateDeliveryHours(double distanceKm) {
        return distanceKm / 30.0 + 72;
    }
}
