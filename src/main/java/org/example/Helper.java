package org.example;

import java.io.File;

public class Helper {
    public static String convertRelativePathToAbs(String relative){
        // Convert relative path to absolute path
        File file = new File(relative);
        return file.getAbsolutePath();
    }
}
