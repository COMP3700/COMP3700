import javax.swing.*;
import java.awt.*;

public class LoginView extends JFrame {

    private JTextField txtUsername = new JTextField(20);
    private JTextField txtPassword = new JTextField(20);

    private JButton btnLogin = new JButton("Sign In");

    public LoginView() {
        this.setTitle("Sign In View");
        this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.PAGE_AXIS));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 200);
        this.setLocation(300,250);

        JLabel title = new JLabel("Sign In To Store Management System");
        title.setFont(new Font("Sans Serif", Font.BOLD, 20));
        JPanel panelTitle = new JPanel();
        panelTitle.add(title);
        this.getContentPane().add(panelTitle);

        JPanel panelUsername = new JPanel();
        panelUsername.add(new JLabel("Username: "));
        panelUsername.add(txtUsername);
        txtUsername.setHorizontalAlignment(JTextField.LEFT);
        this.getContentPane().add(panelUsername);

        JPanel panelPassword = new JPanel();
        panelPassword.add(new JLabel("Password: "));
        panelPassword.add(txtPassword);
        this.getContentPane().add(panelPassword);
        txtPassword.setEnabled(true);

        JPanel panelButton = new JPanel();
        panelButton.add(btnLogin);
        this.getContentPane().add(panelButton);
    }

    public JButton getBtnLogin() {
        return btnLogin;
    }

    public JTextField getTxtUsername() {
        return txtUsername;
    }

    public JTextField getTxtPassword() {
        return txtPassword;
    }
}
