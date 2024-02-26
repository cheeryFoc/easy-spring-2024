package org.cheery.beans.factory.support;

import org.cheery.exception.BeansException;
import org.cheery.core.io.Resource;
import org.cheery.core.io.ResourceLoader;

/**
 * 加载和注册，这两个方法的实现会包装到抽象类中，以免污染具体的接口实现方法。
 */
public interface BeanDefinitionReader {


    BeanDefinitionRegistry getRegistry();

    ResourceLoader getResourceLoader();

    void loadBeanDefinitions(Resource resource) throws BeansException;

    void loadBeanDefinitions(Resource... resources) throws BeansException;

    void loadBeanDefinitions(String location) throws BeansException;

}
