package me.satisdev.calculator.parsers;

import java.io.IOException;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileParser {

    public void getFailureFile() {
        String data;
        File directory = new File("./src/res/failure.txt");
        String dirPath = directory.getAbsolutePath();
        Path path = Paths.get(dirPath);

        try {
            data = new String(Files.readAllBytes(path));
        } catch (IOException e) {
            data = "failure.txt does not exist?";
        }

        System.out.println(data);
    }
}
