package com.lishuangqi.common;

import org.quartz.SchedulerException;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

/**
 * Created by michael on 2017/9/26.
 * 在startQuartz中用到SchedulerFactoryBeanWithShutdownDelay是因为当Tomcat被关闭时，有可能导致任务线程并未完全关闭，导致内存泄漏。
 */
public class SchedulerFactoryBeanWithShutdownDelay extends SchedulerFactoryBean {
    @Override
    public void destroy() throws SchedulerException {
        super.destroy();


        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}