package com.lishuangqi.controller;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by michael on 2018/3/9.
 * 法2: 写一个BaseController，每一个需要处理的controller继承这个BaseController，
 * 在BaseController里使用@InitBinder写一个全局转换日期方法：
 */
public class BaseController {
    @InitBinder
    public void initBinder(ServletRequestDataBinder binder) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
    }
}
