import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

public class LoginController implements ActionListener{

    private LoginView loginView;
    private DataAdapter dataAdapter;

    private JButton btnCheckout = new JButton("Checkout");
    private JButton btnManage   = new JButton("Manage Product");
    private JButton btnLookupOrder = new JButton("Lookup Orders");

    public LoginController(LoginView loginView, DataAdapter dataAdapter) {
        this.loginView = loginView;
        this.dataAdapter = dataAdapter;
        loginView.getBtnLogin().addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        Application.getInstance().setEmployee(dataAdapter.loginUser(loginView.getTxtUsername().getText(), loginView.getTxtPassword().getText()));
        if (Application.getInstance().getEmployee() != null) {
            Application.getInstance().getMainScreen().setVisible(true);
            this.loginView.dispose();
        }
    }
}
