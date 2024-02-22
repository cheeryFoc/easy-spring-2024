package org.cheery.beans.value;

import java.util.ArrayList;
import java.util.List;
import org.cheery.beans.value.PropertyValue;

/**
 * Created by cheery on 2017/5/11.
 * 保存类变量数据的一个类，可能有多个属性值，用了List来存储属性值
 */
public class PropertyValues {

    private final List<PropertyValue> propertyValueList = new ArrayList<>();

    public void addPropertyValue(PropertyValue pv) {
        this.propertyValueList.add(pv);
    }

    public PropertyValue[] getPropertyValues() {
        return this.propertyValueList.toArray(new PropertyValue[0]);
    }

    public PropertyValue getPropertyValue(String propertyName) {
        for (PropertyValue pv : this.propertyValueList) {
            if (pv.getName().equals(propertyName)) {
                return pv;
            }
        }
        return null;
    }

}
