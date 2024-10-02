import java.util.*;

// Observer Pattern
interface DeviceObserver {
    void update();
}

abstract class SmartDevice {
    protected String id;
    protected String status;

    public SmartDevice(String id) {
        this.id = id;
        this.status = "off";
    }

    public abstract void performAction(String action);
}

class Light extends SmartDevice {
    public Light(String id) {
        super(id);
    }

    @Override
    public void performAction(String action) {
        if (action.equalsIgnoreCase("turnOn")) {
            status = "on";
        } else {
            status = "off";
        }
        System.out.println("Light " + id + " is " + status);
    }
}

class Thermostat extends SmartDevice {
    private int temperature;

    public Thermostat(String id) {
        super(id);
        this.temperature = 70;
    }

    @Override
    public void performAction(String action) {
        System.out.println("Thermostat " + id + " set to " + temperature + " degrees.");
    }
}
class DeviceFactory {
    public static SmartDevice createDevice(String type, String id) {
        switch (type) {
            case "light":
                return new Light(id);
            case "thermostat":
                return new Thermostat(id);
            default:
                return null;
        }
    }
}

// Proxy Pattern
class DeviceProxy extends SmartDevice {
    private SmartDevice realDevice;

    public DeviceProxy(SmartDevice realDevice) {
        super(realDevice.id);
        this.realDevice = realDevice;
    }

    @Override
    public void performAction(String action) {
        if (hasAccess()) {
            realDevice.performAction(action);
        } else {
            System.out.println("Access denied to device: " + id);
        }
    }

    private boolean hasAccess() {
        // Simulating access control
        return true;
    }
}

public class SmartHomeSystem {
    public static void main(String[] args) {
        SmartDevice light1 = DeviceFactory.createDevice("light", "1");
        SmartDevice thermostat = DeviceFactory.createDevice("thermostat", "2");

        DeviceProxy proxyLight = new DeviceProxy(light1);
        DeviceProxy proxyThermostat = new DeviceProxy(thermostat);

        proxyLight.performAction("turnOn");
        proxyThermostat.performAction("setTemperature");
    }
}

