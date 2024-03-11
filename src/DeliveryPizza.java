import java.text.DecimalFormat;

public class DeliveryPizza extends Pizza {
    private double dFee;
    private String dAddress;
    public DeliveryPizza(String[] toppings, int numToppings, String deliveryAddress) {
        super(toppings, numToppings);
        this.dAddress = deliveryAddress;

        // Set delivery fee based on total price
        if (super.getPrice() > 18) {
            this.dFee = 3;
        } else {
            this.dFee = 5;
        }
    }

    @Override
    public String toString() {
        DecimalFormat d = new DecimalFormat("0.00");
        return super.toString() + ", Delivery Address: " + dAddress + ", Delivery Fee: $" + d.format(dFee);
    }
}