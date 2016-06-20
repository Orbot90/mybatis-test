package ru.orbot90.mybatistest.repository;

import ru.orbot90.mybatistest.model.UserEntity;

/**
 * Created by root on 20.06.16.
 */
public interface UserRepositoryCustom {

    UserEntity findByIdThroughMybatis(String id);
}
