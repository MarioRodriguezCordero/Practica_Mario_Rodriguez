package com.example.practica_mario_rodriguez.util;

import java.io.File;
import java.io.InputStream;
import java.net.URL;

public class R {
    public static InputStream getProperties(String name) {
        return Thread.currentThread().getClass().getResourceAsStream("resources/configuration" + File.separator + name);
    }

    public static URL getUI(String name) {
        return Thread.currentThread().getContextClassLoader().getResource("reseources/com.example.practica_mario_rodriguez" + File.separator + name);
    }
}
