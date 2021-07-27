package demo.netty.webchat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: zhouchao
 * @Date: 2021/07/27 17:36
 * @Description:
 */
@Controller
public class ChatController {
    @RequestMapping("/")
    public String chat() {
        return "chat";
    }
}
