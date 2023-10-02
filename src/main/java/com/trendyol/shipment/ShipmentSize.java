package com.trendyol.shipment;

import java.util.stream.Stream;

public enum ShipmentSize {

    SMALL,
    MEDIUM,
    LARGE,
    X_LARGE;

    public ShipmentSize upperSize() {
        return Stream.of(ShipmentSize.values())
                .filter(size -> size.ordinal() > this.ordinal())
                .findFirst()
                .orElse(X_LARGE);
    }
}
