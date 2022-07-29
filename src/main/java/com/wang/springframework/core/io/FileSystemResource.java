package com.wang.springframework.core.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author zsw
 * @create 2022-07-28 22:47
 */
public class FileSystemResource implements Resource {
    private final File file;
    private final  String path;

    public FileSystemResource(String path) {
        this.path = path;
        file=new File(path);
    }

    public FileSystemResource(File file) {
        this.file = file;
        this.path = file.getPath();
    }

    public InputStream getInputStream() throws IOException {
      return   new FileInputStream(file);
    }
    public final String getPath(){
        return this.path;
    }
}
