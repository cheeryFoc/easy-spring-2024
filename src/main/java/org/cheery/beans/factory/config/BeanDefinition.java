package org.cheery.beans.factory.config;

import org.cheery.beans.value.PropertyValues;

/** BeanDefinition
 * Created by cheery on 2017/4/11.
 * 用于定义 Bean 实例化信息
 */
@SuppressWarnings({"rawtypes"})
public class BeanDefinition {

    // 对象信息
    private Class beanClass;

    // 属性填充信息
    private PropertyValues propertyValues;

    public BeanDefinition(Class beanClass) {
        this.beanClass = beanClass;
        this.propertyValues = new PropertyValues();
    }

    public BeanDefinition(Class beanClass, PropertyValues propertyValues) {
        this.beanClass = beanClass;
        //避免后面还得判断属性填充是否为空。
        this.propertyValues = propertyValues != null ? propertyValues : new PropertyValues();
    }

    public Class getBeanClass() {
        return beanClass;
    }

    public void setBeanClass(Class beanClass) {
        this.beanClass = beanClass;
    }

    public PropertyValues getPropertyValues() {
        return propertyValues;
    }

    public void setPropertyValues(PropertyValues propertyValues) {
        this.propertyValues = propertyValues;
    }
}
