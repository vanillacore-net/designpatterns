interface MediaPlayer {
    void playMP3(String filename);
}

class MP3Player implements MediaPlayer {
    public void playMP3(String filename) {
        System.out.println("Playing MP3 file: " + filename);
    }
}

// New advanced player with different interface
class ModernPlayer {
    public void playMP4(String filename) {
        System.out.println("Playing MP4 file: " + filename);
    }
}

class Client {
    public static void main(String[] args) {
        MP3Player mp3Player = new MP3Player();
        ModernPlayer mp4Player = new ModernPlayer();
        
        mp3Player.playMP3("song.mp3");
        mp4Player.playMP4("video.mp4");

        playMedia("song.mp3", mp3Player);
        playMedia("video.mp4", mp4Player);
    }

    public static void playMedia(
        String filename, MediaPlayer player) {
        player.playMP3(filename);
    }

    public static void playMedia(
        String filename, ModernPlayer player) {
        player.playMP4(filename);
    }
}
