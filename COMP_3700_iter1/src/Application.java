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

    private ProductView productView;

    private CheckoutView checkoutView;

    private MainScreen mainScreen;

    private  OrderView orderView;

    private OrderController orderController;

    public MainScreen getMainScreen() {
        return mainScreen;
    }

    public ProductView getProductView() {
        return productView;
    }

    public CheckoutView getCheckoutView() { return checkoutView; }

    public OrderView getOrderView() { return  orderView;  }

    private CheckoutController checkoutController;

    private ProductController productController;

    public ProductController getProductController() {
        return productController;
    }

    public CheckoutController getCheckoutController() {
        return checkoutController;
    }

    public DataAdapter getDataAdapter() {
        return dataAdapter;
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

        // Create the Product View and Controller here!

        productView = new ProductView();

        checkoutView = new CheckoutView();

        orderView = new OrderView();

        orderController = new OrderController(orderView);

        checkoutController = new CheckoutController(checkoutView, dataAdapter, orderController);

        productController = new ProductController(productView, dataAdapter);

        mainScreen = new MainScreen();



    }


    public static void main(String[] args) {
        Application.getInstance().getMainScreen().setVisible(true);
    }
}
