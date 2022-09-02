package com.vahid.mapper;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

@Slf4j
public class NormalSetter implements Setter {

    private final Object object;
    private final Class clazz;

    public NormalSetter(Class clazz) {
        this.clazz = clazz;
        Object object;
        try {
            object = clazz.getDeclaredConstructor().newInstance();
        } catch (NoSuchMethodException e) {
            log.error("no default constructor found for " + clazz.getName());
            object = null;
        } catch (InstantiationException e) {
            log.error("cannot instantiate the constructor");
            object = null;
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
            object = null;
        }
        this.object = object;
    }

    @Override
    public void set(Object from, Field field) {
        try {
            clazz.getMethod(getSetterName(field.getName()), field.getType()).invoke(object, field.get(from));
        } catch (NoSuchMethodException e) {
            log.error("no setter found for " + field.getName());
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    private String getSetterName(String name) {
        return "set" + name.substring(0, 1).toUpperCase() + name.substring(1);
    }

    @Override
    public Object get() {
        return object;
    }
}
