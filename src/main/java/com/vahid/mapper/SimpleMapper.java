package com.vahid.mapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

@Component
@RequiredArgsConstructor
@Slf4j
public class SimpleMapper<FROM, TO> implements Mapper<FROM, TO> {

    @Override
    public TO map(FROM from, Class<TO> toClass) {
        Setter setter = provideSetter(toClass);
        for (Field field: from.getClass().getDeclaredFields()) {
            setter.set(from, field);
        }
        return (TO)setter.get();
    }

    private Setter provideSetter(Class<TO> toClass) {
        try {
            return new BuilderSetter(toClass.getMethod("builder").invoke(null));
        } catch (NoSuchMethodException e) {
            log.info("no builder found for " + toClass.getName() + ", switch to setter mode");
            return new NormalSetter(toClass);
        } catch (InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
}
