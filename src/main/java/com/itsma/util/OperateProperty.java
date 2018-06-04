package com.itsma.util;


import org.springframework.context.annotation.Configuration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
public class OperateProperty {
    protected static final String TEST_PARAM_FILE_NAME="file.properties";

    protected static Properties PROP = new Properties();
    static {
        try {
            InputStream input = new FileInputStream(TEST_PARAM_FILE_NAME);
            PROP.load(input);
            //all the parameters now could be set from cmdline
            for(String var : PROP.stringPropertyNames()) {
                if(System.getProperty(var) != null) {
                    PROP.setProperty(var, System.getProperty(var));
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public static String getTestProperty(String key)
    {
        String value = PROP.getProperty(key);
        return value;
    }

}
