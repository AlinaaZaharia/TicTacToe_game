import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

public class SoundManager {
    private static boolean on = true;
    public void setSound(boolean on)
    {
        this.on = on;
    }

    public boolean getSoundState() {
        return on;
    }

    public void disableSound() {
        setSound(false);
    }
    public void enableSound()
    {
        setSound(true);
    }

    public static void playButtonSound(boolean on) {
        if(on)
        {
            playSound("sound/button_sound.wav");
        }
    }

    public static void playButtonErrorSound(boolean on){
        if(on)
        {
            playSound("sound/error_button.wav");
        }
    }

    public static void congratulationSound(boolean on){
        if(on)
        {
            playSound("sound/congratulation_sound.wav");
        }
    }

    public static void noWinnerSound(boolean on)
    {
        if(on)
        {
            playSound("sound/noWinner.wav");
        }
    }

    private static void playSound(String soundFilePath) {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(soundFilePath).getAbsoluteFile());
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
