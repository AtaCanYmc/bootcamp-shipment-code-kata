package com.trendyol.shipment;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Shipment {
    private List<Product> products;
    private static final int PRODUCT_COUNT_THRESHOLD = 3;

    private Map<ShipmentSize, Long> productSizeCountMap(){
        return products.stream()
                .collect(Collectors.groupingBy(Product::getSize, Collectors.counting()));
    }

    private ShipmentSize fittestOrderSizeByProductSize() {
        return productSizeCountMap().entrySet().stream()
                .filter(entry -> entry.getValue() >= PRODUCT_COUNT_THRESHOLD)
                .map(Map.Entry::getKey)
                .findFirst()
                .map(ShipmentSize::upperSize)   // return upper size if count >= threshold
                .orElse(Collections.max(productSizeCountMap().keySet()));  // return biggest size if count < threshold
    }

    public ShipmentSize getOrderShipmentSize(){
        if (products.size() < PRODUCT_COUNT_THRESHOLD) {  // If there are less than 3 products
            return Collections.max(productSizeCountMap().keySet());
        }

        return fittestOrderSizeByProductSize();
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
