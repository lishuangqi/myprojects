package com.lishuangqi.cache.redis;

/**
 * Created by michael on 2017/11/13.
 */

        import java.util.ArrayList;
        import java.util.HashMap;
        import java.util.HashSet;
        import java.util.Iterator;
        import java.util.List;
        import java.util.Map;
        import java.util.Set;
        import java.util.Map.Entry;

        import com.lishuangqi.cache.CacheManagerParam;
        import com.lishuangqi.cache.ComponentParamBean;
        import com.lishuangqi.cache.ICaheManager;
        import com.lishuangqi.utils.*;
        import org.slf4j.Logger;
        import org.slf4j.LoggerFactory;
        import redis.clients.jedis.Jedis;
        import redis.clients.jedis.JedisPoolConfig;
        import redis.clients.jedis.JedisSentinelPool;
        import redis.clients.jedis.Pipeline;

public class RedisClusterManager implements ICaheManager {
    Logger log = LoggerFactory.getLogger(RedisClusterManager.class);
    private String cacheName = "wsbp_cache";
    private static JedisSentinelPool pool;
    private static Set<String> sentinelInfoSet;
    private static final String STRING_SEP = ",";
    private static final String INIT_MODEL_CONFIGDB = "configDB";

    public RedisClusterManager() {
    }

    public synchronized void init() {
        try {
            if(pool == null) {
                JedisPoolConfig e = new JedisPoolConfig();
                String init_model = FrameworkProps.getProperty("cache.initModel");
                String host;
                String port;
//                if(StringUtil.hasText(init_model) && StringUtil.equalsIgnoreCase(init_model, "configDB")) {
//                    host = FrameworkProps.getProperty("cache.configDB.host", "");
//                    int var34 = FrameworkProps.getProperty("cache.configDB.port", 80);
//                    port = FrameworkProps.getProperty("cache.configDB.url", "");
//                    HashMap var35 = new HashMap();
//                    var35.put("ctypes", "REDIS");
//                    var35.put("proId", "");
//                    String var36 = WSBPHttpClient.callHttpByPost(host, var34, port, (Map)null, var35);
//                    if(StringUtil.hasText(var36)) {
//                        List var37 = JsonUtil.parseArray(var36, ComponentParamBean.class);
//                        Map var38 = convertListToMap(var37);
//                        if(var38 != null) {
//                            String var39 = StringUtil.defaultString((String)var38.get("redis.mastername"), "mymaster");
//                            String password1 = StringUtil.defaultString((String)var38.get("redis.password"), "123456");
//                            String database_str = StringUtil.defaultString((String)var38.get("redis.database"), "0");
//                            String timeout_str = StringUtil.defaultString((String)var38.get("redis.timeout"), "2000");
//                            int database1 = Integer.parseInt(database_str);
//                            int timeout1 = Integer.parseInt(timeout_str);
//                            String host1 = StringUtil.defaultString((String)var38.get("redis.host"), "");
//                            String[] host_array1 = StringUtil.split(host1, ",");
//                            String port1 = StringUtil.defaultString((String)var38.get("redis.port"), "");
//                            String[] port_array1 = StringUtil.split(port1, ",");
//                            if(!ArrayUtil.isEmpty(host_array1) && !ArrayUtil.isEmpty(port_array1) && ArrayUtil.getLength(host_array1) == ArrayUtil.getLength(port_array1)) {
//                                sentinelInfoSet = new HashSet();
//
//                                for(int blockWhenExhausted_str = 0; blockWhenExhausted_str < host_array1.length; ++blockWhenExhausted_str) {
//                                    if(StringUtil.isNotBlank(host_array1[blockWhenExhausted_str]) && StringUtil.isNotEmpty(host_array1[blockWhenExhausted_str]) && StringUtil.isNotBlank(port_array1[blockWhenExhausted_str]) && StringUtil.isNotEmpty(port_array1[blockWhenExhausted_str])) {
//                                        sentinelInfoSet.add(host_array1[blockWhenExhausted_str] + ":" + port_array1[blockWhenExhausted_str]);
//                                    }
//                                }
//                            }
//
//                            String var40 = StringUtil.defaultString((String)var38.get("redis.blockWhenExhausted"), "true");
//                            String maxIdle_str = StringUtil.defaultString((String)var38.get("redis.maxIdle"), "10");
//                            String minIdle_str = StringUtil.defaultString((String)var38.get("redis.minIdle"), "10");
//                            String maxTotal_str = StringUtil.defaultString((String)var38.get("redis.maxTotal"), "10000");
//                            String maxWait_str = StringUtil.defaultString((String)var38.get("redis.maxWait"), "100");
//                            String testWhileIdle_str = StringUtil.defaultString((String)var38.get("redis.testWhileIdle"), "false");
//                            String testOnBorrow_str = StringUtil.defaultString((String)var38.get("redis.testOnBorrow"), "true");
//                            String testOnReturn_str = StringUtil.defaultString((String)var38.get("redis.testOnReturn"), "false");
//                            String numTestsPerEvictionRun_str = StringUtil.defaultString((String)var38.get("redis.numTestsPerEvictionRun"), "10");
//                            String minEvictableIdleTimeMillis_str = StringUtil.defaultString((String)var38.get("redis.minEvictableIdleTimeMillis"), "1000");
//                            String softMinEvictableIdleTimeMillis_str = StringUtil.defaultString((String)var38.get("redis.softMinEvictableIdleTimeMillis"), "10");
//                            String timeBetweenEvictionRunsMillis_str = StringUtil.defaultString((String)var38.get("redis.timeBetweenEvictionRunsMillis"), "10");
//                            String lifo_str = StringUtil.defaultString((String)var38.get("redis.lifo"), "false");
//                            e.setBlockWhenExhausted(Boolean.parseBoolean(var40));
//                            e.setMaxIdle(Integer.parseInt(maxIdle_str));
//                            e.setMinIdle(Integer.parseInt(minIdle_str));
//                            e.setMaxTotal(Integer.parseInt(maxTotal_str));
//                            e.setMaxWaitMillis((long)Integer.parseInt(maxWait_str));
//                            e.setTestWhileIdle(Boolean.parseBoolean(testWhileIdle_str));
//                            e.setTestOnBorrow(Boolean.parseBoolean(testOnBorrow_str));
//                            e.setTestOnReturn(Boolean.parseBoolean(testOnReturn_str));
//                            e.setNumTestsPerEvictionRun(Integer.parseInt(numTestsPerEvictionRun_str));
//                            e.setMinEvictableIdleTimeMillis((long)Integer.parseInt(minEvictableIdleTimeMillis_str));
//                            e.setSoftMinEvictableIdleTimeMillis((long)Integer.parseInt(softMinEvictableIdleTimeMillis_str));
//                            e.setTimeBetweenEvictionRunsMillis((long)Integer.parseInt(timeBetweenEvictionRunsMillis_str));
//                            e.setLifo(Boolean.parseBoolean(lifo_str));
//                            this.cacheName = StringUtil.defaultString((String)var38.get("cacheName"), "wsbp_cache");
//                            pool = new JedisSentinelPool(var39, sentinelInfoSet, e, timeout1, password1, database1);
//                            this.log.debug("Redis Cluster Manager init from ConfigSystem success!");
//                        }
//                    }
//
//                    this.log.debug("Redis Cluster Manager init from ConfigSystem error!");
//                } else {
                    host = FrameworkProps.getProperty("redis.host", "");
                    String[] host_array = StringUtil.split(host, ",");
                    port = FrameworkProps.getProperty("redis.port", "");
                    String[] port_array = StringUtil.split(port, ",");
                    int timeout;
                    if(!ArrayUtil.isEmpty(host_array) && !ArrayUtil.isEmpty(port_array) && ArrayUtil.getLength(host_array) == ArrayUtil.getLength(port_array)) {
                        sentinelInfoSet = new HashSet();

                        for(timeout = 0; timeout < host_array.length; ++timeout) {
                            if(StringUtil.isNotBlank(host_array[timeout]) && StringUtil.isNotEmpty(host_array[timeout]) && StringUtil.isNotBlank(port_array[timeout]) && StringUtil.isNotEmpty(port_array[timeout])) {
                                sentinelInfoSet.add(host_array[timeout] + ":" + port_array[timeout]);
                            }
                        }
                    }

                    timeout = FrameworkProps.getProperty("redis.timeout", 2000);
                    String mastername = FrameworkProps.getProperty("redis.mastername", "mymaster");
                    String password = FrameworkProps.getProperty("redis.password", "123456");
                    int database = FrameworkProps.getProperty("redis.database", 0);
                    e.setBlockWhenExhausted(FrameworkProps.getProperty("redis.blockWhenExhausted", true));
                    e.setMaxIdle(FrameworkProps.getProperty("redis.maxIdle", 10));
                    e.setMinIdle(FrameworkProps.getProperty("redis.minIdle", 5));
                    e.setMaxTotal(FrameworkProps.getProperty("redis.maxTotal", 10000));
                    e.setMaxWaitMillis((long)FrameworkProps.getProperty("redis.maxWait", 100));
                    e.setTestWhileIdle(FrameworkProps.getProperty("redis.testWhileIdle", false));
                    e.setTestOnBorrow(FrameworkProps.getProperty("redis.testOnBorrow", true));
                    e.setTestOnReturn(FrameworkProps.getProperty("redis.testOnReturn", false));
                    e.setNumTestsPerEvictionRun(FrameworkProps.getProperty("redis.numTestsPerEvictionRun", 10));
                    e.setMinEvictableIdleTimeMillis((long)FrameworkProps.getProperty("redis.minEvictableIdleTimeMillis", 1000));
                    e.setSoftMinEvictableIdleTimeMillis((long)FrameworkProps.getProperty("redis.softMinEvictableIdleTimeMillis", 10));
                    e.setTimeBetweenEvictionRunsMillis((long)FrameworkProps.getProperty("redis.timeBetweenEvictionRunsMillis", 10));
                    e.setLifo(FrameworkProps.getProperty("redis.lifo", false));
                    pool = new JedisSentinelPool(mastername, sentinelInfoSet, e, timeout, password, database);
                    this.cacheName = CacheManagerParam.getCacheName();
                    this.log.info("Redis Cluster Manager init from local file success!");
                }
//            }

        } catch (Exception var33) {
            throw new WsbpException("Error occured when init Redis cache", var33);
        }
    }

    private static Map<String, String> convertListToMap(List<ComponentParamBean> paramBeanList) {
        if(paramBeanList == null) {
            return null;
        } else {
            HashMap paramMap = new HashMap();
            Iterator i$ = paramBeanList.iterator();

            while(i$.hasNext()) {
                ComponentParamBean componentParamBean = (ComponentParamBean)i$.next();
                paramMap.put(componentParamBean.getPname(), componentParamBean.getPvalue());
            }

            return paramMap;
        }
    }

    public void set(String key, Object value) {
        Jedis cluster = null;

        try {
            cluster = pool.getResource();
            cluster.set(this.getKeyName(key).getBytes(), SerializeObjUtil.serialize(value));
        } catch (Exception var8) {
            throw new WsbpException("Error occured when set data from Redis cache", var8);
        } finally {
            pool.returnResourceObject(cluster);
        }

    }

    public void set(String key, Object value, int expire) {
        Jedis cluster = null;

        try {
            cluster = pool.getResource();
            cluster.setex(this.getKeyName(key).getBytes(), expire, SerializeObjUtil.serialize(value));
        } catch (Exception var9) {
            throw new WsbpException("Error occured when set data from Redis cache", var9);
        } finally {
            pool.returnResourceObject(cluster);
        }

    }

    public <T> T get(String key) {
        if(null == key) {
            return null;
        } else {
            Object obj = null;
            Jedis cluster = null;

            try {
                cluster = pool.getResource();
                byte[] e = cluster.get(this.getKeyName(key).getBytes());
                if(e != null) {
                    obj = SerializeObjUtil.deserialize(e);
                }
            } catch (Exception var8) {
                throw new WsbpException("Error occured when get data from Redis cache", var8);
            } finally {
                pool.returnResourceObject(cluster);
            }

            return (T) obj;
        }
    }

    public void remove(String key) {
        Jedis cluster = null;

        try {
            cluster = pool.getResource();
            cluster.del(this.getKeyName(key).getBytes());
        } catch (Exception var7) {
            throw new WsbpException("Error occured when remove data from Redis cache", var7);
        } finally {
            pool.returnResourceObject(cluster);
        }

    }

    public void removeAll(List<String> keys) {
        Jedis cluster = null;

        try {
            cluster = pool.getResource();
            Iterator e = keys.iterator();

            while(e.hasNext()) {
                String string = (String)e.next();
                cluster.del(this.getKeyName(string).getBytes());
            }
        } catch (Exception var8) {
            pool.returnBrokenResource(cluster);
            throw new WsbpException("Error occured when removeAll data from Redis cache", var8);
        } finally {
            pool.returnResourceObject(cluster);
        }

    }

    public long expire(String key, int seconds) {
        long result = -10000L;
        Jedis cluster = null;

        long e;
        try {
            cluster = pool.getResource();
            result = cluster.expire(this.getKeyName(key).getBytes(), seconds).longValue();
            e = result;
        } catch (Exception var11) {
            pool.returnBrokenResource(cluster);
            throw new WsbpException("Error occured when update redis expire", var11);
        } finally {
            pool.returnResourceObject(cluster);
        }

        return e;
    }

    public boolean exists(String key) {
        boolean result = false;
        Jedis cluster = null;

        boolean e;
        try {
            cluster = pool.getResource();
            result = cluster.exists(this.getKeyName(key).getBytes()).booleanValue();
            e = result;
        } catch (Exception var8) {
            pool.returnBrokenResource(cluster);
            throw new WsbpException("Error occured when check redis exists", var8);
        } finally {
            pool.returnResourceObject(cluster);
        }

        return e;
    }

    private String getKeyName(String key) {
        return this.cacheName + ":S:" + key;
    }

    public void close() {
    }

    public List<String> getKeys() {
        ArrayList keys = new ArrayList();
        Jedis cluster = null;

        try {
            cluster = pool.getResource();
            keys.addAll(cluster.keys(this.cacheName + ":*"));

            for(int e = 0; e < keys.size(); ++e) {
                keys.set(e, ((String)keys.get(e)).substring(this.cacheName.length() + 3));
            }

            ArrayList var9 = keys;
            return var9;
        } catch (Exception var7) {
            pool.returnBrokenResource(cluster);
            throw new WsbpException("Error occured when get getKeys from Redis cache", var7);
        } finally {
            pool.returnResourceObject(cluster);
        }
    }

    public int getNumActive() {
        return pool.getNumActive();
    }

    public int getNumWaiters() {
        return pool.getNumWaiters();
    }

    public boolean getPoolCloseStatus() {
        return pool.isClosed();
    }

    public Long getDb() {
        Jedis redis = pool.getResource();
        Long db = redis.getDB();
        pool.returnResourceObject(redis);
        return db;
    }

    public Long getDbSize() {
        Jedis redis = pool.getResource();
        Long dbsize = redis.dbSize();
        pool.returnResourceObject(redis);
        return dbsize;
    }

    public String getInfo(String section) {
        Jedis redis = pool.getResource();
        String info = redis.info(section);
        pool.returnResourceObject(redis);
        return info;
    }

    public String getInfo() {
        Jedis redis = pool.getResource();
        String info = redis.info();
        pool.returnResourceObject(redis);
        return info;
    }

    public void setBatch(Map<String, Object> cacheMap) {
        Jedis cluster = null;

        try {
            cluster = pool.getResource();
            Pipeline e = cluster.pipelined();
            Iterator i$ = cacheMap.entrySet().iterator();

            while(i$.hasNext()) {
                Entry entry = (Entry)i$.next();
                if(entry.getValue() instanceof String) {
                    e.set(((String)entry.getKey()).getBytes(), String.valueOf(SerializeObjUtil.serialize(entry.getValue())).getBytes());
                }
            }

            e.sync();
        } catch (Exception var9) {
            pool.returnBrokenResource(cluster);
            throw new WsbpException("Error occured when set data Batch from Redis cache", var9);
        } finally {
            pool.returnResourceObject(cluster);
        }

    }
}

