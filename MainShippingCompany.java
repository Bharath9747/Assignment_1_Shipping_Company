package Shipping_Company;

import java.util.Scanner;

public class MainShippingCompany {
    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        Ship ship = new Ship("Atlanta");

        long totalcost=0;
        while(true) {
            System.out.println("1.Create a Order");
            System.out.println("2.View Ships Status");
            System.out.println("Enter a choices");
            int ch = sc.nextInt();
            switch (ch)
            {
                case 1 :
                    String cityName = sc.next();
                    int cargoSize = sc.nextInt();
                    /*if(!(cargoSize>=1 && cargoSize<=10))
                    {
                        System.out.println("Cargo Size Wrong");
                        break;
                    }*/

                    Order order = new Order(cityName,cargoSize);
                    ship.cargoSize=cargoSize+ship.cargoSize;
                    ship.checkDepart();
                    totalcost+=order.ordercost;
                    break;
                case 2 :
                    System.out.println("============");
                    System.out.println(ship.isTravel?"Travelling to Atlanta":"Waiting for Cargo in "+ship.cityName);
                    System.out.println("Cargo Size "+ship.cargoSize);
                    System.out.println("============");
                    break;
                default: System.exit(0);
            }
        }

    }
}
