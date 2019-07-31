package com.vytrack.utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigrationReader {

    private static Properties configFile;

    static {

        try {

            String path = "C:\\Users\\xayim\\vytrackautomation\\configration.properties";

            System.out.println(path);

            FileInputStream input = new FileInputStream(path);

            configFile = new Properties();

            configFile.load(input);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public static String getProperty(String key){

        return configFile.getProperty(key);
    }

}
