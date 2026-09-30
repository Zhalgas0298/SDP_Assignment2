package logistics.client;

import logistics.air.AirCostCalculator;
import logistics.air.AirPackaging;
import logistics.air.AirTracker;
import logistics.model.Item;
import logistics.model.Parcel;
import logistics.road.RoadCostCalculator;
import logistics.road.RoadPackaging;
import logistics.road.RoadTracker;
import logistics.sea.SeaCostCalculator;
import logistics.sea.SeaPackaging;
import logistics.sea.SeaTracker;

/**
 * НАИВНАЯ версия клиента: сам создаёт конкретные классы через new
 * и знает про каждый вид транспорта. Это baseline для Части A.
 */
public class ShipmentService {

    public String ship(String mode, Item item, double distanceKm) {
        if (mode.equals("road")) {
            RoadPackaging packaging = new RoadPackaging();
            RoadCostCalculator calculator = new RoadCostCalculator();
            RoadTracker tracker = new RoadTracker();

            Parcel parcel = packaging.pack(item);
            double cost = calculator.calculate(parcel, distanceKm);
            String route = tracker.describeRoute(parcel, distanceKm);
            double hours = tracker.estimateDeliveryHours(distanceKm);
            return format(mode, parcel, cost, route, hours);

        } else if (mode.equals("air")) {
            AirPackaging packaging = new AirPackaging();
            AirCostCalculator calculator = new AirCostCalculator();
            AirTracker tracker = new AirTracker();

            Parcel parcel = packaging.pack(item);
            double cost = calculator.calculate(parcel, distanceKm);
            String route = tracker.describeRoute(parcel, distanceKm);
            double hours = tracker.estimateDeliveryHours(distanceKm);
            return format(mode, parcel, cost, route, hours);

        } else if (mode.equals("sea")) {
            SeaPackaging packaging = new SeaPackaging();
            SeaCostCalculator calculator = new SeaCostCalculator();
            SeaTracker tracker = new SeaTracker();

            Parcel parcel = packaging.pack(item);
            double cost = calculator.calculate(parcel, distanceKm);
            String route = tracker.describeRoute(parcel, distanceKm);
            double hours = tracker.estimateDeliveryHours(distanceKm);
            return format(mode, parcel, cost, route, hours);

        } else {
            throw new IllegalArgumentException("Unknown transport mode: " + mode);
        }
    }

    private String format(String mode, Parcel parcel, double cost, String route, double hours) {
        return String.format("[%s] %s | packed: %.1f kg, %s | cost: %.2f USD | ETA: %.1f h%n    %s",
                mode, parcel.description(), parcel.weightKg(), parcel.packagingType(), cost, hours, route);
    }
}
