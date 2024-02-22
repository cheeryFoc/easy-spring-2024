package org.cheery.beans.factory.support;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.NoOp;
import org.cheery.beans.exception.BeansException;
import org.cheery.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;

public class CglibSubclassingInstantiationStrategy implements InstantiationStrategy{

    @Override
    public Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor constructor, Object[] args) throws BeansException {
        // Enhancer，即(字节码)增强器。它是CGLIB库中最常用的一个类，功能与JDK动态代理中引入的Proxy类差不多，但是Enhancer既能够代理普通的Java类，也能够代理接口。不能够拦截final方法
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(beanDefinition.getBeanClass());
        // Callback，即回调。它的回调时机是生成的代理类的方法被调用的时候。也就是说，生成的代理类的方法被调用的时候，Callback的实现逻辑就会被调用。
        // NoOp，No Operation，也就是不做任何操作。这个回调实现只是简单地把方法调用委托给了被代理类的原方法(也就是调用原始类的原始方法)，不做任何其它的操作，所以不能使用在接口代理。
        enhancer.setCallback(new NoOp() {
            @Override
            public int hashCode() {
                return super.hashCode();
            }
        });
        if (null == constructor) return enhancer.create();
        return enhancer.create(constructor.getParameterTypes(), args);
    }
}
