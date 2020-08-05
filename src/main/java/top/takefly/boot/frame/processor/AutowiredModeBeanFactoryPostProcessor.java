package top.takefly.boot.frame.processor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: lingfei_dai
 * @time: 2020/7/13 17:16
 */
@Component
@Slf4j
public class AutowiredModeBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    public AutowiredModeBeanFactoryPostProcessor() {
    }

    @Autowired
    public AutowiredModeBeanFactoryPostProcessor(ApplicationArguments arguments) {
        log.info("AutowiredModeBeanFactoryPostProcessor 加载成功!!! ");
        log.info("应用入参 [{}]加载成功!!! ", arguments.getSourceArgs());
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        GenericBeanDefinition userController = (GenericBeanDefinition) configurableListableBeanFactory.getBeanDefinition("userController");
        userController.setAutowireMode(AbstractBeanDefinition.AUTOWIRE_BY_TYPE);
    }
}
