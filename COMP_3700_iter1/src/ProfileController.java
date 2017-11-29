import javafx.stage.FileChooser;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProfileController implements ActionListener {

    private ProfileView profileView;
    public ProfileController(ProfileView profileView) {
        this.profileView = profileView;
        this.profileView.getBtnUpdatePass().addActionListener(this);
        this.profileView.getBtnUpdatePhoto().addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        // call update password
        if (e.getSource() == profileView.getBtnUpdatePass()) {
            Application.getInstance().getDataAdapter().updatePassword(this.profileView.getTxtPassword().getText(), Application.getInstance().getEmployee());
        }
        else if (e.getSource() == profileView.getBtnUpdatePhoto()) {
            JFileChooser c = new JFileChooser();
            int i = c.showOpenDialog(profileView);
            if (i == JFileChooser.APPROVE_OPTION) {
                profileView.setProfPic(c.getSelectedFile().toString());
                Application.getInstance().getDataAdapter().storeProfilePictureLink(c.getSelectedFile().toString(), Application.getInstance().getEmployee().getEmployeeID());
            }
        }
    }
}
