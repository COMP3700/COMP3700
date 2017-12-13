import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class OrderController implements ActionListener{
    private  OrderView orderView;
    private String stringbuilder = "";
    private PrintWriter pw;
    private static DecimalFormat df2 = new DecimalFormat(".##");
    private double total = 0;


    public OrderController(OrderView orderView) throws UnsupportedEncodingException {
        this.orderView = orderView;
        orderView.getBtnCard().addActionListener(this);
        orderView.getBtnCash().addActionListener(this);
        orderView.getBtnReceipt().addActionListener(this);
        df2.format(total);
        try {
            pw = new PrintWriter("receipt.txt","UTF-8");
            initialAddToReceipt();
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "File could not be found");
        }
    }

    public void actionPerformed(ActionEvent e){
        if (e.getSource() == orderView.getBtnCard()){
            JOptionPane.showMessageDialog(null, "Swipe customer card at terminal");
        }else if (e.getSource() == orderView.getBtnCash()){
            JOptionPane.showMessageDialog(null, "Receive customer cash for the displayed total.");
        } else if (e.getSource() == orderView.getBtnReceipt()){
            printReceipt(total);
            JOptionPane.showMessageDialog(null, "Printing the receipt to file receipt.txt");
        }
    }

    public void updateOrderView(ArrayList<Product> a){
        ArrayList<JPanel> jPanelArrayList = new ArrayList<JPanel>();

        for(int i = 0; i < a.size(); i++) {
            Product p = a.get(i);
            total += a.get(i).getPrice() * a.get(i).getQuantity();

            stringbuilder = p.getID() + " | " + p.getName() + " | " + p.getQuantity() + " | $" + p.getPrice();
            JPanel panel = new JPanel();
            panel.add(new JLabel(stringbuilder));
            jPanelArrayList.add(i,panel);
        }
        addToReceipt(stringbuilder);
        orderView.AddPanels(jPanelArrayList,total);
    }

    public void initialAddToReceipt() {
        pw.println("ID| Name| Quantity| Price");
        pw.println("-------------------------");
    }

    public void addToReceipt(String items) {
        pw.println(items);
    }
    public void printReceipt(double total) {
        pw.println("Total: $" + total);
        pw.close();
    }
}
