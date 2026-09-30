package logistics.sea;

import logistics.model.Item;
import logistics.model.Parcel;

/** Морская перевозка: тяжёлый водонепроницаемый ящик. */
public class SeaPackaging {

    public Parcel pack(Item item) {
        double weight = item.weightKg() + 2.0;
        double volume = (item.lengthCm() + 10) * (item.widthCm() + 10) * (item.heightCm() + 10);
        return new Parcel(item.name(), weight, volume, "waterproof sea crate");
    }
}
