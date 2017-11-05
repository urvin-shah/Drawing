package com.creditsuisse.util;

public class StringUtil {
    public static boolean isNotNull(String inputString) {
        if(inputString != null && !inputString.isEmpty()) {
            return true;
        }
        return false;
    }
}
