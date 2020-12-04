package mre.spring.facture.utils;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationTargetException;

@Component
public class ServiceUtils<T> {

    public T copyProperties(T entityDest, T entitySource) {
        try {
            BeanUtils.copyProperties(entityDest, entitySource);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

        return entityDest;
    }

}
