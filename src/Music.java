import javax.sound.sampled.*;
import java.io.IOException;

public class Music {
    private Clip clip;

    public void addMusic() {

        try (AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(this.getClass().getResource("/music.wav"))) {
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);

            //clip.loop(Clip.LOOP_CONTINUOUSLY);

        } catch (IOException | UnsupportedAudioFileException | LineUnavailableException e) {
            e.printStackTrace();

        }

    }
    public void startMusic(){
        clip.start();
    }
    public void stopMusic()  {

      //  try (AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(this.getClass().getResource("/music.wav"))) {
          //  clip = AudioSystem.getClip();
          //  clip.open(audioInputStream);
            clip.stop();


      //////  }
    }
}
