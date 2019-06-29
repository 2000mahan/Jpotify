package GUI.Left;

import javax.swing.*;
import java.io.File;

/**
 * This class is used for selecting directories for adding songs.
 * @author Aryan
 * @version 1.0
 */
public class FileOrDirectoryChooser {

    private File songFile;

    public FileOrDirectoryChooser() {

        JFileChooser fileChooser = new JFileChooser();
        int status = fileChooser.showOpenDialog(null);
        /*
        true when sth selected.
        false when cancel button selected.
         */
        if (status == JFileChooser.APPROVE_OPTION) {
            songFile = fileChooser.getSelectedFile();
        } else if (status == JFileChooser.CANCEL_OPTION) {
        }
    }

        public void setSongFile (File songFile){
            this.songFile = songFile;
        }

        public File getSongFile () {
            return songFile;
        }
    }
