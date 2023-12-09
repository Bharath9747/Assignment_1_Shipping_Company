package Shipping_Company;

class Order{
    private  int cargoWeight;
    private  boolean cancelled;

    public Order(int cargoWeight) {
        this.cargoWeight = cargoWeight;
        this.cancelled = false;
    }

    public void cancelOrder(){
        this.cancelled=true;
    }
    public boolean isCancelled() {
        return cancelled;
    }
}