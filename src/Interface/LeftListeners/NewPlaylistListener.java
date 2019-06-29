package Interface.LeftListeners;

import Logic.Entity.Library.Library;
import Logic.Entity.PlayList.PlayList;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 * Makes a playlist when clicked.
 * @author Aryan
 * @version 1.0
 */
public class NewPlaylistListener implements ActionListener {

    private Library library;
    private PlayList playList;
    private String name;

    public NewPlaylistListener(Library library){

     this.library = library;


    }

    /**
     * Makes a play list.
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {

    String playlistName = JOptionPane.showInputDialog("Enter A name for Playlist");
    PlayList playList = new PlayList(playlistName);


    }
}
