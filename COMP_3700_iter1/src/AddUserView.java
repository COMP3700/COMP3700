import javax.swing.*;
import java.awt.*;

public class AddUserView extends JFrame {

    private JTextField txtUsername = new JTextField(20);
    private JTextField txtName = new JTextField(20);
    private JTextField txtPassword = new JTextField(20);
    private JTextField intIsManager = new JTextField(20);

    private JButton btnAddUser = new JButton("Add User");

    public AddUserView() {
        this.setTitle("Add User");
        this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.PAGE_AXIS));
        //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 250);
        this.setLocation(300,250);

        JLabel title = new JLabel("Add New User To System");
        title.setFont(new Font("Sans Serif", Font.BOLD, 20));
        JPanel panelTitle = new JPanel();
        panelTitle.add(title);
        this.getContentPane().add(panelTitle);

        JPanel panelUsername = new JPanel();
        panelUsername.add(new JLabel("Username: "));
        panelUsername.add(txtUsername);
        txtUsername.setHorizontalAlignment(JTextField.LEFT);
        this.getContentPane().add(panelUsername);

        JPanel panelName = new JPanel();
        panelName.add(new JLabel("Name: "));
        panelName.add(txtName);
        this.getContentPane().add(panelName);

        JPanel panelPassword = new JPanel();
        panelPassword.add(new JLabel("Password: "));
        panelPassword.add(txtPassword);
        this.getContentPane().add(panelPassword);

        JPanel panelIsManager = new JPanel();
        panelIsManager.add(new JLabel("Manager(0=no, 1=yes): "));
        panelIsManager.add(intIsManager);
        this.getContentPane().add(panelIsManager);



        JPanel panelButton = new JPanel();
        panelButton.add(btnAddUser);
        this.getContentPane().add(panelButton);
    }

    public JButton getBtnAddUser() {
        return btnAddUser;
    }

    public JTextField getTxtUsername() {
        return txtUsername;
    }

    public JTextField getTxtName() {
        return txtName;
    }

    public JTextField getTxtPassword() {
        return txtPassword;
    }

    public JTextField getIntIsManager() {
        return intIsManager;
    }
}
