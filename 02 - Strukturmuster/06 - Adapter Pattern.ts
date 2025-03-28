// Target interface
interface MediaPlayer {
    play(filename: string): void;
}

// Existing MP3 player
class MP3Player implements MediaPlayer {
    public play(filename: string): void {
        console.log(`Playing MP3 file: ${filename}`);
    }
}

// Modern player (Adaptee)
class ModernPlayer {
    public playMP4(filename: string): void {
        console.log(`Playing MP4 file: ${filename}`);
    }
}

// Adapter
class ModernPlayerAdapter implements MediaPlayer {
    private modernPlayer: ModernPlayer;
    
    constructor(player: ModernPlayer) {
        this.modernPlayer = player;
    }
    
    public play(filename: string): void {
        if (filename.endsWith('.mp4')) {
            this.modernPlayer.playMP4(filename);
        } else {
            console.log('Invalid media format');
        }
    }
}

// Client code WITH pattern
class ClientWithAdapter {
    public static main(): void {
        const player: MediaPlayer = new MP3Player();
        const modernPlayerAdapter: MediaPlayer = new ModernPlayerAdapter(new ModernPlayer());
        
        // Unified interface for all players
        player.play('song.mp3');
        modernPlayerAdapter.play('video.mp4');
        
        // Can handle any player through the same interface
        ClientWithAdapter.playMedia('song.mp3', player);
        ClientWithAdapter.playMedia('video.mp4', modernPlayerAdapter);
    }
    
    // Can write methods that work with any player
    public static playMedia(filename: string, player: MediaPlayer): void {
        player.play(filename);
    }
}

// Execute the main method
ClientWithAdapter.main();