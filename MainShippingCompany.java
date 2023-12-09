package Shipping_Company;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class MainShippingCompany{
    static int totaltrips;

    public static void main(String[] args) {

        BlockingQueue<Order> cargoQueue = new ArrayBlockingQueue<>(500);
        Ship[] ships = new Ship[5];

        ExecutorService executorService = Executors.newFixedThreadPool(5);


        for(int i=1;i<=5;i++)
        {
            ships[i-1] = new Ship("Ship "+i,cargoQueue);
            executorService.submit(ships[i-1]);
        }
        while (true)
        {
            if(totaltrips==1000)
            {
                System.out.println("Total trips : "+totaltrips);
                System.out.println(Arrays.toString(ships));
                executorService.shutdownNow();
                System.exit(0);
            }
            Order order = new Order(new Random().nextInt(51)+50);
            cargoQueue.offer(order);

        }

    }
    static void creditIncome(){
        totaltrips++;
    }
}