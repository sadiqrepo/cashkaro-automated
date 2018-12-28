package util;

import java.io.*;
import java.util.Properties;

/**
 * Created by sadiq on 25/12/18.
 */
public class ConfigWriter {
    public static void setPropertyValue(String propKey,String propValue,String path){

        File file = new File(path);
        Properties prop=new Properties();

        // properties file
        try {

            //first load old one:
            FileInputStream fileInput = new FileInputStream(file);
            prop.load(fileInput);
            fileInput.close();
            /**
             Enumeration enuKeys = prop.keys();
             while (enuKeys.hasMoreElements()) {
             String key = (String) enuKeys.nextElement();
             String value = prop.getProperty(key);

             //System.out.println(key + ": " + value);
             }
             */

            //modifies existing or adds new property
            prop.setProperty(propKey, propValue);
            //prop.setProperty("newProperty", "newValue");

            //Stores properties
            FileOutputStream fileOutput = new FileOutputStream(file);
            prop.store(fileOutput, null);
            fileOutput.close();

        } catch (FileNotFoundException ex) {
            // file does not exist
        } catch (IOException ex) {
            // I/O error
        }
    }
}
