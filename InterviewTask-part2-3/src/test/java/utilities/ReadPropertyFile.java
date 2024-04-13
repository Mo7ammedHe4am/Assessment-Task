package utilities;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ReadPropertyFile {

   private static final  String ConfigPath = "C:\\Users\\user\\IdeaProjects\\InterviewTask-part1\\src\\test\\resources\\config.properties\\";

    public static void main(String[] args) throws IOException {

        FileReader fr = new FileReader(ConfigPath);

        Properties p = new Properties();

        p.load(fr);


    }
}
