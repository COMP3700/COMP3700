import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainScreen extends JFrame {

    private JButton btnCheckout = new JButton("Checkout");
    private JButton btnManage   = new JButton("Manage Product");
    private JButton btnLogin = new JButton("Login");
    private JButton btnLookupOrder = new JButton("Lookup Orders");

    public MainScreen() {
        this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(450, 300);
        this.setLocationRelativeTo(null);

        btnManage.setPreferredSize(new Dimension(150, 50));
        btnCheckout.setPreferredSize(new Dimension(150, 50));
        btnLogin.setPreferredSize(new Dimension(150,50));
        btnLookupOrder.setPreferredSize(new Dimension(150, 50));


        JLabel title = new JLabel("Store Management System");
        title.setFont(new Font("Sans Serif", Font.BOLD, 24));
        JPanel panelTitle = new JPanel();
        panelTitle.add(title);
        this.getContentPane().add(panelTitle);

        JPanel panelButton = new JPanel();
        panelButton.add(btnCheckout);
        panelButton.add(btnManage);
        panelButton.add(btnLogin);
        panelButton.add(btnLookupOrder);

        this.getContentPane().add(panelButton);

        btnCheckout.addActionListener(new ActionListener() { // when controller is simple, we can declare it on the fly
            public void actionPerformed(ActionEvent e) {
                Application.getInstance().getCheckoutView().setVisible(true);
                Application.getInstance().getOrderView().setVisible(true);
            }
        });

        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Application.getInstance().getLoginView().setVisible(true);
            }
        });


        btnManage.addActionListener(new ActionListener() { // when controller is simple, we can declare it on the fly
            public void actionPerformed(ActionEvent e) {
                Application.getInstance().getProductView().setVisible(true);
            }
        });

        btnLookupOrder.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Application.getInstance().getLookupView().setVisible(true);
            }
        });
    }


}
