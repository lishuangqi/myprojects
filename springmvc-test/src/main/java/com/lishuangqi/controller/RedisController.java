package com.lishuangqi.controller;

import com.lishuangqi.cache.ICaheManager;
import com.lishuangqi.common.redis.CacheManagerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author michael
 * @date 2017/11/13
 */
@RequestMapping("/redis")
@Controller
public class RedisController {
    private static final String PATH_URL = "/redis/";
    private static ICaheManager redisService = CacheManagerFactory.getCentralizedCacheManager();

    @RequestMapping("/index")
    public ModelAndView index(){
        ModelAndView mv = new ModelAndView();
//        redisService.set("test_lsq", "test_lsq");
        String test_lsq = redisService.get("test_lsq");
        mv.addObject("data1", test_lsq);
        mv.setViewName(PATH_URL+"index");
        return mv;
    }
}
