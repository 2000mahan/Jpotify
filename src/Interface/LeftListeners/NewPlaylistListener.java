package Interface.LeftListeners;

import Logic.Entity.Library.Library;
import Logic.Entity.PlayList.PlayList;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class NewPlaylistListener implements ActionListener {

    private Library library;
    private PlayList playList;
    private String name;

    public NewPlaylistListener(Library library){

     this.library = library;


    }
    @Override
    public void actionPerformed(ActionEvent e) {

    String playlistName = JOptionPane.showInputDialog("Enter A name for Playlist");
    PlayList playList = new PlayList(playlistName);


    }
}
