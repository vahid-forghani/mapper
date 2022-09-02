package com.vahid.mapper;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserModel {
    String name;
    Integer age;
    Sex sex;
}
