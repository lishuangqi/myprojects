package com.lishuangqi.service;

import com.lishuangqi.redisLock.Lock;
import com.lishuangqi.redisLock.LockKey;
import com.lishuangqi.utils.DistributedLock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.UUID;

/**
 * Created by michael on 2019/3/15.
 */
@Component
public class TestService {
    private static Logger LOGGER = LoggerFactory.getLogger(TestService.class);

    @Autowired
    DistributedLock lock;

    int n = 50;
    private static final String LOCK_KEY = "lock_key1";
    final Random random = new Random();

    public void seckill() {
        long starttime = System.currentTimeMillis();
        UUID uuid = UUID.randomUUID();
        // 返回锁的value值，供释放锁时候进行判断
        boolean lock_key1 = lock.getLock(LOCK_KEY, uuid.toString(), 10);
        while (!lock_key1) {
            sleep(10, 50000);
            lock_key1 = lock.getLock(LOCK_KEY, uuid.toString(), 10);
        }

        System.out.println(Thread.currentThread().getName() + "获得了锁");
        System.out.println(--n);
        lock.releaseLock(LOCK_KEY, uuid.toString());
        long endtime = System.currentTimeMillis();
        System.out.println((endtime -starttime) +"ms 执行时间");
    }

    @Lock(lockTime = 30)
    public void testLock(@LockKey String id) {
        long starttime = System.currentTimeMillis();
        System.out.println(Thread.currentThread().getName() + "获得了锁");
        System.out.println(--n);
        long endtime = System.currentTimeMillis();
        System.out.println((endtime -starttime) +"ms 执行时间");
    }

    public void testNoLock(String id) {
        long starttime = System.currentTimeMillis();
        System.out.println(Thread.currentThread().getName() + "获得了锁");
        System.out.println(--n);
        long endtime = System.currentTimeMillis();
        System.out.println((endtime -starttime) +"ms 执行时间");
    }

    /**
     * 线程等待时间
     *
     * @param millis 毫秒
     * @param nanos  纳秒
     */
    private void sleep(long millis, int nanos) {
        try {
            Thread.sleep(millis, random.nextInt(nanos));
        } catch (InterruptedException e) {
            LOGGER.info("获取分布式锁休眠被中断：", e);
        }
    }
}
