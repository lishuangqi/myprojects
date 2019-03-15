package com.lishuangqi.service;

import com.lishuangqi.utils.DistributedLock;
import com.lishuangqi.utils.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * Created by michael on 2019/3/15.
 */
@Component
public class TestService {
    @Autowired
    DistributedLock lock;

    int n = 50;
    private static final String LOCK_KEY = "lock_key1";

    public void seckill() {
        long starttime = System.currentTimeMillis();
        UUID uuid = UUID.randomUUID();
        // 返回锁的value值，供释放锁时候进行判断
        boolean lock_key1 = lock.getLock(LOCK_KEY, uuid.toString(), 10);
        while (!lock_key1) {
            try {
                Thread.sleep(1000);
                lock_key1 = lock.getLock(LOCK_KEY, uuid.toString(), 10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(Thread.currentThread().getName() + "获得了锁");
        System.out.println(--n);
        lock.releaseLock(LOCK_KEY, uuid.toString());
        long endtime = System.currentTimeMillis();
        System.out.println((endtime -starttime)/1000 +"s 执行时间");
    }
}
