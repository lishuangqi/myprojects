package com.lishuangqi.cache.api;

/**
 * Created by michael on 2017/11/13.
 */
public class CacheException extends RuntimeException {
    private static final long serialVersionUID = 426423731963168371L;

    public CacheException() {
    }

    public CacheException(String s) {
        super(s);
    }

    public CacheException(String message, Throwable cause) {
        super(message, cause);
    }

    public CacheException(Throwable cause) {
        super(cause);
    }
}
