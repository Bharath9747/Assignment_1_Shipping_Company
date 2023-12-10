package Shipping_Company;

class Ship extends Thread{
    static final int MIN_CARGO = 50;
    private static final int MAX_CARGO = 300;
    private ShippingCompany shippingCompany;

    @Override
    public String toString() {
        return "Ship{" +
                "shippingCompany=" + shippingCompany +
                '}';
    }

    public Ship(ShippingCompany shippingCompany){
        this.shippingCompany = shippingCompany;
    }
    @Override
    public void run(){
        while(shippingCompany.getTotalEarnings()<1000000)
        {
            Order order = shippingCompany.getNextOrder();
            if(order!=null)
            {
                int cargoPick = Math.max(MIN_CARGO,order.getCargoWeight());
                cargoPick = Math.min(cargoPick,MAX_CARGO);
                shippingCompany.processOrder(order,cargoPick);
                try {
                    shippingCompany.sendToMaintenance(this);

                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}