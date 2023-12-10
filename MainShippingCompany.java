package Shipping_Company;

public class MainShippingCompany {
    public static void main(String[] args) throws InterruptedException {
        ShippingCompany shippingCompany = new ShippingCompany();
        Thread[] threads = new Thread[12];
        for(int i=0;i<7;i++)
            threads[i]= new Customer(shippingCompany);
        for(int i=7;i<12;i++)
            threads[i]= new Ship(shippingCompany);
        for(Thread thread:threads)
            thread.start();
        for (Thread thread:threads)
            thread.join();

        System.out.println("Total Orders Delivered : "+shippingCompany.getTotalOrdersDelivered());
        System.out.println("Total Orders Cancelled : "+shippingCompany.getTotalOrdersCancelled());
    }
}