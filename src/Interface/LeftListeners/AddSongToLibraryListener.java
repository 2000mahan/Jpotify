package Interface.LeftListeners;

import GUI.CustomButton;
import GUI.Left.FileOrDirectoryChooser;
import Logic.Entity.Library.Library;
import Logic.Save;
import com.mpatric.mp3agic.InvalidDataException;
import com.mpatric.mp3agic.UnsupportedTagException;

import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.nio.file.Files;

/**
 * This listener is used for adding songs to library.
 * @author Aryan
 * @version 1.0
 */
public class AddSongToLibraryListener implements ActionListener {

    private Library library;
    private Save  librarySave;

    /**
     * Constructor.
     * @param library
     * @param librarySave
     */
    public AddSongToLibraryListener(Library library, Save librarySave){

        this.library = library;
        this.librarySave = librarySave;

    }

    /**
     * Add song to library.
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        FileOrDirectoryChooser fileOrDirectoryChooser = new FileOrDirectoryChooser();
        String path = fileOrDirectoryChooser.getSongFile().getAbsolutePath();
        int lastIndexOf = path.lastIndexOf(".");
        String extension = path.substring(lastIndexOf);
        if (extension.equals(".mp3")) {
            try {
                library.addSongToLibrary(fileOrDirectoryChooser.getSongFile().getAbsolutePath());
            } catch (IOException e1) {
                e1.printStackTrace();
            } catch (InvalidDataException e1) {
                e1.printStackTrace();
            } catch (UnsupportedTagException e1) {
                e1.printStackTrace();
            } catch (UnsupportedAudioFileException e1) {
                e1.printStackTrace();
            }
        }
        else{
            JFrame frame = new JFrame("Error");
            JButton ok = new JButton("Ok");
            JLabel label = new JLabel("Wrong file selected!", SwingConstants.CENTER);
            ok.setContentAreaFilled(false);
            ok.setForeground(Color.black);
            ok.setFocusPainted(false);
           // ok.setBorderPainted(false);
            Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
            frame.setSize(new Dimension(200, 100));
            frame.setLocation(dimension.width/2 - frame.getWidth()/2, dimension.height/2 - frame.getWidth()/2);
            label.setForeground(Color.RED);
            ok.setBackground(Color.black);
            frame.setLayout(new BorderLayout());
            frame.add(ok, BorderLayout.SOUTH);
            frame.add(label, BorderLayout.CENTER);
            ok.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    frame.setVisible(false);
                    frame.dispose();
                }
            });
            frame.setVisible(true);
        }
        librarySave.save(this.library);
    }
}
