package Logic;

import Logic.Entity.Library.Library;

import java.io.*;
/**
 * save class simply saves and loads library
 * @author Mahan
 * @version 7.0
 * @since 06/15/2019
 */
public class Save {

    public Save() {
    }
    /**
     * saves library
     * @param library
     */
    public void save(Library library) {
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(new File("library")));
            out.writeObject(library);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    /**
     * loads library
     * @return library
     */
    public Library load() {
        Library library = null;
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(new File("library")));
            library = (Library) in.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return library;
    }
}
