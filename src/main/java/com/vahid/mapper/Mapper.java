package com.vahid.mapper;

public interface Mapper<FROM, TO> {
    TO map(FROM from, Class<TO> toClass);
}
