package Shipping_Company;

public class Order {
    String cityName;
    int cargoSize =0;
    int ordercost=1000;

    public Order(String cityName, int cargoSize) {
        this.cityName = cityName;
        this.cargoSize = cargoSize;
    }
}
