package com.keyrus.kit.utils.impl;

import com.keyrus.kit.utils.SystemUtils;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.util.Properties;
import java.util.Scanner;

@Component
public class DefaultSystemUtils implements SystemUtils {

    private Properties prop = new Properties();

    @Override
    public String generateStringScanner() {
        Scanner scan = new Scanner(System.in);
        return scan.nextLine();
    }

    @Override
    public String getPropertiesValue(String key) {
        try {
            InputStream input = getClass().getClassLoader().getResourceAsStream("application.properties");
            prop.load(input);
            return prop.getProperty(key);
        } catch (Exception e) {
            System.out.println("Error trying get prop value");
        }
        return "";
    }

}
