package com.vahid.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final Mapper<UserModel, UserEntity> mapper;

    public void doSomething() {
        System.out.println(mapper.map(UserModel.builder().sex(Sex.MALE).age(35).name("vahid").build(), UserEntity.class));
    }

}
