package com.dmdevstudy.lessons.bpp;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.util.ReflectionUtils;

import java.util.Arrays;

public class InjectBeanPostProcessor implements BeanPostProcessor, ApplicationContextAware {
    private ApplicationContext applicationContext;
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        // выбираем все поля поданоого в метод бина - >
        // фильтруем по тем полям над которыми есть наша кастомная аннотация InjectBean
        Arrays.stream(bean.getClass().getDeclaredFields())
                .filter(field->field.isAnnotationPresent(InjectBean.class))
                .forEach(field -> {
                    Object beanToInject = applicationContext.getBean(field.getType());
                    ReflectionUtils.makeAccessible(field);//аналогично field.setAccessible(true);
                    ReflectionUtils.setField(field, bean, beanToInject);  // аналогично field.set(bean, beanToInject);
                });
        return bean;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext=applicationContext;
    }
}
