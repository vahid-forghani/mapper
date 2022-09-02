package com.vahid.mapper;

import java.lang.reflect.Field;

public interface Setter {
    void set(Object from, Field field);
    Object get();
}
