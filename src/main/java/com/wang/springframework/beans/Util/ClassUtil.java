package com.wang.springframework.beans.Util;

/**
 * @author zsw
 * @create 2022-07-29 21:57
 */
public class ClassUtil {


        public static ClassLoader getDefaultClassLoader() {
            ClassLoader cl = null;
            try {
                cl = Thread.currentThread().getContextClassLoader();
            }
            catch (Throwable ex) {
                // Cannot access thread context ClassLoader - falling back to system class loader...
            }
            if (cl == null) {
                // No thread context class loader -> use class loader of this class.
                cl = ClassUtil.class.getClassLoader();
            }
            return cl;


    }

}
