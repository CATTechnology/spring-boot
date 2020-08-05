package top.takefly.boot.frame.properties;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

/**
 * @description:
 * @author: lingfei_dai
 * @time: 2020/7/14 16:52
 */
@Configuration
@ConfigurationProperties(prefix = "my")
@Data
public class MyProperties {

    private String secret;
    private Integer number;
    private Long bignumber;
    private String uuid;
    private Map map;
    private String[] addr;

    @Value("${my.password}")
    private String passWord;
}
