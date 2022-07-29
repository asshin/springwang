package com.wang.springframework.core.io;

import com.wang.springframework.beans.Util.ClassUtil;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author zsw
 * @create 2022-07-28 22:33
 */
public class ClassPathResource implements Resource{
    private final String Path;
    private ClassLoader classLoader;
    public ClassPathResource(String path, ClassLoader classLoader) {
//        Assert.notNull(path, "Path must not be null");
        this.Path = path;

        this.classLoader = (classLoader != null ? classLoader : ClassUtil.getDefaultClassLoader());
    }



    public ClassPathResource(String path) {
        this(path,(ClassLoader)null);
    }

    public InputStream getInputStream() throws IOException {
        InputStream resourceAsStream = classLoader.getResourceAsStream(Path);
        if (resourceAsStream==null){
            throw new FileNotFoundException
                    (this.Path+"cannnot be opened");
        }
        return resourceAsStream;
    }
}

