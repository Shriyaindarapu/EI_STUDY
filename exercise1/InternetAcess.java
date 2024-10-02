
interface OfficeInternetAccess {
    void grantAccess();
}

class RealInternetAccess implements OfficeInternetAccess {
    private String employeeName;

    public RealInternetAccess(String employeeName) {
        this.employeeName = employeeName;
    }

    @Override
    public void grantAccess() {
        System.out.println("Internet Access granted to employee: " + employeeName);
    }
}

class ProxyInternetAccess implements OfficeInternetAccess {
    private String employeeName;
    private RealInternetAccess realAccess;

    public ProxyInternetAccess(String employeeName) {
        this.employeeName = employeeName;
    }

    @Override
    public void grantAccess() {
        if (getRole(employeeName).equalsIgnoreCase("Manager")) {
            realAccess = new RealInternetAccess(employeeName);
            realAccess.grantAccess();
        } else {
            System.out.println("No Internet access granted. Your role is insufficient.");
        }
    }

    private String getRole(String employeeName) {
        // Simulate employee role lookup
        if (employeeName.equalsIgnoreCase("John")) {
            return "Manager";
        }
        return "Employee";
    }
}

public class ProxyPatternDemo {
    public static void main(String[] args) {
        OfficeInternetAccess access = new ProxyInternetAccess("John");
        access.grantAccess();

        access = new ProxyInternetAccess("Doe");
        access.grantAccess();
    }
}
