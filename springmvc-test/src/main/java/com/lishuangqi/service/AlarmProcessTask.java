package com.lishuangqi.service;

import com.alibaba.fastjson.JSONObject;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * Created by michael on 2018/1/28.
 */
@Component
public class AlarmProcessTask implements MessageListener {
    /**
     *
     */
    private static final long serialVersionUID = -7881564340234460359L;
//    @Autowired
//	private GetAlarmInfoService getAlarmInfoService;
    private static DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");

    @SuppressWarnings("unchecked")
    @Override
    public void onMessage(Message message) {
        String msg;
        try {
            msg = new String(message.getBody(),"UTF-8");
            System.out.println(msg);
            JSONObject object = JSONObject.parseObject(msg);

            // hkws声光报警sdk触发
//        	NativeLong one=new NativeLong(0x00ffl);
//        	NativeLong two=new NativeLong(1l);
//            getAlarmInfoService.alramControl(one,two);

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
