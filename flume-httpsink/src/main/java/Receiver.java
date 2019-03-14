import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

@Controller
@EnableAutoConfiguration
public class Receiver {
    private static final Log LOG = LogFactory.getLog(Receiver.class);


    @RequestMapping("/test")
    void getData(HttpServletRequest request, HttpServletResponse response) throws IOException {


        BufferedReader br = request.getReader();

        String str, wholeStr = "";
        while ((str = br.readLine()) != null) {
            wholeStr += str;
        }

//        MessageWriter.sendMessage(wholeStr);
//        LOG.info("receive message :" + wholeStr);

    }
}
