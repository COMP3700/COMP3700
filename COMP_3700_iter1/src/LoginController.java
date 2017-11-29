import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginController implements ActionListener{

    private LoginView loginView;
    private DataAdapter dataAdapter;
    private Employee emp;

    public LoginController(LoginView loginView, DataAdapter dataAdapter) {
        this.loginView = loginView;
        this.dataAdapter = dataAdapter;
        loginView.getBtnLogin().addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        Application.getInstance().setEmployee(dataAdapter.loginUser(loginView.getTxtUsername().getText(), loginView.getTxtPassword().getText()));
       emp = dataAdapter.loginUser(loginView.getTxtUsername().getText(), loginView.getTxtPassword().getText());
        if (Application.getInstance().getEmployee() != null) {
            this.loginView.dispose();
            Application.getInstance().getMainScreen().setTitle(emp.getName());
            Application.getInstance().getMainScreen().setVisible(true);
            ProfileView profileView = new ProfileView();
            profileView.loadProfPic(emp);
        }
    }
}
