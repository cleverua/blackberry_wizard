package com.cleverua.bb.example;

public class StringUtils {
    
    public static boolean isBlank(String str) {
        return (str == null) || (str.length()== 0);
    }
    
    public static boolean isNotBlank(String str) {
        return !isBlank(str);
    }
}
