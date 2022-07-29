package com.wang.springframework.beans.factory.support;

import com.wang.springframework.core.io.Resource;
import com.wang.springframework.core.io.ResourceLoader;

/**
 * @author zsw
 * @create 2022-07-29 20:29
 */
public interface BeanDefinitionReader {
   BeanDefinitionRegistry getRegistry();
   ResourceLoader getResourceLoader();
   void loadDefinitions(Resource resource);
   void loadDefinitions(Resource... resources);
   void loadDefinitions(String location);

}
