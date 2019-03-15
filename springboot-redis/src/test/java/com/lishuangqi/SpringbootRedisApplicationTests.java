package com.lishuangqi;

import com.lishuangqi.service.TestService;
import com.lishuangqi.utils.DistributedLock;
import com.lishuangqi.utils.RedisUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootRedisApplicationTests {
    @Autowired
    RedisUtils redisUtils;
    @Autowired
    DistributedLock distributedLock;
	@Autowired
	TestService testService;

    @Test
    public void contextLoads() {
    }

    private static final String LOCK_KEY = "lock_key";

    @Test
    public void setRedisLock() {
        UUID uuid = UUID.randomUUID();
//		redisUtils.set("test", "test");
        boolean lock = distributedLock.getLock(LOCK_KEY, uuid.toString(), 10);
        System.out.println(lock);
        boolean lock1 = distributedLock.releaseLock(LOCK_KEY, uuid.toString());
        System.out.println(lock1);
    }

    @Test
    public void testMutilTheadLock() {
        ExecutorService newCachedThreadPool = Executors.newFixedThreadPool(50);

        for (int i = 0; i < 50; i++) {
//            TestService testService = new TestService();
            ThreadA threadA = new ThreadA(testService);
//			threadA.start();

            newCachedThreadPool.execute(threadA);
        }
    }

    public class ThreadA extends Thread {
        private TestService service;

        public ThreadA(TestService service) {
            this.service = service;
        }

        @Override
        public void run() {
            service.seckill();
        }
    }

}
