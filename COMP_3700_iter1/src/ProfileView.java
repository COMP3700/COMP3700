import javax.swing.*;
import java.awt.*;

public class ProfileView extends JFrame {

    private JTextField txtPassword = new JTextField(20);

    private JButton btnUpdatePass = new JButton("Update Password");

    public ProfileView() {
        this.setTitle("Profile");
        this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.PAGE_AXIS));
        //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 250);
        this.setLocation(300, 250);

        JLabel title = new JLabel("Profile");
        title.setFont(new Font("Sans Serif", Font.BOLD, 20));
        JPanel panelTitle = new JPanel();
        panelTitle.add(title);
        this.getContentPane().add(panelTitle);

        JPanel panelPassword = new JPanel();
        panelPassword.add(new JLabel("Password: "));
        panelPassword.add(txtPassword);
        this.getContentPane().add(panelPassword);

        JPanel panelButton = new JPanel();
        panelButton.add(btnUpdatePass);
        this.getContentPane().add(panelButton);
    }

    public JButton getBtnUpdatePass() {
        return btnUpdatePass;
    }

    public JTextField getTxtPassword() {
        return txtPassword;
    }
}
