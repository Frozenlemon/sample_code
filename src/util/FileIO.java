package util;

import java.io.File;

public class FileIO {
    public static final String PICTURE_PATH = System.getProperty("user.dir") + File.separator + "picture" + File.separator;

    public static String getFilePath(String fileName){
        return PICTURE_PATH + fileName;
    }
}
