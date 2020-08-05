package top.takefly.boot.frame.listeners;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @description:
 * @author: lingfei_dai
 * @time: 2020/7/13 17:02
 */
public class StarterListener extends ApplicationStartedEvent {

    /**
     * Create a new {@link ApplicationStartedEvent} instance.
     *
     * @param application the current application
     * @param args        the arguments the application is running with
     * @param context     the context that was being created
     */
    public StarterListener(SpringApplication application, String[] args, ConfigurableApplicationContext context) {
        super(application, args, context);
//        ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();
//        GenericBeanDefinition userController = (GenericBeanDefinition) beanFactory.getBeanDefinition("userController");
//        userController.setAutowireMode(AbstractBeanDefinition.AUTOWIRE_BY_TYPE);
    }


}
