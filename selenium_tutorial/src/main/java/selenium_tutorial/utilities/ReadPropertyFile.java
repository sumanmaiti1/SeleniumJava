package selenium_tutorial.utilities;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Properties;

/*
 *<p>This class will read the Properties from Property File</p>
 */

public class ReadPropertyFile {

    static String propertyFilePath = "D:\\Work\\Projects\\Java\\SeleniumJava\\selenium_tutorial\\property.properties";
    /*<p>This method reads property from a property file.</p>
     * It returns the property value present in propertyfile
     */
    public static String read(String propertyName){
        
        File file= new File(propertyFilePath);
        if(file.exists()){
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                Properties prop = new Properties();
                prop.load(br);
                return prop.getProperty(propertyName);
            } catch (Exception e) {
                System.out.println("Runtime Exception genarated.\n" + e.getMessage());
                return null;
            }
        }else{
            System.out.println("Filepath is not Valid. No such file exists.");
            return null;
        }
    }
}
