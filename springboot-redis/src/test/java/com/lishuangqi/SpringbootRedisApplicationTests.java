package com.lishuangqi;

import com.lishuangqi.utils.RedisUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootRedisApplicationTests {
	@Autowired
	RedisUtils redisUtils;

	@Test
	public void contextLoads() {
	}

	private static final String LOCK_KEY = "lock_key";

	@Test
	public void setRedisLock() {
		UUID uuid = UUID.randomUUID();
		redisUtils.set("test", "test");
		boolean lock = redisUtils.getLock(LOCK_KEY, uuid.toString(), 100);
		System.out.println(lock);
		boolean lock1 = redisUtils.releaseLock(LOCK_KEY, uuid.toString());
		System.out.println(lock1);
	}
}
