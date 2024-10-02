
import java.util.ArrayList;
import java.util.List;
interface Observer {
    void update(float temperature);
}

class WeatherStation {
    private List<Observer> observers = new ArrayList<>();
    private float temperature;

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
        notifyObservers();
    }

    private void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(temperature);
        }
    }
}

class PhoneDisplay implements Observer {
    private float temperature;

    @Override
    public void update(float temperature) {
        this.temperature = temperature;
        System.out.println("Phone Display: Temperature updated to " + temperature);
    }
}

class TVDisplay implements Observer {
    private float temperature;

    @Override
    public void update(float temperature) {
        System.out.println("TV Display: Temperature updated to " + temperature);
    }
}public class WeatherStationDemo {
    public static void main(String[] args) {
        WeatherStation station = new WeatherStation();
        PhoneDisplay phoneDisplay = new PhoneDisplay();
        TVDisplay tvDisplay = new TVDisplay();

        station.addObserver(phoneDisplay);
        station.addObserver(tvDisplay);

        station.setTemperature(25.5f);
        station.setTemperature(30.0f);
    }
}
