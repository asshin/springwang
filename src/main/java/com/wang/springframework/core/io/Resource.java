package com.wang.springframework.core.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author zsw
 * @create 2022-07-28 22:34
 */
public interface Resource {
    InputStream getInputStream() throws IOException;
}
