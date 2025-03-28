class TV {
    public void turnOn() {
        System.out.println("TV is ON");
    }
    
    public void turnOff() {
        System.out.println("TV is OFF");
    }
    
    public void setInput(String input) {
        System.out.println("TV input set to " + input);
    }
}

class SoundSystem {
    public void turnOn() {
        System.out.println("Sound System is ON");
    }
    
    public void turnOff() {
        System.out.println("Sound System is OFF");
    }
    
    public void setVolume(int level) {
        System.out.println("Volume set to " + level);
    }
    
    public void setSurroundSound(boolean enabled) {
        System.out.println("Surround sound: " + enabled);
    }
}

class BluRayPlayer {
    public void turnOn() {
        System.out.println("BluRay Player is ON");
    }
    
    public void turnOff() {
        System.out.println("BluRay Player is OFF");
    }
    
    public void play(String movie) {
        System.out.println("Playing " + movie);
    }
    
    public void stop() {
        System.out.println("Stopped playback");
    }
}

class Lights {
    public void dim() {
        System.out.println("Lights dimmed");
    }
    
    public void brighten() {
        System.out.println("Lights brightened");
    }
}

// Facade
class HomeTheaterFacade {
    private TV tv;
    private SoundSystem sound;
    private BluRayPlayer player;
    private Lights lights;
    
    public HomeTheaterFacade() {
        tv = new TV();
        sound = new SoundSystem();
        player = new BluRayPlayer();
        lights = new Lights();
    }
    
    public void watchMovie(String movie) {
        System.out.println("Starting movie night...");
        lights.dim();
        tv.turnOn();
        tv.setInput("HDMI1");
        sound.turnOn();
        sound.setVolume(20);
        sound.setSurroundSound(true);
        player.turnOn();
        player.play(movie);
    }
    
    public void endMovie() {
        System.out.println("Ending movie night...");
        player.stop();
        player.turnOff();
        sound.turnOff();
        tv.turnOff();
        lights.brighten();
    }
}

// Client code WITH pattern
class ClientWithFacade {
    public static void main(String[] args) {
        HomeTheaterFacade homeTheater = new HomeTheaterFacade();
        
        // Simple to use
        homeTheater.watchMovie("Great Movie");
        
        // Later...
        homeTheater.endMovie();
    }
}