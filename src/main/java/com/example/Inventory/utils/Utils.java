package com.example.Inventory.utils;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.stereotype.Component;

import java.beans.PropertyDescriptor;
import java.util.HashSet;
import java.util.Set;

@Component
public class Utils {
    public  void  mergeEntities(Object existingEntity, Object updateEntity){
        BeanUtils.copyProperties(updateEntity,existingEntity,getNullPropertyNames(updateEntity));
    }

    private String[] getNullPropertyNames(Object source) {
        final BeanWrapper src = new BeanWrapperImpl(source);
        PropertyDescriptor[] pds = src.getPropertyDescriptors();
        Set<String> emptyNames = new HashSet<>();
        for(PropertyDescriptor pd : pds){
            Object srcValue = src.getPropertyValue(pd.getName());
            if(srcValue == null ||
                    (srcValue instanceof Integer && (Integer) srcValue == 0) ||
                    (srcValue instanceof Float && (Float) srcValue == 0.0f) ||
                    (srcValue instanceof Double && (Double) srcValue == 0.0)){
                emptyNames.add(pd.getName());
            }
        }
        String[] result = new String[emptyNames.size()];
        return emptyNames.toArray(result);
    }
}
