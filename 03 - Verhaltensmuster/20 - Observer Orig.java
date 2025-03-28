class WeatherStation {
    private float temperature;
    private float humidity;
    private PhoneDisplay phoneDisplay;
    private WebDisplay webDisplay;
    private MonitorDisplay monitorDisplay;
    
    public WeatherStation() {
        phoneDisplay = new PhoneDisplay();
        webDisplay = new WebDisplay();
        monitorDisplay = new MonitorDisplay();
    }
    
    public void setMeasurements(float temperature, float humidity) {
        this.temperature = temperature;
        this.humidity = humidity;
        
        // Need to call each display manually
        phoneDisplay.update(temperature, humidity);
        webDisplay.update(temperature, humidity);
        monitorDisplay.update(temperature, humidity);
    }
}

class PhoneDisplay {
    public void update(float temperature, float humidity) {
        System.out.println("Phone Display: Temperature is " + temperature + 
                         "°C and Humidity is " + humidity + "%");
    }
}

class WebDisplay {
    public void update(float temperature, float humidity) {
        System.out.println("Web Display: Temperature is " + temperature + 
                         "°C and Humidity is " + humidity + "%");
    }
}

class MonitorDisplay {
    public void update(float temperature, float humidity) {
        System.out.println("Monitor Display: Temperature is " + temperature + 
                         "°C and Humidity is " + humidity + "%");
    }
}

class Main {
    public static void main(String[] args) {
        WeatherStation weatherStation = new WeatherStation();
        
        // Weather changes
        System.out.println("Weather update 1:");
        weatherStation.setMeasurements(25.2f, 65.0f);
        
        System.out.println("\nWeather update 2:");
        weatherStation.setMeasurements(26.5f, 70.0f);
    }
}