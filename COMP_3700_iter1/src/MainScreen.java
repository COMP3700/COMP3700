import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

public class MainScreen extends JFrame {

    private JButton btnCheckout = new JButton("Checkout");
    private JButton btnManage   = new JButton("Manage Product");
    private JButton btnSignOut = new JButton("Sign Out");
    private JButton btnLookupOrder = new JButton("Lookup Orders");
    private JButton btnAddUser = new JButton("Add User");
    private JButton btnProfile = new JButton("Profile");
    private MainScreen mainScreen;
    private int isManager = 0;

    public MainScreen() {
        this.mainScreen = this;
        this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(450, 350);
        this.setLocationRelativeTo(null);

        btnManage.setPreferredSize(new Dimension(150, 50));
        btnCheckout.setPreferredSize(new Dimension(150, 50));
        btnSignOut.setPreferredSize(new Dimension(150,50));
        btnLookupOrder.setPreferredSize(new Dimension(150, 50));
        btnAddUser.setPreferredSize(new Dimension(150, 50));
        btnProfile.setPreferredSize((new Dimension(150, 50)));


        JLabel title = new JLabel("Store Management System");
        title.setFont(new Font("Sans Serif", Font.BOLD, 24));
        JPanel panelTitle = new JPanel();
        panelTitle.add(title);
        this.getContentPane().add(panelTitle);

        JPanel panelButton = new JPanel();
        panelButton.add(btnCheckout);
        panelButton.add(btnManage);
        panelButton.add(btnLookupOrder);
        panelButton.add(btnAddUser);
        panelButton.add(btnSignOut);
        panelButton.add(btnProfile);

        this.getContentPane().add(panelButton);

        btnCheckout.addActionListener(new ActionListener() { // when controller is simple, we can declare it on the fly
            public void actionPerformed(ActionEvent e) {
                Application.getInstance().getCheckoutView().setVisible(true);
                Application.getInstance().getOrderView().setVisible(true);
            }
        });

        btnSignOut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Application.getInstance().getLoginView().setVisible(true);
                mainScreen.dispose();
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

        btnAddUser.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                    Application.getInstance().getAddUserView().setVisible(true);
            }
        });

        btnProfile.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Application.getInstance().getProfileView().loadProfPic(Application.getInstance().getEmployee());
                Application.getInstance().getProfileView().setVisible(true);
            }
        });
    }
}
