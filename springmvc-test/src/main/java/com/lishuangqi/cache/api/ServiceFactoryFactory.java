package com.lishuangqi.cache.api;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by michael on 2017/11/13.
 */
public final class ServiceFactoryFactory {
    public ServiceFactoryFactory() {
    }

    public static <T> T getFactory(Class<T> factoryClass) {
        FactoryProvider provider = (FactoryProvider)ServiceFactoryFactory.LazyLoadProviderHolder.serviceFactories.get(factoryClass);
        if(provider == null) {
            throw new IllegalArgumentException("No factory was registered for " + factoryClass.getCanonicalName());
        } else {
            return factoryClass.cast(provider.getFactoryInstance());
        }
    }

    private static class LazyLoadProviderHolder {
        private static Map<Class<?>, FactoryProvider<?>> serviceFactories;

        private LazyLoadProviderHolder() {
        }

        static {
            HashMap temp = new HashMap();
            List factoryProviderList = ServiceLoaderUtils.getServices(FactoryProvider.class, ServiceFactoryFactory.class.getClassLoader());
            Iterator i$ = factoryProviderList.iterator();

            while(i$.hasNext()) {
                FactoryProvider provider = (FactoryProvider)i$.next();
                FactoryProvider previous = (FactoryProvider)temp.get(provider.getBaseInterface());
                if(temp.containsKey(provider.getBaseInterface())) {
                    throw new IllegalStateException("Ambiguous providers: " + provider.getClass().getCanonicalName() + " versus " + previous.getClass().getCanonicalName());
                }

                temp.put(provider.getBaseInterface(), provider);
            }

            serviceFactories = temp;
        }
    }
}
