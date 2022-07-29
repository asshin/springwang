package com.wang.springframework.beans.factory;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zsw
 * @create 2022-07-28 19:52
 */
public class PropertyValues {
    private List<PropertyValue> propertyValueList =new ArrayList<PropertyValue>();

    public PropertyValue[] getPropertyValues() {
        return (PropertyValue[]) propertyValueList.toArray(new PropertyValue[0]);
    }

     public void  addPropertyValue(PropertyValue propertyValue){
         propertyValueList.add(propertyValue);

     }
     public PropertyValue getPropertyValue(String propertyName){
         for (PropertyValue propertyValue : propertyValueList) {
             if(propertyValue.getName().equals(propertyName)){
                 return  propertyValue;
             }

         }
        return null;
     }
}
