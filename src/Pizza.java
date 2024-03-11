import java.text.DecimalFormat;
public class Pizza {
    private String[] toppings;
    private double price;
    public Pizza(String[] toppings, int numToppings) {
        this.toppings = new String[numToppings];
        System.arraycopy(toppings, 0, this.toppings, 0, numToppings);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numToppings; i++) {
            sb.append(this.toppings[i]);
            if (i < numToppings - 1) {
                sb.append(", ");
            }
        }
        // Set price at $14 plus $2 for each topping
        this.price = 14 + 2 * numToppings;
    }
    public String toString() {
        DecimalFormat d = new DecimalFormat("0.00");
        return "Toppings: " + String.join(", ", toppings) + ", Price: $" + d.format(price);
    }
    public double getPrice() {
        return price;
    }
}