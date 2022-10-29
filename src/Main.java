import transfer_system_elements.DataSource;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Path path = Path.of("myFile.txt");
        String text = "";
        Path pathResult = Path.of("myResult.txt");
        try {
            File file = new File(path.toString());
            InputStreamReader reader = new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8);
            BufferedReader bufferedReader = new BufferedReader(reader);
            text = bufferedReader.readLine();
            Files.delete(pathResult);            Files.createFile(pathResult);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        DataSource dataSource = new DataSource(text,pathResult);
    }
}