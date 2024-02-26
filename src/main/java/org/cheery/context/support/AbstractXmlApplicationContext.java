package org.cheery.context.support;

import org.cheery.beans.factory.support.DefaultListableBeanFactory;
import org.cheery.beans.factory.xml.XmlBeanDefinitionReader;

/**
 * Convenient base class for {@link org.cheery.context.ApplicationContext}
 * implementations, drawing configuration from XML documents containing bean definitions
 * understood by an {@link org.cheery.beans.factory.xml.XmlBeanDefinitionReader}.
 *
 */
public abstract class AbstractXmlApplicationContext extends AbstractRefreshableApplicationContext {

    @Override
    protected void loadBeanDefinitions(DefaultListableBeanFactory beanFactory) {
        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(beanFactory, this);
        String[] configLocations = getConfigLocations();
        if (null != configLocations){
            beanDefinitionReader.loadBeanDefinitions(configLocations);
        }
    }

    protected abstract String[] getConfigLocations();

}
