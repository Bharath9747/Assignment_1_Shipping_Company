package Shipping_Company;

class Customer extends Thread{
    private ShippingCompany shippingCompany;
    public Customer(ShippingCompany shippingCompany){
        this.shippingCompany = shippingCompany;
    }
    @Override
    public void run(){
        while(shippingCompany.getTotalEarnings()<1000000)
        {
            Order order = new Order();
            shippingCompany.placeOrder(order);
            System.out.println(order);

        }
    }
}
