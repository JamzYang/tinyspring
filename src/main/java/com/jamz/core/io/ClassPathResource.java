package com.jamz.core.io;

import java.io.InputStream;

public class ClassPathResource implements Resource {
    private String path;

    public ClassPathResource(String path) {
        this.path = path;
    }

    @Override
    public InputStream getInputStream() {
        InputStream is = this.getClass().getClassLoader().getResourceAsStream((this.path));
//        return ClassLoader.getSystemResourceAsStream(this.path);
        return is;
    }
}
