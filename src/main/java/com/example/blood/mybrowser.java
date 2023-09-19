package com.example.blood;

import java.io.IOException;

public class mybrowser {
    public static String stackoverflow = "http://stackoverflow.com";
    public static String google = "https://google.com";
    public static String info = "https://www.who.int/campaigns/world-blood-donor-day/2018/who-can-give-blood";
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
