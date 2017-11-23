package com.lishuangqi.cache;

import java.util.List;
import java.util.Map;

/**
 * Created by michael on 2017/11/13.
 */
public interface ICaheManager {
    void init();

    void close();

    long expire(String var1, int var2);

    boolean exists(String var1);

    void set(String var1, Object var2);

    void set(String var1, Object var2, int var3);

    <T> T get(String var1);

    List<String> getKeys();

    void remove(String var1);

    void removeAll(List<String> var1);

    void setBatch(Map<String, Object> var1);
}
