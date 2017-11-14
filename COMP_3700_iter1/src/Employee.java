public class Employee {

    private int employeeID;
    private String name;
    private String username;
    private String password;
    private int isManager;

    public int getEmployeeID() {
        return employeeID;
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public int getIsManager() {
        return isManager;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public void setIsManager(int isManager) {
        this.isManager = isManager;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
