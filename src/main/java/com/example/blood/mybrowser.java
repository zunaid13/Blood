package com.example.blood;

import java.io.IOException;

public class mybrowser {
    public static String stackoverflow = "http://stackoverflow.com";
    public static String google = "https://google.com";
    private static String command = "rundll32 url.dll, FileProtocolHandler ";
    public static void Goto(String url)
    {
        Runtime rt = Runtime.getRuntime();
        try {
            rt.exec(command + url);
        } catch (IOException ex) {
            throw new RuntimeException();
        }
    }
}
