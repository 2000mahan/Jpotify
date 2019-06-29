package Logic.Entity.Library.MetadataExtractorMachine;

import com.mpatric.mp3agic.*;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * MetadataExtractorMachine class simply extracts datas according to ID3V1 and ID3V2 standards
 * @author Mahan
 * @version 7.0
 * @since 06/15/2019
 */
public class MetadataExtractorMachine {
    private String titleNameData;
    private String artistNameData;
    private String albumNameData;

    public MetadataExtractorMachine() {

    }

    /**
     * extracting datas according to ID3V1 standard
     * @param songFile is a File
     * @return ArrayList<String>
     */
    private ArrayList<String> findID3V1Metadata(File songFile) throws IOException {
        ArrayList<String> usefulDataHolder = new ArrayList<>();

        try {
            Mp3File mp3file = new Mp3File(songFile.getAbsolutePath());
            ID3v1 id3v1Tag = mp3file.getId3v1Tag();
            usefulDataHolder.add(id3v1Tag.getTitle());
            usefulDataHolder.add(id3v1Tag.getArtist());
            usefulDataHolder.add(id3v1Tag.getAlbum());
        } catch (UnsupportedTagException e) {
            e.printStackTrace();
        } catch (InvalidDataException e) {
            e.printStackTrace();
        }

        //Remember we know the order of data stored in this arrayList according to ID3V1 metadata
       /* StringBuilder certainUsefulDataHolder =null;
        long lengthOfUselessData = (songFile.length() - 125);
        FileInputStream file = new FileInputStream(songFile.getAbsolutePath());
        for (int countingUselessData = 0; countingUselessData < lengthOfUselessData; countingUselessData++)
            file.read();

        for(int iterationForUsefulData = 0; iterationForUsefulData < 3;iterationForUsefulData++)// 3 due to number of items we want in metadata
        {
            certainUsefulDataHolder = new StringBuilder();
            for(int UsefulDataCounter = 0;UsefulDataCounter < 30;UsefulDataCounter++){

              int usefulDataReader =  file.read();
              if (usefulDataReader != 0)
              certainUsefulDataHolder.append((char)usefulDataReader);


            }
            usefulDataHolder.add(certainUsefulDataHolder.substring(0));


        }*/


            return usefulDataHolder;
    }

    /**
     * extracting datas according to ID3V2 standard
     * @param  songFile is a File and title of a song which is a string
     */
    private void findArtwork(File songFile, String title) throws IOException, InvalidDataException, UnsupportedTagException {
        Mp3File mp3file = new Mp3File(songFile.getAbsolutePath());
        if (mp3file.hasId3v2Tag()) {
            ID3v2 id3v2Tag = mp3file.getId3v2Tag();
            byte[] imageData = id3v2Tag.getAlbumImage();
            if (imageData != null) {
                String mimeType = id3v2Tag.getAlbumImageMimeType();
                // Write image to file - can determine appropriate file extension from the mime type
                RandomAccessFile file = new RandomAccessFile(title + ".jpg", "rw");
                file.write(imageData);
                file.close();
            }
        }
    }
    /**
     * starts the engine of the machine in which we call two methods for ID3V1 and ID3V2 standards
     * @param  songFile is a File
     */
    public void startTheEngine(File songFile) throws IOException, InvalidDataException, UnsupportedTagException {
     ArrayList<String> myUsefulDataHolder;
        myUsefulDataHolder = this.findID3V1Metadata(songFile);
        setTitleData(myUsefulDataHolder.get(0));
        setArtistNameData(myUsefulDataHolder.get(1));
        setAlbumNameData(myUsefulDataHolder.get(2));
        findArtwork(songFile, this.getTitleData());

    }

    private void setTitleData(String titleData) {
        this.titleNameData = titleData;
    }

    public String getTitleData() {
        return titleNameData;
    }

    private void setArtistNameData(String artistNameData) {
        this.artistNameData = artistNameData;
    }

    public String getArtistNameData() {
        return artistNameData;
    }

    private void setAlbumNameData(String albumNameData) {
        this.albumNameData = albumNameData;
    }

    public String getAlbumNameData() {
        return albumNameData;
    }
}
