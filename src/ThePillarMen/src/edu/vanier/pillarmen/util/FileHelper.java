package edu.vanier.pillarmen.util;
import java.io.File;
/**
 * A class that contains helper methods to work with files.
 *
 * @author Sleiman
 */
public class FileHelper {

    /**
     * Creates a file that is stored in resources folder (or a subfolder)
     * 
     * @param resourcePath the relative path of the file to be loaded. For example, resources/[foldername]/[filename]
     * @return A file object with the successfully loaded resource. 
     */
    public static File getAbsolutePath(String resourcePath) {
        File file = new File(resourcePath);
        //String absolutePath = file.getAbsolutePath();
        //System.out.println(absolutePath);
        return file;
    }
}