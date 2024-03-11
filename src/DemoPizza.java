import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DemoPizza extends JFrame implements ActionListener {
    // creates the labels, text fields, and buttons that will be added to the frame
    JLabel heading = new JLabel("Pizza Maker");
    //sets a default font size that will be used for things like the header
    private JTextField[] toppingFields;
    Font bigFont = new Font("Arial", Font.BOLD, 16);
    JLabel toppingsLabel = new JLabel("Enter your toppings: ");
    JCheckBox dBox = new JCheckBox("Will your pizza be delivered?", false);
    JLabel locLabel = new JLabel("If so, to where?");
    JTextField loc = new JTextField();
    JButton press = new JButton("Confirm");
    //creates empty labels summarizing wedding info
    JLabel sum = new JLabel("");
    //declares the default size for the frame
    final int WIDTH = 500;
    final int HEIGHT = 700;
    //TWedding class
    public DemoPizza(){
        super("My Frame");
        //sets the width and height of the frame
        setSize(WIDTH,HEIGHT);
        setLayout(new BorderLayout());
        //creates a new gridlayout for the labels, buttons, and text fields
        JPanel gridPanel1 = new JPanel(new GridLayout(0, 1));
        //adds our elements to the grid layout.
        gridPanel1.add(heading);
        gridPanel1.add(toppingsLabel);
        toppingFields = new JTextField[10];
        for (int i = 0; i < 10; i++) {
            toppingFields[i] = new JTextField();
            gridPanel1.add(new JLabel("Topping " + (i + 1) + ":"));
            gridPanel1.add(toppingFields[i]);
        }
        gridPanel1.add(dBox);
        gridPanel1.add(locLabel);
        gridPanel1.add(loc);
        gridPanel1.add(sum);
        //sets the size and color of title text
        heading.setFont(bigFont);
        heading.setForeground(Color.red);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //adds an action listener to the button
        press.addActionListener(this);
        //creates a new flowlayout for the confirm button
        JPanel button = new JPanel(new FlowLayout());
        button.add(press);
        //adds panels to frame
        add(gridPanel1, BorderLayout.NORTH);
        add(button, BorderLayout.SOUTH);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        //Update empty strings with user input, adds values to classes
        String[] toppings = new String[10];
        int numToppings = 0;

        for (int i = 0; i < 10; i++) {
            String topping = toppingFields[i].getText();
            if (!topping.isEmpty()) {
                toppings[numToppings++] = topping;
            }
        }

        if (dBox.isSelected()) {
            String deliveryAddress = loc.getText();

            DeliveryPizza deliveryPizza = new DeliveryPizza(toppings, numToppings, deliveryAddress);
            String dinfo = deliveryPizza.toString();
            sum.setText(dinfo);

        } else {
            Pizza pizza = new Pizza(toppings, numToppings);
            String info = pizza.toString();
            sum.setText(info);
        }
    }

    public static void main(String[] args) {

        DemoPizza ex = new DemoPizza();
        ex.setVisible(true);
    }
}
