package Interface.DownListeners;

import Logic.Audio.Audio;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This listener is used for play and pause.
 * @author Aryan
 * @version 1.0
 */
public class PlayAndPauseListener implements ActionListener {

    private Audio audio;
    private JButton button;

    /**
     * Constructor.
     * @param audio
     * @param button
     */
    public PlayAndPauseListener(Audio audio, JButton button){
        this.audio = audio;
        this.button = button;
    }

    /**
     * Do some actions when clicked.
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if(!audio.isPaused()) {
            audio.setPaused(true);
            audio.mp3Pause();
            button.setText("\u25B6\uFE0F");
            button.validate();
        } else {
            audio.setPaused(false);
            audio.mp3Resume();
            button.setText("\u23F8");
            button.validate();
        }

    }
}
