package com.test.flume;

/**
 * Created by michael on 2018/3/30.
 */
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.apache.flume.Context;
import org.apache.flume.Event;
import org.apache.flume.event.EventBuilder;
import org.apache.flume.interceptor.Interceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
public class LogFormatInterceptor implements Interceptor {
    private static final Logger logger = LoggerFactory.getLogger(LogFormatInterceptor.class);
    private SimpleDateFormat sd = null;
    private SimpleDateFormat sh = null;
    private SimpleDateFormat sm = null;
    public LogFormatInterceptor() {
    }
    public void close() {
    }
    public void initialize() {
        sd = new SimpleDateFormat("yyyyMMdd");
        sh = new SimpleDateFormat("HH");
        sm = new SimpleDateFormat("mm");
    }
    public Event intercept(Event event) {
        try {
            Map<String, String> headers = event.getHeaders();
            String body = new String(event.getBody());
            Date date = new Date();
            headers.put("dayStr", sd.format(date));
            headers.put("hourStr", sh.format(date));
            Integer m = Integer.parseInt(sm.format(date));
            String min = "";
            if (m >= 0 && m < 10) {
                min = "0" + (m / 5) * 5;
            } else {
                min = (m / 5) * 5 + "";
            }
            headers.put("minStr", min);
            Event e = EventBuilder.withBody(body.getBytes(), headers);
            return e;
        } catch (Exception e) {
            logger.error("LogFormat error!", e);
        }
        return null;
    }
    public List<Event> intercept(List<Event> events) {
        List<Event> list = new LinkedList<Event>();
        for (Event event : events) {
            Event e = intercept(event);
            if (e != null) {
                list.add(e);
            }
        }
        return list;
    }
    /**
     * Builder which builds new instances of the HostInterceptor.
     */
    public static class Builder implements Interceptor.Builder {
        public Interceptor build() {
            return new LogFormatInterceptor();
        }
        public void configure(Context context) {}
    }
}