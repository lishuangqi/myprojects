package com.lishuangqi.test.thead.proconsumer;

/**
 * @Author: lishuanqgi
 * @ClassName:
 * @Date: 2021/2/22 10:41
 * @Description:
 */
public interface AbstractStorage {
    void consume(int num);
    void produce(int num);
}
