package com.example.spend.common;

public final class StringUtil {

    private StringUtil()
    {

    }

    public static boolean isBlank(final String text){
        return (text==null) || text.trim().equals("");
    }

    public static boolean isNotBlank(final String text){
        return !isBlank(text);
    }

    public static String trim(final String text) {
        return text!=null ? text.trim() : null;
    }

}