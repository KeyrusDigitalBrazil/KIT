package com.keyrus.kit.utils;

public interface SystemUtils {

    /**
     * Generate scanner for console
     *
     * @return String
     */
    String generateStringScanner();

    /**
     * Get properties value by key
     * @param key
     * @return String
     */
    String getPropertiesValue(String key);

}
