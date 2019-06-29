package Logic.Audio;

import Logic.Entity.Library.MetadataExtractorMachine.MetadataExtractorMachine;
import Logic.Entity.Song.Song;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.advanced.AdvancedPlayer;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class Audio implements Runnable{

   private boolean isPaused;
   private boolean isKilled;
   private AdvancedPlayer player;

   public Audio(String path) throws FileNotFoundException, JavaLayerException {
       isPaused = false;
       isKilled = false;
       player = new AdvancedPlayer(new FileInputStream(path));
   }

    @Override
    public void run() {

        while(!isKilled){
            try {

                if (!player.play(1)) break;
            } catch (JavaLayerException e) {
                e.printStackTrace();
            }
            if(isPaused) {
                synchronized (player) {
                    try {
                        player.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

    }
    public void mp3Pause() {
        this.isPaused = true;
    }
    public void mp3Resume() {
        this.isPaused = false;
        synchronized (player) {
            this.player.notifyAll();
        }
    }
    public void seekTo(int frame) throws JavaLayerException {
        synchronized (player) {
            this.player.close();
            this.player = new AdvancedPlayer();
            this.player.play(frame, frame + 1);
        }
    }

    public void setPaused(boolean paused) {
        isPaused = paused;
    }

    public void kill(){
       isKilled = true;
    }

    public boolean isPaused() {
        return isPaused;
    }
}