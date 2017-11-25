import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddUserController implements ActionListener {

    private AddUserView addUserView;
    private DataAdapter dataAdapter;

    public AddUserController(AddUserView addUserView, DataAdapter dataAdapter) {
        this.addUserView = addUserView;
        this.dataAdapter = dataAdapter;
        this.addUserView.getBtnAddUser().addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        Employee em = new Employee();
        em.setUsername(addUserView.getTxtUsername().getText());
        em.setName(addUserView.getTxtName().getText());
        em.setPassword(addUserView.getTxtPassword().getText());
        int isManager;
        try {
            isManager = Integer.parseInt(addUserView.getIntIsManager().getText());
        }
        catch (NumberFormatException err) {
            JOptionPane.showMessageDialog(null, "Invalid Manager Status! Please provide a valid status (0 or 1)!");
            return;
        }
        em.setIsManager(isManager);
        em.setEmployeeID(Application.getInstance().getLargestEmployeeID());
        dataAdapter.addUser(em);
    }
}
