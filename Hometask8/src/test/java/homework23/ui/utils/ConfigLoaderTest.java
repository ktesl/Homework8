package homework23.ui.utils;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigLoaderTest extends BaseTest{
    public Properties getProperties() {
        File file = new File("src/test/resources/homework23.properties");
        String absolutePath = file.getAbsolutePath();
        File newFile = new File(absolutePath);


        Properties properties = new Properties();
        try {
            properties.load(new FileReader(newFile));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return properties;
    }

}
