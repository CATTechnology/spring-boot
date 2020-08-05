package top.takefly.boot.frame.processor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.env.PropertySource;

/**
 * @description:
 * @author: lingfei_dai
 * @time: 2020/7/14 17:31
 */
public class MyEnvironmentProcessor implements EnvironmentPostProcessor {

    @Override
    public void postProcessEnvironment(ConfigurableEnvironment environment, SpringApplication application) {
        MutablePropertySources propertySources = environment.getPropertySources();
        for (PropertySource<?> propertySource : propertySources) {
            System.out.println(propertySource.getName());
            System.out.println(propertySource.getSource());
        }
    }
}
