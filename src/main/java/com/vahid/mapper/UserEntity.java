package com.vahid.mapper;

import lombok.Builder;
import lombok.ToString;
import lombok.Value;

@Value
@Builder
@ToString
public class UserEntity {
    String name;
    Integer age;
    Sex sex;
}
