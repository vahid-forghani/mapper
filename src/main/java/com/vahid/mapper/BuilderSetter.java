package com.vahid.mapper;

import lombok.RequiredArgsConstructor;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

@RequiredArgsConstructor
public class BuilderSetter implements Setter{

    private final Object builder;

    @Override
    public void set(Object from, Field field) {
        try {
            builder.getClass().getMethod(field.getName(), field.getType()).invoke(builder, field.get(from));
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Object get() {
        try {
            return builder.getClass().getMethod("build").invoke(builder);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return null;
    }
}
