package com.wang.springframework.core.io;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author zsw
 * @create 2022-07-29 20:16
 */
public class DefaultResourceLoader implements ResourceLoader {
    public Resource getResource(String location) {
        if (location.startsWith(CLASSPATH_URL_PREFIX)){
            return  new ClassPathResource(location.substring(CLASSPATH_URL_PREFIX.length()));
        }
        else {
            try {
                URL url = new URL(location);
                UrlResource urlResource = new UrlResource(url);
                return  urlResource;

            } catch (MalformedURLException e) {
                return new FileSystemResource(location);
            }

        }

    }
}
