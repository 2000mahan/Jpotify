package GUI.Left;

import javax.swing.*;
import java.io.File;

public class FileOrDirectoryChooser {

    private File songFile;

    public FileOrDirectoryChooser() {

        JFileChooser fileChooser = new JFileChooser();
        int status = fileChooser.showOpenDialog(null);
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
