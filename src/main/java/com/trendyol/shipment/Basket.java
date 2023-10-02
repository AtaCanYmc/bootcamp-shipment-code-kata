package com.trendyol.shipment;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Basket {

    private List<Product> products;
    private Shipment shipmentOfBasket = new Shipment();

    public ShipmentSize getShipmentSize() {
        if (products == null || products.isEmpty())  // There are no products in the basket
            return ShipmentSize.SMALL;

        shipmentOfBasket.setProducts(products);
        return shipmentOfBasket.getOrderShipmentSize();
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
