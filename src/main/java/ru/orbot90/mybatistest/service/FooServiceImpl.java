package ru.orbot90.mybatistest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.orbot90.mybatistest.mapper.UserMapper;
import ru.orbot90.mybatistest.model.User;

/**
 * Created by orbot on 19.06.16.
 */
@Service
public class FooServiceImpl implements FooService {

    @Autowired
    private UserMapper userMapper;

    @Override
    @Transactional
    public User doSomeBusinessStuff(String userId) {
        return userMapper.getUserById(userId);
    }
}
