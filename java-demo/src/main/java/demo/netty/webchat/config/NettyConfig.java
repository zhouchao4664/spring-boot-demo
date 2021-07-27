package demo.netty.webchat.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Author: zhouchao
 * @Date: 2021/07/27 17:37
 * @Description:
 */
@Component
@Data
@ConfigurationProperties(prefix = "netty")
public class NettyConfig {
    private int port;
    private String path;
}
