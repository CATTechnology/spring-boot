package top.takefly.boot;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cache.annotation.EnableCaching;

/**
 * @description:
 * @author: lingfei_dai
 * @time: 2020/7/13 14:49
 */
@SpringBootApplication
@EnableCaching //开启缓存
//@ImportResource({"application.xml"})//导入配置
public class BootApplication {

    public static void main(String[] args) {
        //启动方式一
        SpringApplication.run(BootApplication.class,args);
        //启动方式二
//        SpringApplication springApplication = new SpringApplication(Application.class);
        //设置延时加载
//        springApplication.setLazyInitialization(true);
//        springApplication.run(args);
        //启动方式三
//        new SpringApplicationBuilder().sources(BootApplication.class).bannerMode(Banner.Mode.CONSOLE).lazyInitialization(false).run(args);

    }
}
