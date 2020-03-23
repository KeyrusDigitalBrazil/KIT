package com.keyrus.kit.utils.impl;

import com.keyrus.kit.utils.SystemUtils;

import java.util.Scanner;

public class DefaultSystemUtils implements SystemUtils {

    @Override
    public String generateStringScanner() {
        Scanner scan = new Scanner(System.in);
        return scan.nextLine();
    }

}
