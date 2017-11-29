import javax.swing.*;
import java.awt.*;

public class ProfileView extends JFrame {

    private JTextField txtPassword = new JTextField(20);

    private JButton btnUpdatePass = new JButton("Update Password");
    private JButton btnUpdatePhoto = new JButton("Change Picture");

    private ImageIcon profPic = new ImageIcon();
    private JLabel profPicLabel = new JLabel(profPic);

    public ProfileView() {
        this.setTitle("Profile");
        this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.PAGE_AXIS));
        //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 250);
        this.setLocation(300, 250);

        updatePanels();
    }

    public JButton getBtnUpdatePass() {
        return btnUpdatePass;
    }

    public JButton getBtnUpdatePhoto() {
        return btnUpdatePhoto;
    }

    public JTextField getTxtPassword() {
        return txtPassword;
    }

    public void setProfPic(String profPic) {
        this.getContentPane().removeAll();
        updatePanels();
        this.profPic = new ImageIcon(profPic);
        this.profPic.getScaledInst
        this.profPicLabel = new JLabel(this.profPic);

        revalidate();
        repaint();
    }

    public void updatePanels(){

        JLabel title = new JLabel("Profile");
        title.setFont(new Font("Sans Serif", Font.BOLD, 20));
        JPanel panelTitle = new JPanel();
        panelTitle.add(title);
        this.getContentPane().add(panelTitle);

        JPanel imagePanel = new JPanel();
        profPicLabel.setSize(100,100);
        imagePanel.add(profPicLabel);
        this.getContentPane().add(imagePanel);

        JPanel panelPassword = new JPanel();
        panelPassword.add(new JLabel("Password: "));
        panelPassword.add(txtPassword);
        this.getContentPane().add(panelPassword);

        JPanel panelButton = new JPanel();
        panelButton.add(btnUpdatePass);
        panelButton.add(btnUpdatePhoto);
        this.getContentPane().add(panelButton);
    }
}
