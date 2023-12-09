package Shipping_Company;

public class Ship extends Thread {
    String cityName ;
    int cargoSize=0;
    boolean isTravel = false;
    public Ship(String cityName) {
        this.cityName = cityName;

    }


    public void checkDepart() throws InterruptedException {
        if(this.cargoSize>=50) {
            this.isTravel = true;
            sleep(10000);
            this.cityName = "Gotham City";
            this.isTravel = false;
            this.cargoSize=0;
        }
    }
}
