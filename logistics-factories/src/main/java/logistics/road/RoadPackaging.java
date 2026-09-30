package logistics.road;

import logistics.model.Item;
import logistics.model.Parcel;

/** Автоперевозка: обычная картонная коробка. */
public class RoadPackaging {

    public Parcel pack(Item item) {
        double weight = item.weightKg() + 0.5;
        double volume = (item.lengthCm() + 2) * (item.widthCm() + 2) * (item.heightCm() + 2);
        return new Parcel(item.name(), weight, volume, "cardboard box");
    }
}
