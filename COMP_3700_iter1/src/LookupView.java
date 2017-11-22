import javax.swing.*;

public class LookupView extends JFrame{

        private JTextField txtUsername = new JTextField(20);
        private JTextField txtPassword = new JTextField(20);

        private JButton btnLogin = new JButton("Login");

        public LookupView() {
            this.setTitle("Lookup View");
            this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.PAGE_AXIS));
            this.setSize(500, 200);
            this.setLocation(300,250);

            JPanel panelUsername = new JPanel();
            panelUsername.add(new JLabel("Search by order # or product sold: "));
            panelUsername.add(txtUsername);
            txtUsername.setHorizontalAlignment(JTextField.LEFT);
            this.getContentPane().add(panelUsername);
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
