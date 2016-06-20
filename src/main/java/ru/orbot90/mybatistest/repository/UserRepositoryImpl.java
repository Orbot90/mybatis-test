package ru.orbot90.mybatistest.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.orbot90.mybatistest.mapper.UserMapper;
import ru.orbot90.mybatistest.model.UserEntity;

/**
 * Created by root on 20.06.16.
 */
@Repository
public class UserRepositoryImpl implements UserRepositoryCustom {

    @Autowired
    private UserMapper userMapper;

    @Override
    @Transactional(readOnly = true)
    public UserEntity findByIdThroughMybatis(String id) {
        return userMapper.getUser(id);
    }
}
