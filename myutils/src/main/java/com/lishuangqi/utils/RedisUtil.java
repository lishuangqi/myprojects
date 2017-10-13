package com.lishuangqi.utils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.io.Serializable;
import java.util.*;

/**
 * 
 * @author lishuangqi
 *
 */
public class RedisUtil {

	private static JedisPool pool;

	static {
		ResourceBundle bundle = ResourceBundle.getBundle("framework");
		if (bundle == null) {
			throw new IllegalArgumentException("[framework.properties] not found");
		}
		JedisPoolConfig config = new JedisPoolConfig();
		String host=bundle.getString("redis.host");
		Integer port=Integer.valueOf(bundle.getString("redis.port"));
		Integer database=Integer.valueOf(bundle.getString("redis.database"));
		Integer timeOut=Integer.valueOf(bundle.getString("redis.timeout"));
		String password=bundle.getString("redis.password");
		config.setMaxIdle(Integer.valueOf(bundle
				.getString("redis.maxIdle")));
		config.setMaxWaitMillis(Long.valueOf(bundle.getString("redis.maxWaitMillis")));
		config.setTestOnBorrow(Boolean.valueOf(bundle
				.getString("redis.testOnBorrow")));
		config.setTestOnReturn(Boolean.valueOf(bundle
				.getString("redis.testOnReturn")));
		pool = new JedisPool(config, host,port,timeOut,password,database);
	}

	public static void returnResource(JedisPool pool, Jedis jedis) {
		if (jedis != null) {
			jedis.close();
		}
	}

	public static void cacheObjectJson(String key, Object obj) {
		Jedis jedis = null;
		try {
			jedis = pool.getResource();
			jedis.set(key, JSONObject.toJSONString(obj));
		} catch (Exception e) {
			jedis.close();
			throw e;
		} finally {
			returnResource(pool, jedis);
		}
	}

	public static <T> T getObjectJson(String key, Class<T> cls) {
		Jedis jedis = null;
		try {
			jedis = pool.getResource();
			String json = jedis.get(key);
			if (json == null) {
				return null;
			}
			return JSONObject.parseObject(json, cls);
		} catch (Exception e) {
			jedis.close();
			throw e;
		} finally {
			returnResource(pool, jedis);
		}
	}

	public static void cacheObject(String key, Map<String, String> cacheMap) {
		Jedis jedis = null;
		try {
			jedis = pool.getResource();
			jedis.hmset(key, cacheMap);
		} catch (Exception e) {
			jedis.close();
			throw e;
		} finally {
			returnResource(pool, jedis);
		}
	}

	public static List<String> getCacheObjectByKey(String key,
			String... propertyName) {
		Jedis jedis = null;
		List<String> values = null;
		try {
			jedis = pool.getResource();
			values = jedis.hmget(key, propertyName);
		} catch (Exception e) {
			jedis.close();
			throw e;
		} finally {
			returnResource(pool, jedis);
		}
		return values;
	}

	public static void cacheList(byte[] key, List<? extends Serializable> s) {
		Jedis jedis = null;
		try {
			jedis = pool.getResource();
			jedis.set(key, SerializeUtil.serialize(s));
		} catch (Exception e) {
			jedis.close();
			throw e;
		} finally {
			returnResource(pool, jedis);
		}
	}

	public static List<? extends Serializable> getCacheList(byte[] key) {
		Jedis jedis = null;
		List<? extends Serializable> values = null;
		try {
			jedis = pool.getResource();
			values = SerializeUtil.deserialize(jedis.get(key));
		} catch (Exception e) {
			jedis.close();
			throw e;
		} finally {
			returnResource(pool, jedis);
		}
		return values;
	}

	public static <T> void cacheList(String key, List<T> list) {
		Jedis jedis = null;
		try {
			jedis = pool.getResource();
			jedis.set(key, JSONArray.toJSONString(list));
		} catch (Exception e) {
			jedis.close();
			throw e;
		} finally {
			returnResource(pool, jedis);
		}
	}

	public static <T> List<T> getCacheList(String key, Class<T> cla) {
		Jedis jedis = null;
		try {
			jedis = pool.getResource();
			String jsonStr = jedis.get(key);
			if (jsonStr == null) {
				return null;
			}
			return JSONArray.parseArray(jsonStr, cla);
		} catch (Exception e) {
			jedis.close();
			throw e;
		} finally {
			returnResource(pool, jedis);
		}
	}
	public static <T> void hsetList(String key,String field, List<T> list) {
		Jedis jedis = null;
		try {
			jedis = pool.getResource();
			jedis.hset(key,field, JSONArray.toJSONString(list));
		} catch (Exception e) {
			jedis.close();
			throw e;
		} finally {
			returnResource(pool, jedis);
		}
	}
	public static <T> List<T> hgetList(String key,String field, Class<T> cla) {
		Jedis jedis = null;
		try {
			jedis = pool.getResource();
			String jsonStr = jedis.hget(key,field);
			if (jsonStr == null) {
				return null;
			}
			return JSONArray.parseArray(jsonStr, cla);
		} catch (Exception e) {
			jedis.close();
			throw e;
		} finally {
			returnResource(pool, jedis);
		}
	}

	public static void cacheSerializable(byte[] key, Serializable s) {
		Jedis jedis = null;
		try {
			jedis = pool.getResource();
			jedis.set(key, SerializeUtil.serializeS(s));
		} catch (Exception e) {
			jedis.close();
			throw e;
		} finally {
			returnResource(pool, jedis);
		}
	}

	public static Serializable getCachedSeralizable(byte[] key) {
		Jedis jedis = null;
		Serializable serializable = null;
		try {
			jedis = pool.getResource();
			serializable = SerializeUtil.deserializeS(jedis.get(key));
		} catch (Exception e) {
			jedis.close();
			throw e;
		} finally {
			returnResource(pool, jedis);
		}
		return serializable;
	}

	public static String getDefaultNickNameSerial(String key) {
		Jedis jedis = null;
		String nickName = null;
		try {
			jedis = pool.getResource();
			if (jedis.get(key) == null) {
				jedis.set(key, "1");
			} else {
				jedis.incr(key);
			}
			nickName = jedis.get(key);
		} catch (Exception e) {
			jedis.close();
			throw e;
		} finally {
			returnResource(pool, jedis);
		}
		return nickName;
	}

	public static void zadd(String key, Double score, String member) {
		Jedis jedis = null;
		try {
			jedis = pool.getResource();
			jedis.zadd(key, score, member);
		} catch (Exception e) {
			jedis.close();
			throw e;
		} finally {
			returnResource(pool, jedis);
		}
	}

	public static void sadd(String key, String member) {
		Jedis jedis = null;
		try {
			jedis = pool.getResource();
			jedis.sadd(key, member);
		} catch (Exception e) {
			jedis.close();
			throw e;
		} finally {
			returnResource(pool, jedis);
		}
	}

	public static List<String> smem(String key) {
		Jedis jedis = null;
		Set<String> set = null;
		List<String> ranges = new ArrayList<String>();
		try {
			jedis = pool.getResource();
			set = jedis.smembers(key);
			if (set != null) {
				ranges.addAll(set);
			}
		} catch (Exception e) {
			jedis.close();
			throw e;
		} finally {
			returnResource(pool, jedis);
		}
		return ranges;
	}

	public static void srem(String key) {
		Jedis jedis = null;
		try {
			jedis = pool.getResource();
			jedis.srem(key);
		} catch (Exception e) {
			jedis.close();
			throw e;
		} finally {
			returnResource(pool, jedis);
		}
	}

	public static void srem(String key, String members) {
		Jedis jedis = null;
		try {
			jedis = pool.getResource();
			jedis.srem(key, members);
		} catch (Exception e) {
			jedis.close();
			throw e;
		} finally {
			returnResource(pool, jedis);
		}
	}

	public static void hset(String key, String field, String value) {
		Jedis jedis = null;
		try {
			jedis = pool.getResource();
			jedis.hset(key, field, value);
		} catch (Exception e) {
			jedis.close();
			throw e;
		} finally {
			returnResource(pool, jedis);
		}
	}

	public static String hget(String key, String field) {
		Jedis jedis = null;
		String value = null;
		try {
			jedis = pool.getResource();
			value = jedis.hget(key, field);
		} catch (Exception e) {
			jedis.close();
			throw e;
		} finally {
			returnResource(pool, jedis);
		}
		if (value == null)
			return "0";
		return value;
	}

	/**
	 * 为空返回null
	 * 
	 * @param key
	 * @param field
	 * @return
	 */
	public static String hget2(String key, String field) {
		Jedis jedis = null;
		String value = null;
		try {
			jedis = pool.getResource();
			value = jedis.hget(key, field);
		} catch (Exception e) {
			jedis.close();
			throw e;
		} finally {
			returnResource(pool, jedis);
		}
		return value;
	}
	/**
	 * 直接返回实例
	 * @param key
	 * @param field
	 * @param clz
	 * @return T 空则为null
	 */
	public static <T> T hget(String key, String field,Class<T> clz) {
		Jedis jedis = null;
		String value = null;
		try {
			jedis = pool.getResource();
			value = jedis.hget(key, field);
			if(value!=null){
				return JSONObject.parseObject(value, clz);
			}
		} catch (Exception e) {
			jedis.close();
			throw e;
		} finally {
			returnResource(pool, jedis);
		}
		return null;
	}

	public static Map<String, String> hgetAll(String key) {
		Jedis jedis = null;
		Map<String, String> map = null;
		try {
			jedis = pool.getResource();
			map = jedis.hgetAll(key);
		} catch (Exception e) {
			jedis.close();
			throw e;
		} finally {
			returnResource(pool, jedis);
		}
		if (map == null) {
			return new HashMap<String, String>();
		}
		return map;
	}

	public static void hdel(String key, String field) {
		Jedis jedis = null;
		try {
			jedis = pool.getResource();
			jedis.hdel(key, field);
		} catch (Exception e) {
			jedis.close();
			throw e;
		} finally {
			returnResource(pool, jedis);
		}
	}

	public static void hincby(String key, String field, Long value) {
		Jedis jedis = null;
		try {
			jedis = pool.getResource();
			jedis.hincrBy(key, field, value);
		} catch (Exception e) {
			jedis.close();
			throw e;
		} finally {
			returnResource(pool, jedis);
		}
	}

	public static List<String> hvalues(String key) {
		Jedis jedis = null;
		try {
			jedis = pool.getResource();
			return jedis.hvals(key);
		} catch (Exception e) {
			jedis.close();
			throw e;
		} finally {
			returnResource(pool, jedis);
		}
	}
	public static <T> List<T> hvaluesList(String key, Class<T> cls) {
		List<T> listT = new ArrayList<T>();
		List<String> listStr = RedisUtil.hvalues(key);
		if (listStr == null || listStr.isEmpty()) {
			return listT;
		}
		for (String str : listStr) {
			listT.add(JSONObject.parseObject(str, cls));
		}
		return listT;
	}
	public static boolean hexist(String key, String field) {
		Jedis jedis = null;
		try {
			jedis = pool.getResource();
			return jedis.hexists(key, field);
		} catch (Exception e) {
			jedis.close();
			throw e;
		} finally {
			returnResource(pool, jedis);
		}
	}

	public static double zscore(String key, String member) {
		Jedis jedis = null;
		double score = 0d;
		try {
			jedis = pool.getResource();
			if (jedis.zscore(key, member) != null) {
				score = jedis.zscore(key, member);
			}
		} catch (Exception e) {
			jedis.close();
			throw e;
		} finally {
			returnResource(pool, jedis);
		}
		return score;
	}

	public static long zrank(String key, String member) {
		Jedis jedis = null;
		long rankPosition = 0l;
		try {
			jedis = pool.getResource();
			Long zrankIndex = jedis.zrank(key, member);
			rankPosition = zrankIndex == null ? 0 : zrankIndex;
		} catch (Exception e) {
			jedis.close();
			throw e;
		} finally {
			returnResource(pool, jedis);
		}
		return rankPosition;
	}

	public static long zRevRank(String key, String member) {
		Jedis jedis = null;
		long rankPosition = 0l;
		try {
			jedis = pool.getResource();
			Long zrankIndex = jedis.zrevrank(key, member);
			rankPosition = zrankIndex == null ? 0 : zrankIndex;
		} catch (Exception e) {
			jedis.close();
			throw e;
		} finally {
			returnResource(pool, jedis);
		}
		return rankPosition + 1;
	}

	public static void setAndExpire(String key, String value, int seconds) {
		Jedis jedis = null;
		try {
			jedis = pool.getResource();
			jedis.set(key, value);
			jedis.expire(key, seconds);
		} catch (Exception e) {
			jedis.close();
			throw e;
		} finally {
			returnResource(pool, jedis);
		}
	}

	public static void set(String key, String value) {
		Jedis jedis = null;
		try {
			jedis = pool.getResource();
			jedis.set(key, value);
		} catch (Exception e) {
			jedis.close();
			throw e;
		} finally {
			returnResource(pool, jedis);
		}
	}

	public static void expire(byte[] key, int seconds) {
		Jedis jedis = null;
		try {
			jedis = pool.getResource();
			jedis.expire(key, seconds);
		} catch (Exception e) {
			jedis.close();
			throw e;
		} finally {
			returnResource(pool, jedis);
		}
	}

	public static void expire(String key, int seconds) {
		Jedis jedis = null;
		try {
			jedis = pool.getResource();
			jedis.expire(key, seconds);
		} catch (Exception e) {
			jedis.close();
			throw e;
		} finally {
			returnResource(pool, jedis);
		}
	}

	public static String get(String key) {
		Jedis jedis = null;
		String result = null;
		try {
			jedis = pool.getResource();
			result = jedis.get(key);
		} catch (Exception e) {
			jedis.close();
			throw e;
		} finally {
			returnResource(pool, jedis);
		}
		return result;
	}

	public static boolean exist(String key) {
		Jedis jedis = null;
		try {
			jedis = pool.getResource();
			return jedis.exists(key);
		} catch (Exception e) {
			jedis.close();
			throw e;
		} finally {
			returnResource(pool, jedis);
		}
	}

	public static void zRem(String key, String field) {
		Jedis jedis = null;
		try {
			jedis = pool.getResource();
			jedis.zrem(key, field);
		} catch (Exception e) {
			jedis.close();
			throw e;
		} finally {
			returnResource(pool, jedis);
		}
	}

	public static Set<String> zrange(String key, int start, int end) {
		Jedis jedis = null;
		Set<String> ranges = new HashSet<String>();
		try {
			jedis = pool.getResource();
			ranges = jedis.zrange(key, start, end);
		} catch (Exception e) {
			jedis.close();
			throw e;
		} finally {
			returnResource(pool, jedis);
		}
		return ranges;
	}

	public static Set<String> zrangeByScore(String key, Double min, Double max,
			int offset, int count) {
		Jedis jedis = null;
		Set<String> ranges = new HashSet<String>();
		try {
			jedis = pool.getResource();
			ranges = jedis.zrangeByScore(key, min, max, offset, count);
		} catch (Exception e) {
			jedis.close();
			throw e;
		} finally {
			returnResource(pool, jedis);
		}
		return ranges;
	}

	public static Set<String> zrevrangeByScore(String key, Double max,
			Double min, int offset, int count) {
		Jedis jedis = null;
		Set<String> ranges = new HashSet<String>();
		try {
			jedis = pool.getResource();
			ranges = jedis.zrevrangeByScore(key, max, min, offset, count);
		} catch (Exception e) {
			jedis.close();
			throw e;
		} finally {
			returnResource(pool, jedis);
		}
		return ranges;
	}

	public static long zcard(String key) {
		Jedis jedis = null;
		long count = 0l;
		try {
			jedis = pool.getResource();
			count = jedis.zcard(key);
		} catch (Exception e) {
			jedis.close();
			throw e;
		} finally {
			returnResource(pool, jedis);
		}
		return count;
	}

	public static long lpush(String key, String value) {
		Jedis jedis = null;
		long count = 0l;
		try {
			jedis = pool.getResource();
			count = jedis.lpush(key, value);
		} catch (Exception e) {
			jedis.close();
			throw e;
		} finally {
			returnResource(pool, jedis);
		}
		return count;
	}

	public static long rpush(String key, String value) {
		Jedis jedis = null;
		long count = 0l;
		try {
			jedis = pool.getResource();
			count = jedis.rpush(key, value);
		} catch (Exception e) {
			jedis.close();
			throw e;
		} finally {
			returnResource(pool, jedis);
		}
		return count;
	}

	public static long lrem(String key, String value) {
		Jedis jedis = null;
		long count = 0l;
		try {
			jedis = pool.getResource();
			count = jedis.lrem(key, 0, value);
		} catch (Exception e) {
			jedis.close();
			throw e;
		} finally {
			returnResource(pool, jedis);
		}
		return count;
	}

	public static List<String> lrange(String key, int start, int count) {
		Jedis jedis = null;
		List<String> ranges = null;
		try {
			jedis = pool.getResource();
			ranges = jedis.lrange(key, start, count);
		} catch (Exception e) {
			jedis.close();
			throw e;
		} finally {
			returnResource(pool, jedis);
		}
		return ranges;
	}

	public static long del(String key) {
		Jedis jedis = null;
		long delCount = 0l;
		try {
			jedis = pool.getResource();
			delCount = jedis.del(key);
		} catch (Exception e) {
			jedis.close();
			throw e;
		} finally {
			returnResource(pool, jedis);
		}
		return delCount;
	}

	public static Set<String> keys(String pattern) {
		Jedis jedis = null;
		Set<String> setKeys = null;
		try {
			jedis = pool.getResource();
			setKeys = jedis.keys(pattern);
		} catch (Exception e) {
			jedis.close();
			throw e;
		} finally {
			returnResource(pool, jedis);
		}
		return setKeys;
	}
	/**
	 * 批量删除Key
	 * @param pattern 匹配pattern*
	 */
	public static void delKeys(String pattern){
		Set<String> keys=RedisUtil.keys(pattern+"*");
		for(String key:keys){
			RedisUtil.del(key);
		}
	}
	public static Long ttl(String key) {
		Jedis jedis = null;
		Long seconds = 0L;
		try {
			jedis = pool.getResource();
			seconds = jedis.ttl(key);
		} catch (Exception e) {
			jedis.close();
			throw e;
		} finally {
			returnResource(pool, jedis);
		}
		return seconds;
	}
	public Set<String> hkeys(String key) {
		Jedis jedis = null;
		Set<String> hks= null;
		try {
			jedis = pool.getResource();
			hks=jedis.hkeys(key);
		} catch (Exception e) {
			jedis.close();
			throw e;
		} finally {
			returnResource(pool, jedis);
		}
		return hks;
	}
	
	public static void hmset(String key,Map<String,String> hash) {
		Jedis jedis = null;
		try {
			jedis = pool.getResource();
			jedis.hmset(key, hash);
		} catch (Exception e) {
			jedis.close();
			throw e;
		} finally {
			returnResource(pool, jedis);
		}
	}
	
	public static <T> Map<String,T> hgetAllMap(String key,Class<T> clz) {
		Jedis jedis = null;
		try {
			jedis = pool.getResource();
			Map<String,String> mapStr=jedis.hgetAll(key);
			Map<String,T> map=new HashMap<String,T>();
			for(String field:mapStr.keySet()){
				map.put(field, JSONObject.parseObject(mapStr.get(field), clz));
			}
			return map;
		} catch (Exception e) {
			jedis.close();
			throw e;
		} finally {
			returnResource(pool, jedis);
		}
	}
}
