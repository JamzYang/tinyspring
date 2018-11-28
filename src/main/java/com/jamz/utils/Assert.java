package com.jamz.utils;

public class Assert {
    public static void isNotNull(Object ob,String message){
        if(ob == null){
            throw new IllegalArgumentException(message);
        }
    }
    public static void isNotBlank(String string,String message){
        if(string == null || (string != null && string.trim().length() < 1)){
            throw new IllegalArgumentException(message);
        }
    }

}
