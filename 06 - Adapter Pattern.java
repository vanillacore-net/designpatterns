// Target interface
interface MediaPlayer {
    void play(String filename);
}

// Existing MP3 player
class MP3Player implements MediaPlayer {
    public void play(String filename) {
        System.out.println("Playing MP3 file: " + filename);
    }
}

// Modern player (Adaptee)
class ModernPlayer {
    public void playMP4(String filename) {
        System.out.println("Playing MP4 file: " + filename);
    }
}

// Adapter
class ModernPlayerAdapter implements MediaPlayer {
    private ModernPlayer modernPlayer;
    
    public ModernPlayerAdapter(ModernPlayer player) {
        this.modernPlayer = player;
    }
    
    @Override
    public void play(String filename) {
        if (filename.endsWith(".mp4")) {
            modernPlayer.playMP4(filename);
        } else {
            System.out.println("Invalid media format");
        }
    }
}

class Client {
    public static void main(String[] args) {
        MediaPlayer player = new MP3Player();
        MediaPlayer modernPlayerAdapter = 
            new ModernPlayerAdapter(
                new ModernPlayer());
        
        // Unified interface for all players
        player.play("song.mp3");
        modernPlayerAdapter.play("video.mp4");
        
        // Can handle any player through the same interface
        playMedia("song.mp3", player);
        playMedia("video.mp4", modernPlayerAdapter);
    }
    
    public static void playMedia(
        String filename, MediaPlayer player) {
        player.play(filename);
    }
}