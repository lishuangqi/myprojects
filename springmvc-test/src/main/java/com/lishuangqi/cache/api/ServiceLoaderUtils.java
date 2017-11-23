package com.lishuangqi.cache.api;

import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ServiceLoader;

/**
 * Created by michael on 2017/11/13.
 */
public class ServiceLoaderUtils {
    public ServiceLoaderUtils() {
    }

    public static <T> List<T> getServices(final Class<T> clazz, final ClassLoader classLoader) {
        return (List) AccessController.doPrivileged(new PrivilegedAction() {
            public List<T> run() {
                ArrayList result = new ArrayList();
                ServiceLoader providers = ServiceLoader.load(clazz, classLoader);
                if(providers != null) {
                    Iterator i$ = providers.iterator();

                    while(i$.hasNext()) {
                        Object provider = i$.next();
                        result.add(provider);
                    }
                }

                return result;
            }
        });
    }
}
