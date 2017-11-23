package com.lishuangqi.cache.redis;

/**
 * Created by michael on 2017/11/13.
 */
public class WsbpException extends RuntimeException {
    private static final long serialVersionUID = 426423731963168371L;

    public WsbpException() {
    }

    public WsbpException(String s) {
        super(s);
    }

    public WsbpException(String message, Throwable cause) {
        super(message, cause);
    }

    public WsbpException(Throwable cause) {
        super(cause);
    }
}
