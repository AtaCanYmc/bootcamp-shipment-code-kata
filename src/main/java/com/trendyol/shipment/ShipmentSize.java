package com.trendyol.shipment;

public enum ShipmentSize {

    SMALL,
    MEDIUM,
    LARGE,
    X_LARGE;

    public ShipmentSize upperSize() {
        int nextOrdinal = this.ordinal() + 1;
        if (nextOrdinal < ShipmentSize.values().length) {
            return ShipmentSize.values()[nextOrdinal];
        } else {
            return X_LARGE;
        }
    }
}
