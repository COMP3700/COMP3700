import javax.swing.*;
import java.util.ArrayList;
import java.text.DecimalFormat;

public class OrderView extends JFrame{

    private JButton btnCard = new JButton("Card");
    private JButton btnCash = new JButton("Cash");
    private JButton btnReceipt = new JButton("Print Receipt");
    private JLabel totaltxt = new JLabel("0.00");

    ArrayList<JPanel> productList = new ArrayList<JPanel>();

    public OrderView() {
        this.setTitle("Order View");
        this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.PAGE_AXIS));
        this.setSize(300,  750);
        this.setLocation(750, 0);

        addDefaultPanels();

    }

    public JButton getBtnCard() {
        return btnCard;
    }

    public JButton getBtnCash() {
        return btnCash;
    }

    public JButton getBtnReceipt() {
        return btnReceipt;
    }

    public void AddPanels(ArrayList<JPanel> a, double total){
        this.getContentPane().removeAll();
        addDefaultPanels();
        for(int i = 0; i < a.size(); i++){
            this.getContentPane().add(a.get(i));
        }
        updateTotal(total);
        revalidate();
        repaint();
    }

    public void addDefaultPanels(){

        JPanel panelButton = new JPanel();
        panelButton.add(btnCard);
        panelButton.add(btnCash);
        panelButton.add(btnReceipt);
        this.getContentPane().add(panelButton);
        JPanel panelTotal = new JPanel();
        panelTotal.add(new JLabel("Total: $"));
        panelTotal.add(totaltxt);
        this.getContentPane().add(panelTotal);
        JPanel panelProductID = new JPanel();
        panelProductID.add(new JLabel("Product ID | "));
        this.getContentPane().add(panelProductID);
        panelProductID.add(new JLabel("Product Name | "));
        panelProductID.add(new JLabel("Quantity | "));
        panelProductID.add(new JLabel("Price"));

    }


    private static DecimalFormat df = new DecimalFormat(".##");

    public void updateTotal(double total) {
        totaltxt.setText("" +df.format(total));
    }


}
