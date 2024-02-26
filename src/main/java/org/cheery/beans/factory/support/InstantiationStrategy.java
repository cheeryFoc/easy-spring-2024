package org.cheery.beans.factory.support;

import org.cheery.exception.BeansException;
import org.cheery.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;

/**
 * 实例化策略接口
 */
public interface InstantiationStrategy {

    /**
     * 实例化bean
     * @param beanDefinition bean定义
     * @param beanName bean名称
     * @param constructor 构造器
     * @param args 参数
     * @return
     * @throws BeansException
     */
    Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor constructor, Object[] args) throws BeansException;


}



