import javax.swing.*;

public class LoginView extends JFrame {

    private JTextField txtUsername = new JTextField(20);
    private JTextField txtPassword = new JTextField(20);

    private JButton btnLogin = new JButton("Login");

    public LoginView() {
        this.setTitle("Login View");
        this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.PAGE_AXIS));
        this.setSize(500, 200);
        this.setLocation(300,250);

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
