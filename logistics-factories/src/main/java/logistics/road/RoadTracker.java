package logistics.road;

import logistics.model.Parcel;

/** Автотрекинг: GPS-контрольные точки каждые 100 км, средняя скорость 60 км/ч. */
public class RoadTracker {

    public String describeRoute(Parcel parcel, double distanceKm) {
        int checkpoints = (int) (distanceKm / 100);
        return "GPS tracking: " + checkpoints + " control points for '" + parcel.description() + "'";
    }

    public double estimateDeliveryHours(double distanceKm) {
        return distanceKm / 60.0;
    }
}
