import javax.swing.*;
import java.sql.*;

public class DataAdapter {
    private Connection connection;

    public DataAdapter(Connection connection) {
        this.connection = connection;
    }

    public Product loadProduct(int id) {
        try {
            String query = "SELECT * FROM Product WHERE ProductID = " + id;

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            if (resultSet.next()) {
                Product product = new Product();
                product.setID(resultSet.getInt(1));
                product.setName(resultSet.getString(2));
                product.setPrice(resultSet.getDouble(3));
                product.setQuantity(resultSet.getInt(4));
                resultSet.close();
                statement.close();

                return product;
            }

        } catch (SQLException e) {
            System.out.println("Database access error!");
            e.printStackTrace();
        }
        return null;
    }

    public void saveProduct(Product product) {
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM Product WHERE ProductID = ?");
            statement.setInt(1, product.getID());

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) { // this product exists, update its fields
                statement = connection.prepareStatement("UPDATE Product SET Name = ?, Price = ?, Quantity = ? WHERE ProductID = ?");
                statement.setString(1, product.getName());
                statement.setDouble(2, product.getPrice());
                statement.setDouble(3, product.getQuantity());
                statement.setInt(4, product.getID());
            }
            else { // this product does not exist, use insert into
                statement = connection.prepareStatement("INSERT INTO Product VALUES (?, ?, ?, ?)");
                statement.setString(2, product.getName());
                statement.setDouble(3, product.getPrice());
                statement.setDouble(4, product.getQuantity());
                statement.setInt(1, product.getID());
            }
            statement.execute();

            resultSet.close();
            statement.close();

        } catch (SQLException e) {
            System.out.println("Database access error!");
            e.printStackTrace();
        }
    }

    public void saveOrder(Product product) {
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM Product WHERE ProductID = ?");
            statement.setInt(1, product.getID());

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) { // this product exists, update its fields
                statement = connection.prepareStatement("UPDATE Product SET Name = ?, Price = ?, Quantity = ? WHERE ProductID = ?");
                statement.setString(1, product.getName());
                statement.setDouble(2, product.getPrice());
                statement.setDouble(3, product.getQuantity());
                statement.setInt(4, product.getID());
            }
            else { // this product does not exist, use insert into
                statement = connection.prepareStatement("INSERT INTO Product VALUES (?, ?, ?, ?)");
                statement.setString(2, product.getName());
                statement.setDouble(3, product.getPrice());
                statement.setDouble(4, product.getQuantity());
                statement.setInt(1, product.getID());
            }
            statement.execute();

            resultSet.close();
            statement.close();

        } catch (SQLException e) {
            System.out.println("Database access error!");
            e.printStackTrace();
        }
    }

    public Employee loginUser(String userName, String password) {
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM Employees WHERE UserName = ? AND EmployeePassword = ?");
            statement.setString(1, userName);
            statement.setString(2, password);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) { // this user exists, load menu
                Employee employee = new Employee();
                employee.setEmployeeID(resultSet.getInt(1));
                employee.setUsername(resultSet.getString(2));
                employee.setName(resultSet.getString(3));
                employee.setPassword(resultSet.getString(4));
                employee.setIsManager(resultSet.getInt(5));
                return employee;
            } else {
                JOptionPane.showMessageDialog(null, "Invalid Employee login! Please try again.");

            }

        } catch (SQLException e) {
            System.out.println("Database access error!");
            e.printStackTrace();
        }

        return null;
    }

    public void updatePassword(String newPassword, Employee employee) {
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM Employees WHERE EmployeeID = ?");
            statement.setInt(1, employee.getEmployeeID());
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                statement = connection.prepareStatement("UPDATE Employees SET EmployeePassword = ? WHERE EmployeeID = ?");
                statement.setString(1, newPassword);
                statement.setInt(2, employee.getEmployeeID());

            } else {
                JOptionPane.showMessageDialog(null, "Employee Not found in database. Cannot update password");
            }

            statement.execute();

            resultSet.close();
            statement.close();
            JOptionPane.showMessageDialog(null, "Password Updated");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }


    public void addUser(Employee employee) {
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM Employees WHERE UserName = ?");
            statement.setString(1, employee.getUsername());

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) { // this employee already exists, change user name
                JOptionPane.showMessageDialog(null, "Employee Username already exists! Please try again.");
            }
            else { // this employee does not exist, add user to database
                statement = connection.prepareStatement("INSERT INTO Employees VALUES (?, ?, ?, ?, ?)");
                statement.setString(2, employee.getUsername());
                statement.setString(3, employee.getName());
                statement.setString(4, employee.getPassword());
                statement.setInt(5, employee.getIsManager());
                statement.setInt(1, employee.getEmployeeID());
                JOptionPane.showMessageDialog(null, "Employee Successfully Added.");

            }
            statement.execute();
            Application.getInstance().updateLargestEmployeeID();
            resultSet.close();
            statement.close();

        } catch (SQLException e) {
            System.out.println("Database access error!");
            e.printStackTrace();
        }
    }


    public int getLargestEmployeeID() {
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT MAX(EmployeeID) FROM Employees");
            ResultSet resultSet = statement.executeQuery();
            return resultSet.getInt(1);
        } catch (SQLException e) {
            System.out.println("Database error! Could not get EmployeeID");
        }

        return -1;
    }
}
