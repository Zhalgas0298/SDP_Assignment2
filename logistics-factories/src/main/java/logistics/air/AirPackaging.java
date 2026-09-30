package logistics.air;

import logistics.model.Item;
import logistics.model.Parcel;

/** Авиаперевозка: лёгкая упаковка, но лимит веса 32 кг на место. */
public class AirPackaging {

    private static final double MAX_WEIGHT_KG = 32.0;

    public Parcel pack(Item item) {
        double weight = item.weightKg() + 0.2;
        if (weight > MAX_WEIGHT_KG) {
            throw new IllegalArgumentException("Air cargo limit is " + MAX_WEIGHT_KG + " kg per piece, got " + weight);
        }
        double volume = (item.lengthCm() + 1) * (item.widthCm() + 1) * (item.heightCm() + 1);
        return new Parcel(item.name(), weight, volume, "lightweight air pack");
    }
}
