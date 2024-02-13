package org.cheery.beans.factory.config;

/**
 * 单例注册接口定义和实现
 */
public interface SingletonBeanRegistry {

    //获取单例对象
    Object getSingleton(String beanName);

}
