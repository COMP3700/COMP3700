import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CheckoutController implements ActionListener {
    private CheckoutView checkoutView;
    private DataAdapter dataAdapter;// to save and load product information
    private OrderController orderController;
    private Checkout checkout = new Checkout();
    private int itemsAdded = 0;

    public CheckoutController(CheckoutView checkoutView, DataAdapter dataAdapter, OrderController orderController) {
        this.dataAdapter = dataAdapter;
        this.checkoutView = checkoutView;
        this.orderController = orderController;

        checkoutView.getBtnAddToOrder().addActionListener(this);
    }


    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == checkoutView.getBtnAddToOrder())
            loadProduct();
    }

    private void saveProduct() {
        int productID;
        try {
            productID = Integer.parseInt(checkoutView.getTxtProductID().getText());
        }
        catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid product ID! Please provide a valid product ID!");
            return;
        }

        int productQuantity;
        try {
            productQuantity = Integer.parseInt(checkoutView.getTxtProductQuantity().getText());
        }
        catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid product quantity! Please provide a valid product quantity!");
            return;
        }

        // Done all validations! Make an object for this product!

        Product product = new Product();
        product.setID(productID);
        product.setQuantity(productQuantity);

        // Store the product to the database

        dataAdapter.saveProduct(product);
    }

    private void loadProduct() {
        int proQuant = 0;

        if (checkoutView.getTxtProductQuantity().isEnabled() == true){
            try {
                proQuant = Integer.parseInt(checkoutView.getTxtProductQuantity().getText());
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid quantity entered! Please provide a positive numbered quantity!");
                return;
            }
        }

        int productID = 0;
        try {
            productID = Integer.parseInt(checkoutView.getTxtProductID().getText());
            checkoutView.getTxtProductQuantity().setEnabled(true);
        }
        catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid product ID! Please provide a valid product ID!");
            return;
        }

        Product product = dataAdapter.loadProduct(productID);

        if (proQuant > product.getQuantity()) {
            JOptionPane.showMessageDialog(null, "Quantity entered cannot be fulfilled by inventory. Enter lower quantity.");
            itemsAdded--;
        } else {

            int updateQuant = product.getQuantity() - proQuant;
            product.setQuantity(updateQuant);
            checkout.addToTotalPrice(product.getPrice() * proQuant);
            dataAdapter.saveProduct(product);
            if(itemsAdded % 2 != 0) {
                product.setQuantity(proQuant);
                checkout.addToProductList(product);
                orderController.updateOrderView(checkout.getProductList());
            }
            if (proQuant != 0) {
                checkoutView.getTxtProductQuantity().setEnabled(false);
            }

        }


        if (product == null) {
            JOptionPane.showMessageDialog(null, "This product ID does not exist in the database!");
            return;
        }



        checkoutView.getTxtProductName().setText(product.getName());
        checkoutView.getTxtProductPrice().setText(String.valueOf(product.getPrice()));
        itemsAdded++;
    }
}