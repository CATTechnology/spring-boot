package top.takefly.boot.frame.event;

import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;

/**
 * @description:
 * @author: lingfei_dai
 * @time: 2020/7/17 14:37
 */
@Configuration
public class LoadComponent implements ApplicationListener<ContextRefreshedEvent> {
    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        System.out.println("容器启动开始加载自定义组件");
    }
}
