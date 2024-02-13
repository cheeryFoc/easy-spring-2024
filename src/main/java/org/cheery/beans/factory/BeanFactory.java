package org.cheery.beans.factory;

import org.cheery.beans.exception.BeansException;

public interface BeanFactory {

    Object getBean(String name) throws BeansException;

}
