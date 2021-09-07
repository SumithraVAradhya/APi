package Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class readproperty {
    public Properties fetch_property() throws IOException {
        FileInputStream fileInput = new FileInputStream("src/main/resources/data.properties");
        Properties prop = new Properties();
        prop.load(fileInput);
        return prop;
    }
}
