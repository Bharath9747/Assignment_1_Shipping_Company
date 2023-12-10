package Shipping_Company;

import java.time.Instant;
import java.util.Random;

class Order{
    private int cargoWeight;

    @Override
    public String toString() {
        return  "cargoWeight=" + cargoWeight +
                ", destination='" + destination +"'";
    }

    private String destination;

    public Order(){
        this.cargoWeight=new Random().nextInt(41)+10;
        this.destination = (new Random().nextBoolean())? "Gotham City": "Atlanta";
    }
    public int getCargoWeight(){
        return cargoWeight;
    }

    public String getDestination(){
        return destination;
    }
}
