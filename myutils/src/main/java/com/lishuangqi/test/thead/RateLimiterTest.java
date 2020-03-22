package com.lishuangqi.test.thead;

import com.google.common.util.concurrent.RateLimiter;

public class RateLimiterTest {
    public static void main(String[] args) {
        RateLimiter limiter = RateLimiter.create(5);
        System.out.println(limiter.acquire());
        System.out.println(limiter.acquire());
        System.out.println(limiter.acquire());
        System.out.println(limiter.acquire());
        System.out.println(limiter.acquire());
        System.out.println(limiter.acquire(5));
        System.out.println(limiter.acquire());
        System.out.println(limiter.acquire());
    }
}
