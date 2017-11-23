package com.lishuangqi.service.impl;

import com.lishuangqi.service.MyTestService;
import com.lishuangqi.utils.Logger;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * Created by michael on 2017/11/10.
 */
@Service(value = "myTestService")
public class MyTestServiceImpl implements MyTestService {

    @Override
//    @Scheduled(cron = "0 0/1 * * * ?")
    public void executeClearData() {
        Logger.debug("Start execute ClearData");
        System.out.println("Start execute ClearData");
    }
}
