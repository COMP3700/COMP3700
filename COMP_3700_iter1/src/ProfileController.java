import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProfileController implements ActionListener {

    private ProfileView profileView;
    public ProfileController(ProfileView profileView) {
        this.profileView = profileView;
        this.profileView.getBtnUpdatePass().addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        // call update password
        Application.getInstance().getDataAdapter().updatePassword(this.profileView.getTxtPassword().getText(), Application.getInstance().getEmployee());
    }
}
