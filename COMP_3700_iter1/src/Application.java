import javax.swing.*;
import java.io.UnsupportedEncodingException;
import java.sql.*;

public class Application {

    private static Application instance;   // Singleton pattern

    public static Application getInstance() {
        if (instance == null) {
            instance = new Application();
        }
        return instance;
    }
    // Main components of this application

    private Connection connection;

    public Connection getConnection() {
        return connection;
    }

    private DataAdapter dataAdapter;

    private FileOpener fileOpener;

    private Employee employee;

    private int largestEmployeeID;

    public int getLargestEmployeeID() {
        return largestEmployeeID;
    }

    //Views

    private ProductView productView;

    private CheckoutView checkoutView;

    private MainScreen mainScreen;

    private OrderView orderView;

    private LoginView loginView;

    private LookupView lookupView;

    private AddUserView addUserView;

    private ProfileView profileView;

    public MainScreen getMainScreen() {
        return mainScreen;
    }

    public ProductView getProductView() {
        return productView;
    }

    public CheckoutView getCheckoutView() { return checkoutView; }

    public OrderView getOrderView() { return  orderView;  }

    public LoginView getLoginView() { return loginView; }

    public LookupView getLookupView() {
        return lookupView;
    }

    public AddUserView getAddUserView() {
        return addUserView;
    }

    public ProfileView getProfileView() {
        return profileView;
    }

    public void setMainScreen(MainScreen mainScreen) {
        this.mainScreen = mainScreen;
    }

    //Controllers

    private OrderController orderController;

    private LookupController lookupController;

    private CheckoutController checkoutController;

    private ProductController productController;

    private LoginController loginController;

    private AddUserController addUserController;

    private ProfileController profileController;

    public ProductController getProductController() {
        return productController;
    }

    public CheckoutController getCheckoutController() {
        return checkoutController;
    }

    public LoginController getLoginController() { return loginController; }

    public AddUserController getAddUserController() {
        return addUserController;
    }

    public ProfileController getProfileContrller() {
        return profileController;
    }

    public DataAdapter getDataAdapter() {
        return dataAdapter;
    }

    public FileOpener getFileOpener() {
        return fileOpener;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void updateLargestEmployeeID() {
        largestEmployeeID = dataAdapter.getLargestEmployeeID() + 1;

    }

    private Application() {
        // create SQLite database connection here!
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:store.db");
        }
        catch (ClassNotFoundException ex) {
            System.out.println("SQLite is not installed. System exits with error!");
            System.exit(1);
        }

        catch (SQLException ex) {
            System.out.println("SQLite database is not ready. System exits with error!");
            System.exit(2);
        }

        // Create data adapter here!
        dataAdapter = new DataAdapter(connection);

        fileOpener = new FileOpener();

        largestEmployeeID = dataAdapter.getLargestEmployeeID() + 1;

        // Views

        productView = new ProductView();

        checkoutView = new CheckoutView();

        orderView = new OrderView();

        loginView = new LoginView();

        lookupView = new LookupView();

        addUserView = new AddUserView();

        profileView = new ProfileView();

        //Controllers

        try {
            orderController = new OrderController(orderView);
        } catch (UnsupportedEncodingException e) {
            JOptionPane.showMessageDialog(null, "Could not create order!");
        }

        checkoutController = new CheckoutController(checkoutView, dataAdapter, orderController);

        productController = new ProductController(productView, dataAdapter);

        loginController = new LoginController(loginView, dataAdapter);

        lookupController = new LookupController();

        addUserController = new AddUserController(addUserView, dataAdapter);

        profileController = new ProfileController(profileView);

        mainScreen = new MainScreen();

    }


    public static void main(String[] args) {
        Application.getInstance().getLoginView().setVisible(true);
    }
}
