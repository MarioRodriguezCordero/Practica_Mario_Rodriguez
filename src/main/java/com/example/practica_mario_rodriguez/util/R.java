package com.example.practica_mario_rodriguez.util;

import java.io.File;
import java.io.InputStream;

public class R {
    public static InputStream getProperties(String name) {
        return Thread.currentThread().getContextClassLoader().getResourceAsStream("configuration" + File.separator + name);
    }
}
