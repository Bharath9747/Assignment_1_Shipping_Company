package Shipping_Company;

import java.util.concurrent.BlockingQueue;

import static Shipping_Company.MainShippingCompany.creditIncome;

class Ship  implements  Runnable{
    private String name;
    private BlockingQueue<Order> ordersQueue;

    public Ship(String name, BlockingQueue<Order> ordersQueue) {
        this.name = name;
        this.ordersQueue = ordersQueue;
        this.totaltrips = 0;
    }

    @Override
    public String toString() {
        return "Ship{" +
                "name='" + name + '\'' +
                ", totaltrips=" + totaltrips +
                '}';
    }

    private int totaltrips;

    @Override
    public void run() {
       while(true)
       {
           try{
               Order order = ordersQueue.take();
               processOrder(order);
               if( totaltrips%5==0)
               {
                   System.out.println(name+" is going for maintenance.");

               }
           } catch (InterruptedException e) {
               throw new RuntimeException(e);
           }
       }
    }

    private void processOrder(Order order) throws InterruptedException {
        if(order.isCancelled()){
            System.out.println(name+" canceled order. Set back by $250");
        }
        else {
            System.out.println(name+" processed order. Earned $1000 "+totaltrips);
            creditIncome();
            totaltrips++;
        }
    }
}