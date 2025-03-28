// Observer interface
interface WeatherObserver {
    void update(float temperature, float humidity);
}

// Subject interface
interface WeatherSubject {
    void registerObserver(WeatherObserver observer);
    void removeObserver(WeatherObserver observer);
    void notifyObservers();
}

class WeatherStation implements WeatherSubject {
    private List<WeatherObserver> observers;
    private float temperature;
    private float humidity;
    
    public WeatherStation() {
        observers = new ArrayList<>();
    }
    
    @Override
    public void registerObserver(WeatherObserver observer) {
        observers.add(observer);
    }
    
    @Override
    public void removeObserver(WeatherObserver observer) {
        observers.remove(observer);
    }
    
    @Override
    public void notifyObservers() {
        for (WeatherObserver observer : observers) {
            observer.update(temperature, humidity);
        }
    }
    
    public void setMeasurements(float temperature, float humidity) {
        this.temperature = temperature;
        this.humidity = humidity;
        notifyObservers();
    }
}

class PhoneDisplay implements WeatherObserver {
    @Override
    public void update(float temperature, float humidity) {
        System.out.println("Phone Display: Temperature is " + temperature + 
                         "°C and Humidity is " + humidity + "%");
    }
}

class WebDisplay implements WeatherObserver {
    @Override
    public void update(float temperature, float humidity) {
        System.out.println("Web Display: Temperature is " + temperature + 
                         "°C and Humidity is " + humidity + "%");
    }
}

class EmailAlert implements WeatherObserver {
    @Override
    public void update(float temperature, float humidity) {
        System.out.println("Email Alert: Temperature is " + temperature + 
                         "°C and Humidity is " + humidity + "%");
    }
}

class Main {
    public static void main(String[] args) {
        WeatherStation weatherStation = new WeatherStation();
        
        // Create displays
        PhoneDisplay phoneDisplay = new PhoneDisplay();
        WebDisplay webDisplay = new WebDisplay();
        EmailAlert emailAlert = new EmailAlert();
        
        // Register displays with weather station
        weatherStation.registerObserver(phoneDisplay);
        weatherStation.registerObserver(webDisplay);
        weatherStation.registerObserver(emailAlert);
        
        // Weather changes
        System.out.println("Weather update 1:");
        weatherStation.setMeasurements(25.2f, 65.0f);
        
        System.out.println("\nRemoving web display...");
        weatherStation.removeObserver(webDisplay);
        
        System.out.println("\nWeather update 2:");
        weatherStation.setMeasurements(26.5f, 70.0f);
    }
}