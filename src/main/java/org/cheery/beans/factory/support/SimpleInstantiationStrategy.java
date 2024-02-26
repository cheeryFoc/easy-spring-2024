package org.cheery.beans.factory.support;

import org.cheery.exception.BeansException;
import org.cheery.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 单利实例化策略
 */
public class SimpleInstantiationStrategy implements InstantiationStrategy {

    /**
     * 实例化 JDK实现
     * @param beanDefinition
     * @param beanName
     * @param constructor
     * @param args
     * @return
     * @throws BeansException
     */
    @Override
    public Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor constructor, Object[] args) throws BeansException {
        //Class 信息是在 Bean 定义的时候传递进去的。
        Class classInstance = beanDefinition.getBeanClass();
        try {
            // constructor 是否为空，如果为空则是无构造函数实例化
            if (null != constructor) {
                //入参信息传递给 newInstance 进行实例化。
                return classInstance.getDeclaredConstructor(constructor.getParameterTypes()).newInstance(args);
            } else {
                return classInstance.getDeclaredConstructor().newInstance();
            }
        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            throw new BeansException("Failed to instantiate [" + classInstance.getName() + "]", e);
        }
    }
    
}
