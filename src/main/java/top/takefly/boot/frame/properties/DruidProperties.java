package top.takefly.boot.frame.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @description:
 * @author: lingfei_dai
 * @time: 2020/7/21 17:36
 */
@Data
@Configuration("druidDataSourceProperties")
@ConfigurationProperties(prefix="spring.datasource.druid")
public class DruidProperties {

    private String username;

    private String password;


    private String jdbcUrl;

    private String driverClassName;

    private Integer initialSize;

    private Integer maxActive;

    private Integer minIdle;

    private long maxWait;

    private boolean poolPreparedStatements;

}
