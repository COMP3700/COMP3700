import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class OrderController implements ActionListener{
    private  OrderView orderView;

    public OrderController(OrderView orderView){
        this.orderView = orderView;
        orderView.getBtnCard().addActionListener(this);
        orderView.getBtnCash().addActionListener(this);
    }

    public void actionPerformed(ActionEvent e){
        if (e.getSource() == orderView.getBtnCard()){
            JOptionPane.showMessageDialog(null, "Swipe customer card at terminal");
        }if (e.getSource() == orderView.getBtnCash()){
            JOptionPane.showMessageDialog(null, "Receive customer cash for the displayed total.");
        }
    }

    public void updateOrderView(ArrayList<Product> a){
        ArrayList<JPanel> jPanelArrayList = new ArrayList<JPanel>();
        double total = 0;
        for(int i = 0; i < a.size(); i++) {
            Product p = a.get(i);
            total += a.get(i).getPrice() * a.get(i).getQuantity();
            String stringbuilder = new String();
            stringbuilder = p.getID() + " | " + p.getName() + " | " + p.getQuantity() + " | $" + p.getPrice();
            JPanel panel = new JPanel();
            panel.add(new JLabel(stringbuilder));
            jPanelArrayList.add(i,panel);
        }
        orderView.AddPanels(jPanelArrayList,total);
    }
}
