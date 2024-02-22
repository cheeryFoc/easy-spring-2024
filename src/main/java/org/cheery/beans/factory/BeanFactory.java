package org.cheery.beans.factory;

import org.cheery.beans.exception.BeansException;

public interface BeanFactory {

    Object getBean(String name) throws BeansException;

    /**
     * 获取bean 有参构造
     * @param name
     * @param args
     * @return
     * @throws BeansException
     */
    Object getBean(String name, Object... args) throws BeansException;

}
