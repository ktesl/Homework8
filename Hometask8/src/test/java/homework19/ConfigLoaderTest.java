package homework19;

import homework18.utils.BaseTest;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigLoaderTest extends BaseTest {
    public Properties getProperties() {
        File file = new File("src/test/resources/homework19.properties");
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
