package com.lishuangqi.cache.api;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

/**
 * Created by michael on 2017/11/13.
 */
public interface CacheService {
    int NEVER_EXPIRE = -1;

    Serializable get(String var1);

    Map<String, Serializable> getAll(Collection<String> var1);

    CacheService.IdentifiableValue getIdentifiable(String var1) throws CacheException;

    boolean put(String var1, Serializable var2);

    boolean putIfUntouched(String var1, CacheService.IdentifiableValue var2, Serializable var3, int var4);

    boolean put(String var1, Serializable var2, int var3);

    boolean delete(String var1);

    Set<String> deleteAll(Collection<String> var1);

    Long increment(String var1, long var2);

    Long increment(String var1, long var2, Long var4);

    Long decrement(String var1, long var2);

    Long decrement(String var1, long var2, Long var4);

    public interface IdentifiableValue {
        Serializable getValue();
    }
}
