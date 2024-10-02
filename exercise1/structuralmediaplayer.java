interface MediaPlayer {
    void play(String audioType, String fileName);
}

class MP3Player implements MediaPlayer {
    @Override
    public void play(String audioType, String fileName) {
        if (audioType.equalsIgnoreCase("mp3")) {
            System.out.println("Playing mp3 file: " + fileName);
        } else {
            System.out.println("Invalid media format");
        }
    }
}

class MediaAdapter implements MediaPlayer {
    AdvancedMediaPlayer advancedMediaPlayer;

    public MediaAdapter(String audioType) {
        if (audioType.equalsIgnoreCase("vlc")) {
            advancedMediaPlayer = new VLCPlayer();
        } else if (audioType.equalsIgnoreCase("mp4")) {
            advancedMediaPlayer = new MP4Player();
        }
    }

    @Override
    public void play(String audioType, String fileName) {
        if (audioType.equalsIgnoreCase("vlc")) {
            advancedMediaPlayer.playVLC(fileName);
        } else if (audioType.equalsIgnoreCase("mp4")) {
            advancedMediaPlayer.playMP4(fileName);
        }
    }
}

interface AdvancedMediaPlayer {
    void playVLC(String fileName);
    void playMP4(String fileName);
}

class VLCPlayer implements AdvancedMediaPlayer {
    @Override
    public void playVLC(String fileName) {
        System.out.println("Playing VLC file: " + fileName);
    }

    @Override
    public void playMP4(String fileName) {
        // Do nothing
    }
}

class MP4Player implements AdvancedMediaPlayer {
    @Override
    public void playMP4(String fileName) {
        System.out.println("Playing MP4 file: " + fileName);
    }

    @Override
    public void playVLC(String fileName) {
        // Do nothing
    }
}

public class AdapterPatternDemo {
    public static void main(String[] args) {
        MediaPlayer player = new MP3Player();
        player.play("mp3", "song.mp3");

        player = new MediaAdapter("mp4");
        player.play("mp4", "movie.mp4");

        player = new MediaAdapter("vlc");
        player.play("vlc", "video.vlc");
    }
}
