package GUI.Left;

import GUI.Center.Center;
import GUI.Down.Down;
import javazoom.jl.decoder.JavaLayerException;

import javax.swing.*;
import java.awt.*;
import java.io.FileNotFoundException;

public class Left extends JPanel {
  private Icons icons;
  private PlayLists playLists;
  private Artwork artwork;

  public Left(Center center, Down down) throws FileNotFoundException, JavaLayerException {
    super();
    this.setLayout(new GridBagLayout());
    GridBagConstraints gbc = new GridBagConstraints();
    gbc.weightx = 0.1;
    gbc.weighty = 0.1;
    gbc.gridx = 0;
    gbc.gridy = 0;
    this.add(icons = new Icons(center, down, this), gbc);
    gbc.gridx = 0;
    gbc.gridy = 1;
    this.add(playLists = new PlayLists(), gbc);
    gbc.gridx = 0;
    gbc.gridy = 2;
    this.add(artwork = new Artwork(), gbc);
    this.setBackground(Color.black);
  }

  public Artwork getArtwork() {
    return artwork;
  }

  public PlayLists getPlayLists() {
    return playLists;
  }

  public Icons getIcons() {
    return icons;
  }
}