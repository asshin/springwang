package com.wang.springframework.core.io;

/**
 * @author zsw
 * @create 2022-07-29 20:13
 */
public interface ResourceLoader {
    String CLASSPATH_URL_PREFIX = "classpath:";
    Resource getResource(String location);
}
