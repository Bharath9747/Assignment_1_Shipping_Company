package Shipping_Company;

import java.util.LinkedList;
import java.util.Queue;

import static Shipping_Company.Ship.MIN_CARGO;

public class ShippingCompany {
    private  int totalEarnings=0;

    @Override
    public String toString() {
        return  "orderQueue=" + orderQueue   ;
    }

    private int totalOrdersDelivered=0;
    private int totalOrdersCancelled=0;
    private Queue<Order> orderQueue = new LinkedList<>();
    private Object orderLock = new Object();
    public synchronized void placeOrder(Order order)
    {
        synchronized (orderLock){
            orderQueue.offer(order);
        }

    }
    public synchronized  void processOrder(Order order,int cargoPick){
        if(cargoPick>=MIN_CARGO)
        {
            totalEarnings+=1000;
            totalOrdersDelivered++;
        }
        else
        {
            totalEarnings-=250;
            totalOrdersCancelled++;
        }
    }
    public synchronized Order getNextOrder(){
        synchronized (orderLock){
            return orderQueue.poll();
        }
    }
    public synchronized void sendToMaintenance(Ship ship) throws InterruptedException {
//        Thread.sleep(1000);
    }
    public synchronized int getTotalEarnings(){
        return totalEarnings;
    }
    public synchronized int getTotalOrdersDelivered(){
        return totalOrdersDelivered;
    }
    public synchronized int getTotalOrdersCancelled(){
        return totalOrdersCancelled;
    }
}
