package com.trendyol.shipment;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Basket {

    private List<Product> products;

    public ShipmentSize getShipmentSize() {
        if (products == null || products.isEmpty()) {   // There are no products in the basket
            return ShipmentSize.SMALL;
        }

        // Size's count Map
        Map<ShipmentSize, Long> shipmentSizeCountMap = products.stream()
                .collect(Collectors.groupingBy(Product::getSize, Collectors.counting()));

        if (products.size() < 3) {  // If there are less than 3 products
            return Collections.max(shipmentSizeCountMap.keySet());
        }

        if (Collections.max(shipmentSizeCountMap.values()) >= 3) {   // If there are 3 or more of the same shipment size
            ShipmentSize commonSize = shipmentSizeCountMap.entrySet().stream()
                    .filter(entry -> entry.getValue() >= 3)
                    .map(Map.Entry::getKey)
                    .findFirst()
                    .orElse(null);

            if (commonSize != null) {   // return upper size
                return commonSize.upperSize();
            }
        }

        // If none of the above conditions are met, return the largest shipment size.
        return Collections.max(shipmentSizeCountMap.keySet());
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
