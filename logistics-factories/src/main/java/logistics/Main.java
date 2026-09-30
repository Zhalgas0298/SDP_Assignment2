package logistics;

import logistics.air.AirPackaging;
import logistics.client.ShipmentService;
import logistics.model.Item;
import logistics.model.Parcel;
import logistics.sea.SeaCostCalculator;

public class Main {

    public static void main(String[] args) {
        Item laptop = new Item("Laptop", 10, 40, 30, 20);
        ShipmentService service = new ShipmentService();

        System.out.println("== Normal usage ==");
        for (String mode : new String[] {"road", "air", "sea"}) {
            System.out.println(service.ship(mode, laptop, 500));
        }

        System.out.println();
        System.out.println("== Problem: nothing prevents mixing families ==");
        Parcel airParcel = new AirPackaging().pack(laptop);              // air packaging...
        double cost = new SeaCostCalculator().calculate(airParcel, 500); // ...priced with sea tariff
        System.out.println("Air-packed parcel priced by SEA calculator: " + cost + " USD (compiles and runs silently)");
    }
}
