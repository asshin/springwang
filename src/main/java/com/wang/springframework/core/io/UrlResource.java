package com.wang.springframework.core.io;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

/**
 * @author zsw
 * @create 2022-07-29 20:08
 */
public class UrlResource implements Resource {
    private final  URL url;

    public UrlResource(URL url) {
        this.url = url;
    }

    public InputStream getInputStream() throws IOException {
        URLConnection urlConnection = this.url.openConnection();
        try {
            return urlConnection.getInputStream();
        } catch (IOException ex) {
            if(urlConnection instanceof HttpURLConnection){
                ((HttpURLConnection) urlConnection).disconnect();
            }
            throw  ex;
        }

    }
}
